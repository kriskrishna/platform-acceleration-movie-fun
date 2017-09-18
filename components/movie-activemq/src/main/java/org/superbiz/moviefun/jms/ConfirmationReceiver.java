package org.superbiz.moviefun.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by kshitizkriskrishna on 9/14/17.
 */
@Component
public class ConfirmationReceiver {
    private Logger logger = LoggerFactory.getLogger(ConfirmationReceiver.class);

    @JmsListener(destination = "confirmationQueue", containerFactory = "connectionFactory")
    public void receiveConfirmation(Confirmation confirmation) {
        logger.info(" >>  Received confirmation: " + confirmation);

    }
}
