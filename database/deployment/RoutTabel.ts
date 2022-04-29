import aws  from '@pulumi/aws'

import {internetGatway} from './InternetGateway'
import {vpc} from './Vpc'

export const publicRouteTable = new aws.ec2.RouteTable(`routeTable`, {
  routes: [
    {
      cidrBlock: '0.0.0.0/0',
      gatewayId: internetGatway.id
    }
  ],
  vpcId: vpc.id
})