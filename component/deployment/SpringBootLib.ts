import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

export const springBootLib = new aws.lambda.LayerVersion("springBootLib", {
    compatibleRuntimes: ["java11"],
    code: new pulumi.asset.FileArchive("../build/libs/component.jar"),
    layerName: "springBootLib",
});