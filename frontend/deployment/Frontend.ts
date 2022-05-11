import * as aws from "@pulumi/aws"
import * as pulumi from  "@pulumi/pulumi"
import {iamRoleLamda} from "./IamRoleLamda"

export const frontend = new aws.lambda.Function("frontend", {
    code: new pulumi.asset.FileArchive("../server-build/index.zip"),
    role: iamRoleLamda.arn,
    runtime: "nodejs12.x",
    handler:"index.handler",
    name: "frontend"
});