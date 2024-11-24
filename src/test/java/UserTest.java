import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import bsp.first_task.User;

public class UserTest {

    private static final String USER_NAME = "Oles";
    private static final int USER_AGE = 20;
    private static final List<Integer> USER_GRADES = List.of(1, 2, 3, 4, 5);
    private static final int USER_GRADE = 5;
    private static final List<Integer> USER_GRADES_CHECK = 
                                List.of(1, 2, 3, 4, 5, 5);

    @Test
    public void testUserBuilder() {
        User user = User.builder()
                .name(USER_NAME)
                .age(USER_AGE)
                .grades(USER_GRADES)
                .grade(USER_GRADE)
                .build();

        assertEquals(USER_NAME, user.getName());
        assertEquals(USER_AGE, user.getAge());
        assertEquals(USER_GRADES_CHECK, user.getGrades());
    }
}
