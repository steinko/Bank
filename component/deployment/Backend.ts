import * as aws from "@pulumi/aws";
import * as pulumi from "@pulumi/pulumi";
import {iamRoleLamda} from "./IamRoleLamda"

export const backend = new aws.lambda.Function("backned", {
    code: new pulumi.asset.FileArchive("../build/libs/component.jar"),
    role: iamRoleLamda.arn,
    handler: "org.steinko.bank.WebServer",
    runtime: "java11",
  
});