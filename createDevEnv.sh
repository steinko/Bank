#!/bin/bash
//build backend
cd component 
./gradlew clean build
zipinfo build/distributions/backend.zip
cd ..

//build backend
cd frontend
npm run build-server
cd server-build
zip index.zip index.js
cd ..

//test backend
cd component 
./gradlew check
 
//test frontend
cd frontend 
export REACT_APP_USE_MSW=true
export REACT_APP_BACKEND_URL=http://localhost:9001
npm test

//deploy frontend
cd frontend
cd deployment
pulumi stack select dev
pulumi config set REACT_APP_USE_MSW false
pulumi config set REACT_APP_BACKEND_URL $(cat ../../component/deployment/backend.env)
pulumi up -y
export FRONTEND_URL=$(pulumi stack output  url)
export CYPRESS_BASE_URL=$FRONTEND_URL
export REACT_APP_FRONTEND_URL=$FRONTEND_URL
cd ../..  
  
//deploy backend 
cd database
cd deployment
pulumi stack select dev
pulumi up -y
export DATABASE_URL=jdbc:postgresql://$(pulumi stack output  endpoint)
cd ../..  
cd component 
cd deployment
pulumi stack select dev
pulumi config set DATABASE_URL $DATABASE_URL
pulumi up -y
export REACT_APP_BACKEND_URL=$(pulumi stack output  url)
cd ../..
  
 

//backend-acceptance-test
cd backendAcceptanceTest
export REACT_APP_BACKEND_URL=$(cat ../component/deployment/backend.env)
echo $REACT_APP_BACKEND_URL
./gradlew cucumber
  
   
//acceptrance-test:
cd acceptanceTest
npm ci
echo $CYPRESS_BASE_URL
npm run cypress-run
   