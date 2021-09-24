package com.example.demo.repositories

import com.example.demo.entities.board
import com.example.demo.entities.profile
import org.springframework.data.repository.CrudRepository

interface BoardRepository: CrudRepository<board, Long?> {
}