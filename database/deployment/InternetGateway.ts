import * as aws from "@pulumi/aws";
import {vpc} from './Vpc'

export const internetGatway = new aws.ec2.InternetGateway("gw", {
    vpcId: vpc.id
  
});