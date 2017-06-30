# SitaSpringIntegration
Spring Integration 
Test task scenario:
 
There will be a series of files placed into the directory (C:\SITA_TEST_TASK\IN) with a number on each line.  Attached are some example files (invalid and valid).  

We would like the application to automatically process these files by polling that folder for new files every 5 seconds. If a new file is found, then the application should sum all the numbers in the file and create a new file containing the resulting value in the directory (C:\SITA_TEST_TASK\OUT). 

The output file should have the same name as the input file with .OUTPUT appended to the end of the filename. 

When the input file is successfully processed it should be moved to the following directory (C:\SITA_TEST_TASK\PROCESSED) with .PROCESSED appended to the end of the file name. 

If an error occurs while processing the input file then the input file should be moved into the following directory (C:\SITA_TEST_TASK\ERROR) with .ERROR appended to the end of the filename. 
 
to test checkstyle run project with mvn:checkstyle:checkstyle
