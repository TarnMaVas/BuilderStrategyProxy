import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import bsp.secondtask.Client;
import bsp.secondtask.GiftCode;
import bsp.secondtask.MailBox;
import bsp.secondtask.MailCode;
import bsp.secondtask.MailInfo;
import bsp.secondtask.MailSender;

public class MailTest {

    private static final int CLIENT_YEAR = 2000;
    private static final int CLIENT_MONTH = 1;
    private static final int CLIENT_DAY = 1;

    @Test
    public void testMailInfo() {
        Client client = new Client("Oles",
                LocalDate.of(CLIENT_YEAR, CLIENT_MONTH, CLIENT_DAY),
                "M",
                "trial@example.com");

        MailCode mailCode = new GiftCode();
        MailInfo mailInfo = new MailInfo(client, mailCode);

        Assertions.assertEquals(client, mailInfo.getClient());
        Assertions.assertEquals(mailCode.generate(client), 
                                mailInfo.generate());
    }

    @Test
    public void testMailBox() {
        Client client = new Client("Oles",
                LocalDate.of(CLIENT_YEAR, CLIENT_MONTH, CLIENT_DAY),
                "M",
                "trial@example.com");

        MailCode mailCode = new GiftCode();
        MailInfo mailInfo = new MailInfo(client, mailCode);

        MailBox mailBox = new MailBox();
        mailBox.addMailInfo(mailInfo);
        mailBox.sendAll();

        Assertions.assertTrue(mailBox.getInfos().isEmpty());
    }

    @Test
    public void testSendMail() {
        Client client = new Client("Oles",
                LocalDate.of(CLIENT_YEAR, CLIENT_MONTH, CLIENT_DAY),
                "M",
                "trial@example.com");

        MailInfo mailInfo = new MailInfo(client, new GiftCode());

        MailSender mailSender = new MailSender();

        Assertions.assertDoesNotThrow(() -> mailSender.sendMail(mailInfo));
    }
}