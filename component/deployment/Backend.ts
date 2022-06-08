import * as aws from "@pulumi/aws";
import * as pulumi from "@pulumi/pulumi";
import {iamRoleLamda} from "./IamRoleLamda"
import {springBootLib} from './SpringBootLib'

let config = new pulumi.Config();
const databaseUrl  = config.require("DATABASE_URL"); 
console.log(databaseUrl)

export const backend = new aws.lambda.Function("backend", {
	name: "backend",
    code: new pulumi.asset.FileArchive("../build/distributions/backend.zip"),
    role: iamRoleLamda.arn,
    handler: "org.steinko.bank.StreamLamdaHandler",
    runtime: "java11",
    layers: [springBootLib.arn],
     environment: {
        variables: {
            DATABASE_URL: databaseUrl
        },
    },
});