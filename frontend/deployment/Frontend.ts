import * as aws from "@pulumi/aws"
import * as pulumi from  "@pulumi/pulumi"
import {iamRoleLamda} from "./IamRoleLamda"

let config = new pulumi.Config();
const reactAppUseMsw  = config.require("REACT_APP_USE_MSW"); 
console.log(reactAppUseMsw)

export const frontend = new aws.lambda.Function("frontend", {
    code: new pulumi.asset.FileArchive("../server-build/index.zip"),
    role: iamRoleLamda.arn,
    runtime: "nodejs12.x",
    handler:"index.handler",
    name: "frontend",
    environment: {
        variables: {
            REACT_APP_USE_MSW: reactAppUseMsw
        },
    },
});