package com.cp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cp.entity.MyList;
@Repository
public interface MyListRepository extends JpaRepository<MyList,Integer>  {

}


