package com.spboot.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spboot.test.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {

}
