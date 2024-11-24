package bsp.task2;

public class GiftCode implements MailCode {
    
    @Override
    public String generate(Client client) {

        String statString =
            "Visit SuspiciousSite101.com to claim it right away!";

        return String.format(
"Dear %s, you have a gift! %s", client.getName(), statString);
    }
    
}
