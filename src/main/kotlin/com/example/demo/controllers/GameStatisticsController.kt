package com.example.demo.controllers

import com.example.demo.services.GameStatisticsService
import com.example.demo.services.ProfileStatisticsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("game_statistics")
class GameStatisticsController(
    @Autowired
    private val gameStatisticsService: GameStatisticsService
) {
    @GetMapping("count")
    fun getCount() = gameStatisticsService.getCount()

    @GetMapping("most_common_board")
    fun getMostCommonBoard() = gameStatisticsService.getMostCommonBoard()
}