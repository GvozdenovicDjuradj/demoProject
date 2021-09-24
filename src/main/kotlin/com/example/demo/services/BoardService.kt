package com.example.demo.services

import com.example.demo.entities.board
import com.example.demo.repositories.BoardRepository
import com.example.demo.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BoardService(
    @Autowired
    private val boardRepository: BoardRepository,
    private val userRepository: UserRepository

) {
    fun findAll(): MutableIterable<board> {
        return boardRepository.findAll()
    }

    fun findById(boardId: Long): board {
        return boardRepository.findById(boardId).get()
    }

    fun postBoard(board: board, userId: Long): board {
        val user = userRepository.findById(userId)
        val newBoard = board
        newBoard.creator_id = user.get()
        return boardRepository.save(newBoard)
    }

    fun updateBoard(board: board): board {
        return boardRepository.save(board)
    }

    fun deleteBoardById(boardId: Long) {
        return boardRepository.deleteById(boardId)
    }
}