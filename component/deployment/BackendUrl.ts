import * as aws from "@pulumi/aws";
import {backend} from "./Backend"
export const backendUrl = new aws.lambda.FunctionUrl("backendUrl", {
    functionName: backend.arn,
    authorizationType: "NONE",
});