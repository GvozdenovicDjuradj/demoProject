package com.example.demo.services

import com.example.demo.entities.game
import com.example.demo.repositories.BoardRepository
import com.example.demo.repositories.GameRepository
import com.example.demo.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GameService(
    @Autowired
    private val gameRepository: GameRepository,
    private val userRepository: UserRepository,
    private val boardRepository: BoardRepository

) {
    fun findAll(): MutableIterable<game> {
        return gameRepository.findAll()
    }

    fun findById(gameId: Long): game {
        return gameRepository.findById(gameId).get()
    }

    fun postGame(game: game, cutUserId: Long, connectUserId: Long, bordId: Long): game {
        val cutUser = userRepository.findById(cutUserId)
        val connectUser = userRepository.findById(connectUserId)
        val board = boardRepository.findById(bordId)
        val newGame = game
        newGame.cut_player_id = cutUser.get()
        newGame.connect_player_id = connectUser.get()
        newGame.board_id = board.get()
        return gameRepository.save(newGame)
    }

    fun updateGame(game: game): game {
        return gameRepository.save(game)
    }

    fun deleteGameById(gameId: Long) {
        return gameRepository.deleteById(gameId)
    }
}