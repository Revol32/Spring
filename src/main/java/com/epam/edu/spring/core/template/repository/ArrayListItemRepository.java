package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;

/**
 * Репозиторий, основанный на классе ArrayList.
 * initialSequence должен браться из application.properties
 */
public class ArrayListItemRepository extends AbstractRepository<Item> implements ItemRepository {

    @Value("${initial.sequence}")
    protected long initialSequence;

    public ArrayListItemRepository(ArrayList<Item> items) {
        this.holder = items;
    }

    @Override
    public Item getById(long id) {
        for (Item item : holder) {
            if (item.getId() == id) {
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
        this.initialSequence = val;
    }

    @Override
    void setHolder() {
        this.holder = new ArrayList<>();
    }

    @Override
    public long getInitialSequence() {
        return initialSequence;
    }
}
