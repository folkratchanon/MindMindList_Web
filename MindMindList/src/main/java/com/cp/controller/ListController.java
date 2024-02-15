package com.cp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.cp.entity.MyList;
import com.cp.service.ListService;
import com.cp.service.MyListService;

@Controller
public class ListController {
	@Autowired
	private ListService service;
	
	@Autowired
	private MyListService myListService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/list_register")
	public String listRegister() {
		return "listRegister";
	}
	
	@GetMapping("/available_lists")
	public ModelAndView getAllList() {
		List<com.cp.entity.List>list=service.getAllList();
		return new ModelAndView("listList","list",list);
	}
	
	@PostMapping("/save")
	public String addList(@ModelAttribute com.cp.entity.List l) {
		service.save(l);
		return "redirect:/available_lists";
	}
	@GetMapping("/my_lists")
	public String getMyLists(Model model)
	{
		List<MyList>list=myListService.getAllMyLists();
		model.addAttribute("list",list);
		return "myLists";
	}
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		com.cp.entity.List l=service.getListId(id);
		MyList ml=new MyList(l.getId(),l.getName(),l.getDescription(),l.getDate());
		myListService.saveMyLists(ml);
		return "redirect:/my_lists";
	}
	
	@RequestMapping("/editList/{id}")
	public String editList(@PathVariable("id") int id,Model model) {
		com.cp.entity.List l=service.getListId(id);
		model.addAttribute("list",l);
		return "listEdit";
	}
	@RequestMapping("/deleteList/{id}")
	public String deleteList(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/available_lists";
	}
}
