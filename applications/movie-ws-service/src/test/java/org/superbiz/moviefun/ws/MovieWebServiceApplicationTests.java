package org.superbiz.moviefun.ws;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ws.client.core.WebServiceTemplate;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by kshitizkriskrishna on 9/15/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MovieWebServiceApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(MovieWebServiceApplicationTests.class);


    @Rule
    public OutputCapture output = new OutputCapture();

    private WebServiceTemplate webServiceTemplate = new WebServiceTemplate();

    @LocalServerPort
    private int serverPort;

    @org.junit.Before
    public void setUp() {
        this.webServiceTemplate
            .setDefaultUri("http://localhost:" + this.serverPort + "/services/");
    }

    @Test
    public void testSendingHolidayRequest() {
        final String request = "<hr:HolidayRequest xmlns:hr=\"http://mycompany.com/hr/schemas\">"
            + "   <hr:Holiday>" + "      <hr:StartDate>2013-10-20</hr:StartDate>"
            + "      <hr:EndDate>2013-11-22</hr:EndDate>" + "   </hr:Holiday>"
            + "   <hr:Employee>" + "      <hr:Number>1</hr:Number>"
            + "      <hr:FirstName>John</hr:FirstName>"
            + "      <hr:LastName>Doe</hr:LastName>" + "   </hr:Employee>"
            + "</hr:HolidayRequest>";
        StreamSource source = new StreamSource(new StringReader(request));
        StreamResult result = new StreamResult(System.out);
        this.webServiceTemplate.sendSourceAndReceiveToResult(source, result);
        assertThat(this.output.toString()).contains("Booking holiday for");
    }

}
