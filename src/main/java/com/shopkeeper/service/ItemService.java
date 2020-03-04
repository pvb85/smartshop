package com.shopkeeper.service;

import java.util.List;

import com.shopkeeper.model.Item;

public interface ItemService {
	public void add(Item item);

	public List<Item> listAll();

	public Item getId(int itemId);

	public List<Item> itemList(String name);

	public void update(float price, Integer itemId);

	public void delete(Item item);

}
