package com.shopkeeper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopkeeper.dao.ItemRepository;
import com.shopkeeper.model.Item;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepository itemRepository;

	public void add(Item item) {

		itemRepository.save(item);

	}

	public List<Item> listAll() {

		return (List<Item>) itemRepository.findAll();

	}

	@Override

	public List<Item> itemList(String name) {

		return itemRepository.findByItemNameContains(name);

	}

	@Override

	public Item getId(int itemId) {

		Item item = itemRepository.findOne(itemId);

		return item;

	}

	@Override
	public void update(float price, Integer itemId) {

		itemRepository.updatePrice(price, itemId);

	}

	@Override
	public void delete(Item item) {

		itemRepository.delete(item);

	}

}
