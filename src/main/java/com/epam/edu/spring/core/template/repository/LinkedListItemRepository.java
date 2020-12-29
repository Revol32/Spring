package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;

import java.util.LinkedList;
import java.util.Random;

/**
 * Репозиторий, основанный на классе LinkedList.
 * initialSequence должен случайно генерироваться из диапазона от 1 до 100
 */
public class LinkedListItemRepository extends AbstractRepository<Item> implements ItemRepository {

    public LinkedListItemRepository(LinkedList<Item> items) {
        this.holder = items;
        this.initialSequence = 1 + new Random().nextInt(100);
    }

    @Override
    public Item getById(long id) {
        for (Item item: holder){
            if (item.getId()==id){
                return item;
            }
        }
        return null;
    }

    @Override
    public boolean createItem(Item item) {
        for (Item itemFromRepository : holder) {
            if (itemFromRepository.getId() == item.getId()) {
                return false;
            }
        }
        return holder.add(item);
    }

    @Override
    void setInitialSequence(int val) {
        this.initialSequence=val;
    }

    @Override
    void setHolder() {
        this.holder = new LinkedList<>();
    }

    @Override
    public long getInitialSequence() {
        return initialSequence;
    }
}
