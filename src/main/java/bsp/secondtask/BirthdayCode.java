package bsp.secondtask;

public class BirthdayCode implements MailCode {
    
    @Override
    public String generate(Client client) {
        return String.format("Happy Birthday, dear %s!", client.getName());
    }
}
