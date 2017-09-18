package org.superbiz.moviefun.jms;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kshitizkriskrishna on 9/14/17.
 */

@RestController
@RequestMapping("/moviemessage")
public class MovieMessageController {

    private static Log logger = LogFactory.getLog(MovieMessageController.class);

    private final JmsTemplate jmsTemplate;


    public MovieMessageController(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @PostMapping
    public void sendMessage() {
        logger.info("Sending a movie message.");
        jmsTemplate.convertAndSend("movieQueue",
            new Movie("Shanghai Knights", "David Dobkin", "Action", 6, 2003));

        logger.info("Waiting for movie and confirmation ...");
    }


}

