# JerseySampleContact
It is to build a simple Java REST API service with an end point that will be able to take a users information and then store that information.

Java engineering Test - 
I was been flexible on the way you store the information but you should ensure the following criteria are met:
The data should be encrypted
Code should be unit tested
The project should be built using MVN
The project should be hosted on a GIT platform (e.g. GitHub or bitbucket)
A readme file containing building and deployment instructions
If you feel you have time:
The end point should check for malicious code being passed into it
Provide a method to decrypt the information

I hypothesized an encrypt and decrypt using "utf-8" charse,
another important thing is that in order to compile with the test cases you must create a shortcat with maven, or set the command:
clean package -Dmaven.test.skip = true

It can be done with any version of eclipse.

If, in the eventuality, the compilation from problems, you must first clean up the project, then right click on the project, maven> update project,
after say, launch the command for a "maven install"
or : click on Run As> Maven Install