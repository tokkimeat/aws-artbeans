package com.spboot.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spboot.test.dto.DataTable;
import com.spboot.test.entity.Board;
import com.spboot.test.repository.BoardRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BoardController {

   @Autowired
   private BoardRepository bRepo;
   
   @GetMapping("/boards")
   public DataTable<Board> getLists(Pageable pageable, DataTable<Board> dt){
      Page<Board> pb = bRepo.findAll(pageable);
      dt.setData(pb.getContent());
      dt.setRecordsTotal(pb.getTotalElements());
      dt.setRecordsFiltered(pb.getTotalElements());
      
	   log.info("pageable=>{}",pageable);
      return dt;
   }
}