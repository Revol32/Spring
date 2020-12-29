package validator;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.Color;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.factory.ColorFactory;
import com.epam.edu.spring.core.template.validator.ItemValidator;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;


@SpringBootTest
public class SimpleItemValidatorTest {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);

    @Test
    public void testValidator () throws Exception {
        ItemValidator itemValidator = (ItemValidator) context.getBean("itemValidator");
        Item testItem1 = new Item(1, "test", 20.02, context.getBean(ColorFactory.class).getColor());
        Item testItem2 = new Item(2, "INSERT INTO table (pass) VALUES (value)", 20.02, Color.BLUE);
        assertTrue(itemValidator.isItemValid(testItem1));
        assertFalse(itemValidator.isItemValid(testItem2));
    }
}
