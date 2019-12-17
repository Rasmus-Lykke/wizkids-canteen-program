package kea.examgroup.wizkidscanteenprogram.Model;
import kea.examgroup.wizkidscanteenprogram.model.Menu;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MenuTest {

    @Test
    void testTitle(){
        // Arrange
        // Her opretter vi et menuobjekt, som vi gerne vil teste på
        Menu menu1 = new Menu();

        // Act
        // Vi tester den metode der hedder "setTitle" ved at give den værdien "Pizza";
        menu1.setTitle("Pizza");

        // Vi opretter en string med værdien "Pizza", som er vores forventede resultat
        String expectedResult = "Pizza";

        // Assert
        // Vi sammenligner det resultat vi får i metoden "getTitle" med det forventede resultat
        assertThat(menu1.getTitle()).isEqualTo(expectedResult);
    }
}
