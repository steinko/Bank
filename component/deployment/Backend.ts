import * as aws from "@pulumi/aws";
import * as pulumi from "@pulumi/pulumi";
import {iamRoleLamda} from "./IamRoleLamda"

let config = new pulumi.Config();
const databaseUrl  = config.require("DATABASE_URL"); 
console.log(databaseUrl)

export const backend = new aws.lambda.Function("backend", {
	name: "backend"
    code: new pulumi.asset.FileArchive("../build/libs/component.jar"),
    role: iamRoleLamda.arn,
    handler: "org.steinko.bank.WebServer",
    runtime: "java11",
     environment: {
        variables: {
            DATABASE_URL: databaseUrl
        },
    },
});