package com.shopkeeper.controller;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.shopkeeper.dao.ItemRepository;
import com.shopkeeper.model.Item;
import com.shopkeeper.service.ItemService;

@RunWith(MockitoJUnitRunner.class)

public class ItemControllerTest {
       
       ItemController itemController;
       private Item item;
       
       @Mock
       private Model model;
       
       @Mock
       private BindingResult result;
       @Mock
       ItemRepository itemRepository;
       @Mock
    ItemService itemService;
       Field field,field1;
       @SuppressWarnings("rawtypes")
       @Mock
       private List<Item> list,list1;
       @Mock
       HttpServletRequest request; 

       @Before
       public void setUp() throws Exception {
              
              itemController = new ItemController();
              field = ItemController.class.getDeclaredField("itemService");
              field.setAccessible(true);
              field.set(itemController, itemService);
              //itemService.itemRepository = itemRepository;
              list = new ArrayList<Item>();
              list1 = new ArrayList<Item>();
              item = new Item();
              item.setItemId(1);
              list.add(item);
      

       }
       
       @Test 
       public void testItemSearch() {
              String name="VVV";
              Mockito.when(itemService.itemList(name)).thenReturn(list);
              //Mockito.when(itemService.itemList(name)).thenReturn(list);
              //assertEquals(1,  itemService.itemList(name).size());
              assertEquals("search",  itemController.searchByItemName(name).getViewName());
       }

      /* @Test 
       public void testItemSearchForm() {
              ModelAndView model=new ModelAndView();
                           
              assertEquals("search", itemController.searchProducts().getViewName());
       }*/


     /*  @Test 
       public void testGetItemForm() {
              ModelAndView model1 = new ModelAndView();
              assertEquals("addItems", itemController.addItems(model).getViewName());
       }
*/
       

       @Test 
       public void testSaveItem_hasErrors() {
              Mockito.when(result.hasErrors()).thenReturn(true);
              assertEquals("addItems", itemController.saveItem(item, result).getViewName());
       }
       
       @Test
       public void testSaveItem() {
              item.setItemId(15);
              item.setItemName("MMM");
              item.setPrice(52);
              item.setQuantity(10);
              //itemService.add(item);
              
              //verify(itemRepository,times(1)).save(item);
              Mockito.doNothing().when(itemService).add(item);
              Mockito.when(itemService.listAll()).thenReturn(list);
              assertEquals("listItems", itemController.saveItem(item, result).getViewName());
       }
                           
       @Test
       public void testEditItemForm() {
              
              item.setItemName("book");;
              item.setItemId(10);
              item.setPrice(100);
              item.setQuantity(12);
              Mockito.when(itemRepository.findOne(1)).thenReturn(item);
              Mockito.when(request.getParameter("itemId")).thenReturn("1");
              Mockito.when(itemService.getId(1)).thenReturn(item);
              assertEquals("updateItem", itemController.showEditItemPage(request).getViewName());
       }
}
