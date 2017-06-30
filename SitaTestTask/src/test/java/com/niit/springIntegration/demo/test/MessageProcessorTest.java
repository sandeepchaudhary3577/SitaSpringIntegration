package com.niit.springIntegration.demo.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;

import com.niit.springIntegration.demo.MessageProcessor;

import junit.framework.Assert;

/**
 * Test class to check the MessageProcessor.
 * 
 * @author Sandeep.Chaudhary
 *
 */
public class MessageProcessorTest {

	private MessageProcessor processor;

	/**
	 * Setting the resources ready
	 */
	@Before
	public void setUp() {
		processor = new MessageProcessor();
	}

	/**
	 * Tidying resources
	 */
	@After
	public void tearDown() {
		processor = null;
	}

	/**
	 * Test to check the message content and header information.
	 */
	@Test
	public void checkOutMessageWithHeaders() {
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("file_name", "abc.txt");
		headers.put("correlation_id", "askssdjeddlxer");
		MessageHeaders messageHeaders = new MessageHeaders(headers);
		Message<?> message = MessageBuilder.createMessage("4\n3\n3", messageHeaders);
		Message<?> output = (Message<?>) processor.processMessage(message);
		Assert.assertNotSame("Output is right ", "20", output.getPayload().toString());
		Assert.assertEquals("Filename modified ", "abc.txt", output.getHeaders().get("file_name"));
		Assert.assertEquals("correlation_id modified ", "askssdjeddlxer", output.getHeaders().get("correlation_id"));
	}
	
}
