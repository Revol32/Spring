package factory;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.Color;
import com.epam.edu.spring.core.template.factory.ColorFactory;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import java.util.ArrayList;
import java.util.Collections;

import static junit.framework.TestCase.*;

public class ColorFactoryTest {

    @Test
    public void testColorFactory () throws Exception {
        ArrayList<Color> list = new ArrayList<>();
        for (int i = 0;i<20;i++) {
            list.add(new ColorFactory().getColor());
        }
        System.out.println(Collections.frequency(list, list.get(0)));
        assertTrue(20 > Collections.frequency(list, list.get(0)));
    }


}
