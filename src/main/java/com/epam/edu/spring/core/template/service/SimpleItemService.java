package com.epam.edu.spring.core.template.service;

import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.validator.ItemValidator;

public class SimpleItemService implements ItemService {

    private ItemRepository itemRepository;
    private ItemValidator itemValidator;

    public SimpleItemService(ItemRepository repository, ItemValidator validator){
        this.itemRepository=repository;
        this.itemValidator=validator;
    }

    @Override
    public Item getById(long id) {
        return itemRepository.getById(id);
    }

    @Override
    public boolean createItem(Item item) {
        if (itemValidator.isItemValid(item)){
            itemRepository.createItem(item);
        }
        return false;
    }
}
