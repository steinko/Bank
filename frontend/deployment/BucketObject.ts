import * as aws from "@pulumi/aws"
import * as pulumi from "@pulumi/pulumi";
import {bucket} from './Bucket'

export const bucketObject = new aws.s3.BucketObject("bankFrontendBucketObject", {
    bucket: bucket.id,
    source: new pulumi.asset.FileArchive("../server-build/index.tar"),
    key:"key"
});