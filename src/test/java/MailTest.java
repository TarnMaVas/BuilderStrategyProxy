import org.junit.jupiter.api.Test;

import bsp.task2.Client;
import bsp.task2.GiftCode;
import bsp.task2.MailBox;
import bsp.task2.MailCode;
import bsp.task2.MailInfo;
import bsp.task2.MailSender;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

public class MailTest {

    @Test
    public void testMailInfo() {
        Client client = new Client("Oles",
                LocalDate.of(2000, 1, 1),
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
                LocalDate.of(2000, 1, 1),
                "M",
                "trial@example.com");

        MailInfo mailInfo = new MailInfo(client, new GiftCode());

        MailBox mailBox = new MailBox();
        mailBox.addMailInfo(mailInfo);

        List<MailInfo> mailInfos = mailBox.getInfos();
        assertEquals(1, mailInfos.size());
        assertEquals(mailInfo, mailInfos.get(0));
    }

    @Test
    public void testSendMail() {
        Client client = new Client("Oles",
                LocalDate.of(2000, 1, 1),
                "M",
                "trial@example.com");

        MailInfo mailInfo = new MailInfo(client, new GiftCode());

        MailSender mailSender = new MailSender();
        mailSender.sendMail(mailInfo);

        assertDoesNotThrow(() -> mailSender.sendMail(mailInfo));
    }
}