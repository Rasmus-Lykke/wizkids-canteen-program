package kea.examgroup.wizkidscanteenprogram.Controller;

import kea.examgroup.wizkidscanteenprogram.model.Forum;
import kea.examgroup.wizkidscanteenprogram.repository.ForumRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureTestDatabase
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@RunWith(SpringRunner.class)
@SpringBootTest
public class ForumControllerTest {

    Forum forum = new Forum();
    @Autowired
    ForumRepository forumRepository;

    @Test
    public void createQuestion() {

        // Check that the database is empty
        assertThat(forumRepository.count()).isEqualTo(0);

        // Arrange
        // Save the values to the object
        forum.setQuestion("Test question");
        forum.setReply("Test answer");
        forum.setTitle("Test title");
        // Act
        // Save the object to the database
        forumRepository.save(forum);

        // Assert
        // Check that the row count in DB has increased by 1
        assertThat(forumRepository.count()).isEqualTo(1);

        // Check that the question have been saved to the database
        assertThat(forumRepository.existsById(1L)).isEqualTo(true);

        // Delete the object in the DB and check that the row count in DB has decreased by 1
        forumRepository.delete(forum);
        assertThat(forumRepository.count()).isEqualTo(0);

    }
}