package com.example.demo.controllers

import com.example.demo.entities.game
import com.example.demo.services.GameService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("game")
class GameController(
    @Autowired
    private val gameService: GameService
)  {
    @GetMapping()
    fun findAll() = gameService.findAll()

    @GetMapping("{gameId}")
    fun findById(
        @PathVariable gameId: Long,
    ) = gameService.findById(gameId)

    @PostMapping()
    fun post(
        @RequestBody game: game,
        @RequestParam(value = "cutUserId", required = true) cutUserId: Long,
        @RequestParam(value = "connectUserId", required = true) connectUserId: Long,
        @RequestParam(value = "boardId", required = true) bordId:Long
        ){
        gameService.postGame(game, cutUserId, connectUserId, bordId)
    }
    @PutMapping()
    fun update(@RequestBody game: game) = gameService.updateGame(game)

    @DeleteMapping("/{gameId}")
    fun delete(@PathVariable gameId: Long) = gameService.deleteGameById(gameId)
}