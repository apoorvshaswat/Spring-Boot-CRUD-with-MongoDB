package com.test7.test7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public void addItem(Item item) {
        itemRepository.save(item);
    }

    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public void updateItem(String id, Item updatedItem) {
        itemRepository.findById(id).map(item -> {
            item.setName(updatedItem.getName());
            itemRepository.save(item);
            return null;
        });
    }

    public void deleteItem(String id) {
        itemRepository.deleteById(id);
    }
}
