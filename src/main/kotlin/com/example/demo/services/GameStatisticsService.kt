package com.example.demo.services

import com.example.demo.repositories.GameRepository
import com.example.demo.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GameStatisticsService(
    @Autowired
    private val gameRepository: GameRepository
) {
    fun getCount(): Long {
        return gameRepository.count()
    }

    fun getMostCommonBoard(): String? {
        val allGames = gameRepository.findAll()
        val boardsCount = allGames.mapNotNull { it.board_id?.board_alias }.groupingBy { it }.eachCount()
        return boardsCount.maxByOrNull { it.value }?.key
    }
}