package com.example.demo.controllers

import com.example.demo.entities.achievement
import com.example.demo.services.AchievementService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("achievement")
class AchievementController(
    @Autowired
    private val achievementService: AchievementService
)  {
    @GetMapping()
    fun findAll() = achievementService.findAll()

    @GetMapping("{achievementId}")
    fun findById(
        @PathVariable achievementId: Long,
    ) = achievementService.findById(achievementId)

    @PostMapping()
    fun post(
        @RequestBody achievement: achievement,
        @RequestParam(value = "userId", required = true) userId: Long,
    ){
        achievementService.postAchievement(achievement, userId)
    }
    @PutMapping()
    fun update(@RequestBody achievement: achievement) = achievementService.updateAchievement(achievement)

    @DeleteMapping("/{achievementId}")
    fun delete(@PathVariable achievementId: Long) = achievementService.deleteAchievementById(achievementId)
}