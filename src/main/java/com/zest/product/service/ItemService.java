package com.zest.product.service;

import com.zest.product.entity.Item;
import com.zest.product.entity.Product;
import com.zest.product.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final ProductService productService;

    public ItemService(ItemRepository itemRepository,
                       ProductService productService) {
        this.itemRepository = itemRepository;
        this.productService = productService;
    }

    public Item createItem(Long productId, Item item) {

        Product product = productService.getProductById(productId);

        item.setProduct(product);

        return itemRepository.save(item);
    }

    public List<Item> getItemsByProduct(Long productId) {

        Product product = productService.getProductById(productId);

        return itemRepository.findByProduct(product);
    }

    public void deleteItem(Long itemId) {
        itemRepository.deleteById(itemId);
    }
}
