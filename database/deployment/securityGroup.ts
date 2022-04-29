import * as aws from "@pulumi/aws";

export const securityGroup = new aws.ec2.SecurityGroup(`securityGrup`, {
  name: "dbSecurityGroup",
  ingress: [
    { protocol: 'tcp', fromPort: 5432, toPort: 5432, cidrBlocks: ['0.0.0.0/0'] }
  ],
  egress: [{
        fromPort: 0,
        toPort: 0,
        protocol: "-1",
        cidrBlocks: ["0.0.0.0/0"],
        ipv6CidrBlocks: ["::/0"],
    }],
})