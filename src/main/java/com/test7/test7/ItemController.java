package com.test7.test7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")

public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping
    public String addItem(@RequestBody Item item) {
        itemService.addItem(item);
        return "Saved";
    }

    @GetMapping
    public List<Item> getItems() {
        return itemService.getItems();
    }

    @PutMapping("/{id}")
    public String updateItem(@PathVariable String id, @RequestBody Item item) {
        itemService.updateItem(id, item);
        return "Updated";
    }

    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable String id) {
        itemService.deleteItem(id);
        return "Deleted";
    }

}
