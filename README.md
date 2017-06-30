# SitaSpringIntegration
Spring Integration 

It is web project deployed.step to make war file for the project.

# IntegrationTask

## Task Detail: 
Test task scenario:
 
There will be a series of files placed into the directory (D:\SITA_TEST_TASK\IN) with a number on each line.  Attached are some example files (invalid and valid).  

We would like the application to automatically process these files by polling that folder for new files every 5 seconds. If a new file is found, then the application should sum all the numbers in the file and create a new file containing the resulting value in the directory (D:\SITA_TEST_TASK\OUT). 

The output file should have the same name as the input file with .OUTPUT appended to the end of the filename. 

When the input file is successfully processed it should be moved to the following directory (D:\SITA_TEST_TASK\PROCESSED) with .PROCESSED appended to the end of the file name. 

If an error occurs while processing the input file then the input file should be moved into the following directory (D:\SITA_TEST_TASK\ERROR) with .ERROR appended to the end of the filename. 

## Dependencies
* spring integration framework 4.1.2.RELEASE
* spring framework 4.1.4.RELEASE
* log4j 1.2.17
* junit 4.10
* apache commons 1.3.2
## Server
* apache-tomcat-7.0.78


## Maven repository to download dependencies
https://repo.maven.apache.org/maven2/


## Build the application
1. From the command prompt run mvn clean install
## To Test checkstyle
1. From the command prompt mvn:checkstyle:checkstyle
## To deployed the project
1.Placed the war file in the \webapps directory of tomcat home.
2.Placed the some txt file in the  D:\SITA_TEST_TASK\IN
3.Run startup.bat command in the \apache-tomcat-7.0.78\bin directory
## Note
1. It is assumed that the input files will be placed under D:\SITA_TEST_TASK\IN, however we can configure this value in application.properties which is available at src/main/resources

## Testing the application.
1. Before running the application, place the input files under D:\SITA_TEST_TASK\IN.
2. To run the application put the war file from target folder to  \webapps directory of tomcat.
3. Verify the results in D:\SITA_TEST_TASK\OUT,D:\SITA_TEST_TASK\PROCESSED and D:\SITA_TEST_TASK\ERROR.

## Process Flow
1. At the time when we deployed the application, the inbound-channel-adapter will start automatically since we have configured auto-startup value to true.
2. Since the poller configured it wll poll for messages from the given input directory.
3. All the messages one by one enter to router and the router will do the message validation. The validation will pass if the lines in the file contains numbers. If the validation fails then router will send the message to errorChannel.
Otherwise the message will send to valid channel.
4. On the errorChannel we have outbound-channel-adapter and this is responsible to put message into the directory specified in configuration.
5.valid channel declared as public subsriber ,it will execute two taks ,one for to gernerate .OUTPUT file extension with sum of number and other to gernerate .PROCESSED file extension.
a. we have service-activator and the bean referred for valid channel is responsible to generate the file content      (sum of numbers)      and will send to writeOutputChannel, On the writeOutputChannel we have outbound-channel-adapter which is                responsible      to generate the output in the configured directory. Since we have used configured file-name-generator then the                          application is having the control to decide the name of the file. This generator will add ".OUTPUT" at the end of original file          name.

 b.valid channel is responsible to generate the file content with .PROCESSED file extension.


