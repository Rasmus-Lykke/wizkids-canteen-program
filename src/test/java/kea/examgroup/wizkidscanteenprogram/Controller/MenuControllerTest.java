package kea.examgroup.wizkidscanteenprogram.Controller;

import kea.examgroup.wizkidscanteenprogram.model.Forum;
import kea.examgroup.wizkidscanteenprogram.model.Menu;
import kea.examgroup.wizkidscanteenprogram.repository.ForumRepository;
import kea.examgroup.wizkidscanteenprogram.repository.MenuRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureTestDatabase
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuControllerTest {

    Menu menu = new Menu();

    @Autowired
    MenuRepository menuRepository;

    @Test
    public void createMenu() {

        // Current day + one day
        Date date = new Date(new Date().getTime() + 86400000);

        // Check that the database is empty
        assertThat(menuRepository.count()).isEqualTo(0);

        // Arrange
        // Save the values to the object
        menu.setTitle("Test title");
        menu.setDate(date);
        menu.setDescription("Test description");

        // Act
        // Save the object to the database
        menuRepository.save(menu);

        // Assert
        // Check that the row count in DB has increased by 1
        assertThat(menuRepository.count()).isEqualTo(1);

        // Check that the menu have been saved to the database
        assertThat(menuRepository.existsById(1L)).isEqualTo(true);

        // Delete the object in the DB and check that the row count in DB has decreased by 1
        menuRepository.delete(menu);
        assertThat(menuRepository.count()).isEqualTo(0);

    }
}