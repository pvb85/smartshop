package com.shopkeeper.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.shopkeeper.model.Item;

public interface ItemRepository extends CrudRepository<Item, Integer> {

	public List<Item> findByItemNameContains(String name);

	@Transactional
	@Modifying
	@Query("update Item i set i.price=:price where i.itemId=:id")

	public int updatePrice(@Param("price") float price, @Param("id") int id);

}
