package com.cp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.entity.MyList;
import com.cp.repository.MyListRepository;

@Service
public class MyListService {
	
	@Autowired
	private MyListRepository mylist;
	
	public void saveMyLists(MyList list) {
		mylist.save(list);
	}
	
	public List<MyList> getAllMyLists(){
		return mylist.findAll();
	}
	
	public void deleteById(int id) {
		mylist.deleteById(id);
	}
}
