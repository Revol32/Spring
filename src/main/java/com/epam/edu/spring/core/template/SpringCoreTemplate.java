package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.factory.ColorFactory;
import com.epam.edu.spring.core.template.repository.AbstractRepository;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCoreTemplate {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);
        ItemRepository itemRepository = (ItemRepository) context.getBean("itemRepository");
        Item testItem = new Item(1, "test", 20.02, context.getBean(ColorFactory.class).getColor());
        itemRepository.createItem(testItem);
        System.out.println(itemRepository.getById(1).toString());
        System.out.println();
        context.close();
    }

}
