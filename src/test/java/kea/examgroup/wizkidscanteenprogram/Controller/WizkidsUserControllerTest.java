package kea.examgroup.wizkidscanteenprogram.Controller;

import kea.examgroup.wizkidscanteenprogram.model.WizkidsUser;
import kea.examgroup.wizkidscanteenprogram.repository.WizkidsUserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureTestDatabase
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@RunWith(SpringRunner.class)
@SpringBootTest
public class WizkidsUserControllerTest {

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
        // Check that the row count in DB has increased by 1
        assertThat(wizkidsUserRepository.count()).isEqualTo(1);

        // Check that the user have been saved to the database
        assertThat(wizkidsUserRepository.existsById(1L)).isEqualTo(true);

        // Delete the object in the DB and check that the row count in DB has decreased by 1
        wizkidsUserRepository.delete(wizkidsUser);
        assertThat(wizkidsUserRepository.count()).isEqualTo(0);
    }

}
