package bsp.task1;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;

enum Gender {
    MALE, FEMALE
}

@Getter @Setter @Builder
public class User {
    private String name;
    private int age;
    private Gender gender;
    private double weight;
    private double height;
    @Singular("grade")
    private List<Integer> grades;

    @Override
    public String toString() {
        return "User(name=" + this.getName() + ", age=" + this.getAge() + ")";
    }
}