package kea.examgroup.wizkidscanteenprogram.Model;

import kea.examgroup.wizkidscanteenprogram.model.Authority;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthorityTest {

    @Test
    void setAuthority(){
        // Arrange
        Authority authority1 = new Authority();

        // Act
        authority1.setAuthority("ROLE_USER");
        String expectedResult = "ROLE_USER";

        // Assert
        assertThat(authority1.getAuthority()).isEqualTo(expectedResult);
    }
}
