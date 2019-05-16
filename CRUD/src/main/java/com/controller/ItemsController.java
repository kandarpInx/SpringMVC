package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Items;
import com.service.ItemsService;

@Controller
@RequestMapping("/views")
public class ItemsController {

	@Autowired
	private ItemsService itemsService;
	
	@RequestMapping(value="/saveItems", method = RequestMethod.POST)
    public String saveItem(@ModelAttribute Items items) {
		
		if(items.getItemId()==null) {
			itemsService.save(items);
		}
		else {
			itemsService.update(items);
		}
		return "redirect:/";
    }
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String listItems(Model model) {
		List<Items> items = itemsService.getAll();
		model.addAttribute("items", items);
		return "index";
	}
	
	@RequestMapping(value="/showForm",method=RequestMethod.GET)
    public String insertItem(Model model) {
        return "saveItems";
    }
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
    public String deleteItem(@RequestParam("itemId") Integer id) {
		Items i = (Items) itemsService.get(id);
        itemsService.delete(i);
        return "redirect:/";
    }
	
	@RequestMapping(value="/updateForm", method=RequestMethod.GET)
    public String updateItem(@RequestParam("itemId") Integer id, Model model) {
		System.out.println("-----------" + id);
		Items i = (Items) itemsService.get(id);
        model.addAttribute("items", i);
        return "saveItems";
    }
}