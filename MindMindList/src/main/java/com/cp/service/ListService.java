package com.cp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.repository.ListRepository;


@Service
public class ListService {
	
	
	@Autowired
	private ListRepository lRepo;
	
	public void save(com.cp.entity.List l) {
		lRepo.save(l);
	}
	public List<com.cp.entity.List> getAllList(){
		return lRepo.findAll();
	}
	public com.cp.entity.List getListId(int id) {
		return lRepo.findById(id).get();
	}
	public void deleteById(int id) {
		lRepo.deleteById(id);
	}
}
