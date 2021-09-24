package com.example.demo.controllers

import com.example.demo.entities.board
import com.example.demo.services.BoardService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("board")
class BoardController(
    @Autowired
    private val boardService: BoardService
)  {
    @GetMapping()
    fun findAll() = boardService.findAll()

    @GetMapping("{boardId}")
    fun findById(
        @PathVariable boardId: Long,
    ) = boardService.findById(boardId)

    @PostMapping()
    fun post(
        @RequestBody board: board,
        @RequestParam(value = "userId", required = true) userId: Long,
    ){
        boardService.postBoard(board, userId)
    }
    @PutMapping()
    fun update(@RequestBody board: board) = boardService.updateBoard(board)

    @DeleteMapping("/{boardId}")
    fun delete(@PathVariable boardId: Long) = boardService.deleteBoardById(boardId)
}