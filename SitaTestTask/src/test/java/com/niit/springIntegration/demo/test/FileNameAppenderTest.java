package com.niit.springIntegration.demo.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import com.niit.springIntegration.demo.FileNameAppender;

/**
 * Test class to check FileNameAppender.
 * @author Sandeep.Chaudhary
 *
 */
public class FileNameAppenderTest {

	private FileNameAppender appender;
	
	/**
	 * Setup the required resources.
	 */
	@Before
	public void setUp(){
		appender = new FileNameAppender();
	}
	
	/**
	 * Tidying up resources
	 */
	@After
	public void tearDown(){
		appender = null;
	}
	
	/**
	 * Test to verify the file name after the generator process. This is negative case
	 */
	@Test
	public void fileNameVerifyNegativeCase(){
		Message<?> message = MessageBuilder.withPayload("Sample").setHeader("file_name", "XYZ.txt").build();
		appender.setSuffix("OUTPUT");
		String generatedFileName = appender.generateFileName(message);
		Assert.assertNotSame("The generated file name is wrong ", "XYZ.txt.PROCESSED", generatedFileName);
	}
	
	/**
	 * Test to verify the file name after the generator process. This is negative case
	 */
	@Test
	public void fileNameVerifyPositiveCase(){
		Message<?> message = MessageBuilder.withPayload("Sample").setHeader("file_name", "XYZ.txt").build();
		appender.setSuffix("PROCESSED");
		String generatedFileName = appender.generateFileName(message);
		Assert.assertEquals("The generated file name is right ", "XYZ.txt.PROCESSED", generatedFileName);
	}
}
