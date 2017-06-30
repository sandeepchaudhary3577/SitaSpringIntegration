package com.niit.springIntegration.demo;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

/**
 * This class MessageProcessor is used Prepare content for
 * the output message and build message with new content.
 *
 * @author Sandeep.Chaudhary
 *
 */
public class MessageProcessor {

    /**
     * Method to process the input payload and generate the result.
     * Will send new payload to the output channel.
     *
     * @param message , not null.
     * @return Object , never null.
     */
    public final Object processMessage(final Message<?> message) {
        String content = generateContent(message.getPayload().toString());
        Message<String> output = MessageBuilder.withPayload(content).
            copyHeaders(message.getHeaders()).build();
        return output;
    }

    /**
     * Read the content from the input. Will sum each line and add to result.
     *
     * @param payload , not null.
     * @return String , never null.
     */
    private String generateContent(final String payload) {
        long sum = 0;
        String[] lines = payload.split("\n");
        for (String line : lines) {
            sum = sum + Long.valueOf(line.trim());
        }
        return String.valueOf(sum);
    }
}
