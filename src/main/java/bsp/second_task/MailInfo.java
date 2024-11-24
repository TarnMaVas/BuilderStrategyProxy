package bsp.second_task;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class MailInfo {

    @Getter
    private final Client client;
    private final MailCode mailCode;

    public String generate() {
        return mailCode.generate(client);
    }
}
