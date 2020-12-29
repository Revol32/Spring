package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.LinkedList;

public class RepositoryConfiguration {

    @Value("${item.repository.implementation}")
    String implementation;

    @Bean
    public ItemRepository itemRepository() {
        if (implementation.equals("linked")) {
            return new LinkedListItemRepository(new LinkedList<>());
        }
        return new ArrayListItemRepository(new ArrayList<>());
    }

}
