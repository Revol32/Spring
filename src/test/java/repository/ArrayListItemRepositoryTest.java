package repository;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArrayListItemRepositoryTest {
    AnnotationConfigApplicationContext context
            = new AnnotationConfigApplicationContext(MainConfiguration.class);

    @Test
    public void testInitialSequence () {
        ArrayListItemRepository arrayListItemRepository = (ArrayListItemRepository) context.getBean("ItemRepository");
        System.out.println(arrayListItemRepository.getInitialSequence());
        assertTrue (42 == arrayListItemRepository.getInitialSequence());
    }
}
