package repository;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.Color;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.factory.ColorFactory;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

@SpringBootTest
public class ItemRepositoryTest {
    AnnotationConfigApplicationContext context
            = new AnnotationConfigApplicationContext(MainConfiguration.class);

    @Test
    public void testInitialSequence() {
        ItemRepository itemRepository = (ItemRepository) context.getBean("itemRepository");
        System.out.println(itemRepository.getInitialSequence());
        assertTrue(1 <= itemRepository.getInitialSequence() && itemRepository.getInitialSequence() <= 100);
    }

    @Test
    public void testItemRepository() throws Exception {
        ItemRepository itemRepository = (ItemRepository) context.getBean("itemRepository");
        Item testItemStart = new Item(1, "test", 20.02, context.getBean(ColorFactory.class).getColor());
        Item testItemID = new Item(2, "color", 20.03, Color.RED);
        Item testItemFalse = new Item(1, "false", 20.04, context.getBean(ColorFactory.class).getColor());
        itemRepository.createItem(testItemStart);
        itemRepository.createItem(testItemID);
        assertEquals("color", itemRepository.getById(2).getName());
        assertEquals(Color.RED, itemRepository.getById(2).getColor());
        assertFalse(itemRepository.createItem(testItemFalse));
    }
}
