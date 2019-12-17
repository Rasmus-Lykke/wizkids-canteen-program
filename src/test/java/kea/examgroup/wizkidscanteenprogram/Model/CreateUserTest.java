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
public class CreateUserTest {

    @Autowired
    WizkidsUserRepository wizkidsUserRepository;

    WizkidsUser wizkidsUser = new WizkidsUser();

    @Test
    public void createUserTest() {

        // Check at databasen er tom
        assertThat(wizkidsUserRepository.count()).isEqualTo(0);

        // Arrenger
        // Gem værdier til objektet

        wizkidsUser.setFirstName("Rasmus");
        wizkidsUser.setLastName("Sørensen");
        wizkidsUser.setUsername("rasmus@sørensen.com");
        wizkidsUser.setPassword("Password");
        wizkidsUser.setDateOfBirth(new Date());
        wizkidsUser.setGender("MALE");

        // Act
        // Gem objectet i databasen
        wizkidsUserRepository.save(wizkidsUser);

        // Assert
        // Check om brugeren er blevet oprettet i databasen
        assertThat(wizkidsUserRepository.existsById(1L)).isEqualTo(true);
    }

}
