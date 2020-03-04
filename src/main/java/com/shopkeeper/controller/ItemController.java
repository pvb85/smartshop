package com.shopkeeper.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.shopkeeper.exceptions.ItemNotFoundException;
import com.shopkeeper.model.Item;
import com.shopkeeper.model.User;
import com.shopkeeper.service.ItemService;

/**
 * @author poornachandrika.e
 *
 */

@RestController
public class ItemController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);

	@Autowired
	ItemService itemService;

	// displaying search page
	@GetMapping("/searchForm")
	public ModelAndView displaySearchPage() {

		return new ModelAndView("search");

	}

	// searching based on the item name
	@GetMapping("/search")
	public ModelAndView searchByItemName(@RequestParam("itemName") String name) {

		String result = null;
		ModelAndView m = null;
		try {
			if (name.isEmpty()) {
				LOGGER.info("--inside search--name is  empty -----");
				result = "name should not be empty";
				m = new ModelAndView("search", "result", result);

			} else {

				List<Item> list = itemService.itemList(name);
				if (list.isEmpty()) {
					LOGGER.info("--inside search--items  not  found -----");

					result = "item not found";
					throw new ItemNotFoundException("item not found");
				} else {
					LOGGER.info("--inside search--items  is  found -----");

					m = new ModelAndView("search", "lists", list);

					return m;
				}

			}

		} catch (ItemNotFoundException e) {
			LOGGER.info("----inside -ItemNotFoundException catch block-- " + e);
			m = new ModelAndView("search", "result", result);
			return m;
		}

		catch (Exception e) {
			LOGGER.info("----inside -ItemNotFoundException catch block-- " + e);

		}

		return m;

	}

	// displaying the item add page
	@GetMapping("/additem")
	public ModelAndView dispalyItemPage() {

		// model.addAttribute("item", new Item());

		return new ModelAndView("addItems");

	}

	// add the new Item
	@PostMapping("/saveitem")
	public ModelAndView saveItem(@ModelAttribute("item") @Validated Item item, BindingResult bindingResult) {
		ModelAndView m = null;

		try {

			if (bindingResult.hasErrors()) {
				LOGGER.info("----inside saveItems()--hasErrors-----");
				m = new ModelAndView("addItems");
				return m;
			} else {
				LOGGER.info("----inside saveItems()-no-hasErrors-----");
				itemService.add(item);
				List<Item> listItems = itemService.listAll();
				m = new ModelAndView("listItems", "listItems", listItems);
				return m;
			}

		} catch (Exception e) {
			LOGGER.info("----inside Exception catch block-----" + e.getMessage());

		}
		return m;

	}

	// displaying edit page
	@GetMapping("/edit")
	public ModelAndView showEditItemPage(HttpServletRequest request) {
		LOGGER.info("----inside showEditItemPage()-------");

		int itemId = Integer.parseInt(request.getParameter("itemId"));

		Item item = itemService.getId(itemId);

		return new ModelAndView("updateItem", "item", item);

	}

	// updating the item
	@PostMapping("/update")
	public ModelAndView updateItemPage(@RequestParam(value = "itemId") Integer itemId,

			@ModelAttribute("item") Item item) {

		itemService.update(item.getPrice(), item.getItemId());

		List<Item> listItems = itemService.listAll();

		return new ModelAndView("listItems", "listItems", listItems);

	}

	// delete the item
	@GetMapping("/delete")
	public ModelAndView deleteItemPage(@RequestParam(value = "itemId") Integer itemId) {

		Item item = itemService.getId(itemId);

		itemService.delete(item);

		List<Item> listItems = itemService.listAll();

		return new ModelAndView("listItems", "listItems", listItems);

	}

}
