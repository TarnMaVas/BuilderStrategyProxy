import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import bsp.second_task.Client;
import bsp.second_task.GiftCode;
import bsp.second_task.MailBox;
import bsp.second_task.MailCode;
import bsp.second_task.MailInfo;
import bsp.second_task.MailSender;

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

        assertEquals(client, mailInfo.getClient());
        assertEquals(mailCode.generate(client), mailInfo.generate());
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
                LocalDate.of(2000, 1, 1),
                "M",
                "trial@example.com");

        MailInfo mailInfo = new MailInfo(client, new GiftCode());

        MailSender mailSender = new MailSender();

        assertDoesNotThrow(() -> mailSender.sendMail(mailInfo));
    }
}