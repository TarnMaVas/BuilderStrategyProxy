package bsp.second_task;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class Client {
    private static int counter;
    private final int id = counter++;
    private final String name;
    private final LocalDate dob;
    private final String sex;
    private final String email;

    public Client(String name, LocalDate dob, String sex, String email) {
        this.name = name;
        this.dob = dob;
        this.sex = sex;
        this.email = email;
    }
}
