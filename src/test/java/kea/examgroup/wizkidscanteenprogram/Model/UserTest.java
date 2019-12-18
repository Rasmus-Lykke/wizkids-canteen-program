package kea.examgroup.wizkidscanteenprogram.Model;

import kea.examgroup.wizkidscanteenprogram.model.WizkidsUser;
import kea.examgroup.wizkidscanteenprogram.repository.WizkidsUserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureTestDatabase
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    WizkidsUserRepository wizkidsUserRepository;

    WizkidsUser wizkidsUser = new WizkidsUser();

    @Test
    public void createUserTest() {
        // Check that the database is empty
        assertThat(wizkidsUserRepository.count()).isEqualTo(0);

        // Arrange
        // Save the values to the object
        wizkidsUser.setFirstName("Rasmus");
        wizkidsUser.setLastName("Sørensen");
        wizkidsUser.setUsername("rasmus@sørensen.com");
        wizkidsUser.setPassword("Password");
        wizkidsUser.setDateOfBirth(new Date());
        wizkidsUser.setGender("MALE");

        // Act
        // Save the object to the database
        wizkidsUserRepository.save(wizkidsUser);

        // Assert
        // Check that the user have been saved to the database
        assertThat(wizkidsUserRepository.existsById(1L)).isEqualTo(true);
    }

}
