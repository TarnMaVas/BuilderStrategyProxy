package bsp.task2;

public class BirthdayCode implements MailCode {
    
    @Override
    public String generate(Client client) {
        return String.format("Happy Birthday, dear %s!", client.getName()) ;
    }
}
