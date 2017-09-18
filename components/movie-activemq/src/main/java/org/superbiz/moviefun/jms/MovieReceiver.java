package org.superbiz.moviefun.jms;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by kshitizkriskrishna on 9/14/17.
 */
@Component
public class MovieReceiver {

    private Logger logger = LoggerFactory.getLogger(MovieReceiver.class);
    private static AtomicInteger id = new AtomicInteger();

    @Autowired
    ConfirmationSender confirmationSender;


    @JmsListener(destination = "movieQueue", containerFactory = "connectionFactory")
    public void receiveMessage(Movie receivedMovie, Message message) {
        logger.info(" >> Original received message: " + message);
        logger.info(" >> Received movie: " + receivedMovie);
        confirmationSender.sendMessage(new Confirmation(id.incrementAndGet(), " Movie "
            + receivedMovie.getTitle() + " received."));

    }

}
