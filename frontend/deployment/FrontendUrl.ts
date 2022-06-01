import * as aws from "@pulumi/aws";
import {frontend} from "./Frontend"

export const frontendUrl = new aws.lambda.FunctionUrl("frontendUrl", {
    functionName: frontend.arn,
    authorizationType: "NONE",
});