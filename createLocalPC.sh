#!/bin/bash
#test backend
cd component 
./gradlew check --info
 
#test frontend
cd frontend 
export REACT_APP_USE_MSW=true
export REACT_APP_BACKEND_URL=http://localhost:9001
npm test  -- --watchAll=false
   
#deploy database
cd database
cd deployment
pulumi stack select dev
pulumi up -y
export DATABASE_URL=jdbc:postgresql://$(pulumi stack output  endpoint)

#start backend
cd ../..  
cd component 
./gradlew bootRun&
cd ../..
  
#backend-acceptance-test
cd backendAcceptanceTest
echo $REACT_APP_BACKEND_URL
./gradlew cucumber --info
  
#start frontend
cd frontend
export REACT_APP_USE_MSW false
npm start&
cd ../..  
 
  
#acceptrance test:
cd acceptanceTest
export REACT_APP_FRONTEND_URL=http://localhost:3000
export CYPRESS_BASE_URL=$REACT_APP_FRONTEND_URL
echo $CYPRESS_BASE_URL
npm run cypress-run
   