import org.junit.jupiter.api.Test;

import bsp.task1.User;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class UserTest {

    @Test
    public void testUserBuilder() {
        User user = User.builder()
                .name("Oles")
                .age(20)
                .grades(List.of(1, 2, 3, 4, 5))
                .grade(5)
                .build();

        assertEquals("Oles", user.getName());
        assertEquals(20, user.getAge());
        assertEquals(List.of(1, 2, 3, 4, 5, 5), user.getGrades());
    }
}
