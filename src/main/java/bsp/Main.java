package bsp;

import java.time.LocalDate;
import java.util.List;

import bsp.firsttask.User;
import bsp.secondtask.Client;
import bsp.secondtask.GiftCode;
import bsp.secondtask.MailBox;
import bsp.secondtask.MailInfo;
import bsp.thirdtask.ProxyImage;


public class Main {
    private static final int USER_AGE = 20;
    private static final List<Integer> USER_GRADES = List.of(1, 2, 3, 4, 5);
    private static final int USER_GRADE = 5;
    private static final int CLIENT_YEAR = 2000;
    private static final int CLIENT_MONTH = 1;
    private static final int CLIENT_DAY = 1;

    public static void main(String[] args) {
        User user = User.builder()
                .name("Oles")
                .age(USER_AGE)
                .grades(USER_GRADES)
                .grade(USER_GRADE)
                .build();
        
        System.out.println(user);

        Client client = new Client("Oles",
                                    LocalDate.of(CLIENT_YEAR, 
                                                CLIENT_MONTH, 
                                                CLIENT_DAY),
                                    "M",
                                    "trial@example.com");

        MailInfo mailInfo = new MailInfo(client, new GiftCode());

        MailBox mailBox = new MailBox();
        mailBox.addMailInfo(mailInfo);
        mailBox.sendAll();

        ProxyImage proxyImage = 
                        new ProxyImage("src/main/resources/images.png");
        
        proxyImage.display();
    }
}