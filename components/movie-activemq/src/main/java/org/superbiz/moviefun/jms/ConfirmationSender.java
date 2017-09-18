package org.superbiz.moviefun.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by kshitizkriskrishna on 9/14/17.
 */
@Component
public class ConfirmationSender {
    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(final Confirmation confirmation) {
        jmsTemplate.convertAndSend("confirmationQueue", confirmation);
    }
}
