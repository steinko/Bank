import * as awsx from "@pulumi/awsx";
export const vpc =  awsx.ec2.Vpc.getDefault();