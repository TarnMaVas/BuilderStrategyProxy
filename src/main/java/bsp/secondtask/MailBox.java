package bsp.secondtask;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class MailBox {

    @Getter
    private final List<MailInfo> infos;
    private final MailSender sender;

    public MailBox() {
        infos = new ArrayList<>();
        sender = new MailSender();
    }

    public void addMailInfo(MailInfo info) {
        infos.add(info);
    }

    public void sendAll() {
        for (MailInfo info : infos) {
            sender.sendMail(info);
        }

        infos.clear();
    }
}
