package bsp;

import java.time.LocalDate;
import java.util.List;

import bsp.task1.User;
import bsp.task2.GiftCode;
import bsp.task2.Client;
import bsp.task2.MailBox;
import bsp.task2.MailInfo;
import bsp.task3.ProxyImage;


public class Main {
    public static void main(String[] args) {
        User user = User.builder()
                .name("Oles")
                .age(20)
                .grades(List.of(1, 2, 3, 4, 5))
                .grade(5)
                .build();
        
        System.out.println(user);

        Client client = new Client("Oles",
                                    LocalDate.of(2000, 1, 1),
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