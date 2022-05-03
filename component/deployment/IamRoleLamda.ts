import * as aws from "@pulumi/aws"

export const iamRoleLamda = new aws.iam.Role("iamRoleLamda", {assumeRolePolicy: JSON.stringify({
        Version: "2012-10-17",
        Statement: [{
            Action: "sts:AssumeRole",
            Effect: "Allow",
            Sid: "",
            Principal: {
               "Service": [
                  "lambda.amazonaws.com"
                ]
            },
        }],
    }),


                                              inlinePolicies: [{
            name: "my_inline_policy",
            policy: JSON.stringify({ 
	                                  "Version": "2012-10-17",
	                                  "Statement": [{
		                                               "Effect": "Allow",
		                                               "Action": [
			                                                         "logs:PutLogEvents",
				                                                     "logs:CreateLogGroup",
				                                                     "logs:CreateLogStream",
				                                                     "logs:DescribeLogStreams",
				                                                     "logs:DescribeLogGroups",
				                                                     "xray:PutTraceSegments",
				                                                     "xray:PutTelemetryRecords",
				                                                     "xray:GetSamplingRules",
				                                                     "xray:GetSamplingTargets",
				                                                     "xray:GetSamplingStatisticSummaries",
				                                                     "ssm:GetParameters"
                                                                   ],
		                                               "Resource": "*",
	                                               }],

                                   })
                       }]
  })