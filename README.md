# aws-lambda-vertx-native

### Custom Vert.x Native for AWS Lambda

*Disclaimer - This project should be considered a POC and has not been tested or verified for production use.
If you decided to run this on production systems you do so at your own risk.*

### Building this Runtime


#### Prerequisites

Make sure you have the following installed on your build machine before getting started.

* GraalVM
* AWS CLI

##### Compile the Runtime Classes

```
$ ./mvnw package
```

#### Create the Lambda Custom Runtime Entry Point

AWS Lambda Custom Runtimes require an executable file in the root directory named simply ```bootstrap```. This can be any executable file, for our case we're going to just use
a shell script to call our launcher that we created in the step above. This script will do nothing more than invoke our Java Runtime from the dist folder.

##### Create the bootstrap script
```
$ touch boostrap
```
##### Call our Java Runtime from Bash

Add the following commands to the ```bootstrap```
```$bash
#!/bin/sh
/opt/target/lambda
```

Note that the path we're using in our shell script is ```/opt```. When you create a Lambda Layer, as we'll do shortly, AWS Lambda copies all the runtime files to the ```/opt``` directory. This directory is effectively the home directory for our custom runtime.

##### Make bootstrap executable
```
$ chmod +x bootstrap
```

##### Create a deployment package

In the root of the folder containing our ```bootstrap``` and ```target/lambda``` files, create a zip archive containing the artifacts.

```
$ zip -r function.zip bootstrap target/lambda
```

### Deploying to AWS Lambda

#### Create a lambda role

```
aws iam create-role \
    --role-name lambda-role \
    --path "/service-role/" \
    --assume-role-policy-document file:///tmp/trust-policy.json
```

Where the file `/tmp/trust-policy.json` contains:

```json
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Principal": {
        "Service": "lambda.amazonaws.com"
      },
      "Action": "sts:AssumeRole"
    }
  ]
}
```

#### Publish a lambda layer

```
aws lambda publish-layer-version \
    --layer-name vertx-native-example \
    --zip-file fileb://function.zip
```

#### Create a function

```
aws lambda delete-function --function-name vertxNativeTester

aws lambda create-function --function-name vertxNativeTester \
    --zip-file fileb://function.zip --handler lambda.EchoLambda --runtime provided \
    --role arn:aws:iam::985727241951:role/service-role/lambda-role
```

#### Link the layer to the function

```
aws lambda update-function-configuration --function-name vertxNativeTester --layers arn:aws:lambda:eu-central-1:985727241951:layer:vertx-native-example:8
```

#### Test it

```
aws lambda invoke --function-name vertxNativeTester  --payload '{"message":"Hello World"}' --log-type Tail response.txt | grep "LogResult"| awk -F'"' '{print $4}' | base64 --decode
```
