/**
 * This package is used to spring integrate FileNameAppender.java.
 */
package com.niit.springIntegration.demo;

import org.springframework.integration.file.FileNameGenerator;
import org.springframework.messaging.Message;

/**
 * FileNameAppender class is used to generate file.
 * @author Sandeep.Chaudhary
 *
 */
public class FileNameAppender implements FileNameGenerator {

     /**
     * variable suffix.
     */
     private String suffix;

     /**
      * set suffix.
      * @param suffx , not null.
      */
     public final void setSuffix(final String suffx) {
         this.suffix = suffx;
     }
     /**
     * Method is used to given the file name with suffix.
     * @param message , not null.
     * @return String , never null.
     */
     public final String generateFileName(final Message<?> message) {
        return message.getHeaders().get("file_name").toString() + "." + suffix;
    }

}
