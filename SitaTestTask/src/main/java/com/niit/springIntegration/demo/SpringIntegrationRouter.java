package com.niit.springIntegration.demo;

import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.messaging.Message;

/**
 * InputFileRouter class to send requests to appropriate channel.
 *
 * @author Sandeep.Chaudhary
 *
 */
public class SpringIntegrationRouter {

    /**
     * variable LOGGER.
     */
    private static final Logger LOGGER = Logger.
        getLogger(SpringIntegrationRouter.class);
    /**
     * variable HEADER_FILE_NAME.
     */
    private static final String HEADER_FILE_NAME = "file_name";
    /**
     * variable MSG_RECEIVED.
     */
    private static final String MSG_RECEIVED = "%s received. Content: %s";
    /**
     * variable MSG_SENT.
     */
    private static final String MSG_SENT = "File %s is sending to Chanel: %s";

    /**
     * Method is used to processed message.
     * channel.
     *
     * @param  msg
     * @return channel
     */
    public final String handleFile(final Message<String> msg) {
        String fileName = (String) msg.getHeaders().get(HEADER_FILE_NAME);
        String message = msg.getPayload();
        LOGGER.debug(String.format(MSG_RECEIVED, fileName, message));
        String channel = validateMessage(message);
        LOGGER.info(String.format(MSG_SENT, fileName, channel));
        return channel;
    }

    /**
     * Method is used to validate the content and proceed to appreciate channel.
     *
     * @param content , not null.
     * @return String , never null.
     */
    private String validateMessage(final String content) {
        String[] contentArray = content.split("\n");
        boolean isValid = true;
        Pattern pattern = Pattern.compile("\\-?\\d+");
        for (String contentString : contentArray) {
            if (!pattern.matcher(contentString.trim()).matches()) {
                isValid = false;
                break;
            }
        }
        if (isValid) {
            return "validChannel";
        }
        return "errorChannel";
    }
}
