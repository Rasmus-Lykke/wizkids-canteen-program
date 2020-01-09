package kea.examgroup.wizkidscanteenprogram.Controller;

import kea.examgroup.wizkidscanteenprogram.model.Forum;
import kea.examgroup.wizkidscanteenprogram.model.Order;
import kea.examgroup.wizkidscanteenprogram.repository.ForumRepository;
import kea.examgroup.wizkidscanteenprogram.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.DATE;
import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureTestDatabase
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderControllerTest {

    Order order = new Order();
    @Autowired
    OrderRepository orderRepository;

    @Test
    public void createOrder() {

        // Check that the database is empty
        assertThat(orderRepository.count()).isEqualTo(0);

        // Arrange
        // Save the values to the object
        order.setDate(new Date());
        order.setWizkidsUserId(1L);
        order.setComment("Test comment");
        order.setFirstName("Test name");
        order.setMenuId(1L);

        // Act
        // Save the object to the database
        orderRepository.save(order);

        // Assert
        // Check that the row count in DB has increased by 1
        assertThat(orderRepository.count()).isEqualTo(1);

        // Check that the order have been saved to the database
        assertThat(orderRepository.existsById(1L)).isEqualTo(true);
        assertThat(orderRepository.findById(1L).get().getComment()).isEqualTo(order.getComment());
        assertThat(orderRepository.findById(1L).get().getWizkidsUserId()).isEqualTo(order.getWizkidsUserId());
        assertThat(orderRepository.findById(1L).get().getMenuId()).isEqualTo(order.getMenuId());

        // Delete the object in the DB and check that the row count in DB has decreased by 1
        orderRepository.delete(order);
        assertThat(orderRepository.count()).isEqualTo(0);

    }
}