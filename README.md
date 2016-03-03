#### Overview

A Spring xml configuration based maven project to try Amazon Web Services (AWS)'s Simple Queue Service (SQS) for publishing and receiving messages.


#### How To Setup

1. Create an SQS queue with permissions to do read/write operations (for user who's access key and secret key you have access to)
    * Make sure queue region and name match with one in application-context.xml

2. Setup aws_access_key_id and aws_secret_access_key in /UserHome/.aws/credentials file under [default] profile. Something like:

[default]
aws_access_key_id=REPLACEMEWITHYOURKEY
aws_secret_access_key=REPLACEWITHYOURSECRETKEY
	* You should be able to retrieve them from AWS Management console

3. Lookout for CHANGEME comments in application-context.xml and configure those settings according to your environment


#### How To Run

```sh
	mvn exec:java
```

#### How To Test

```sh
	mvn test
```