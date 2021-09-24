package com.example.demo.services

import com.example.demo.entities.achievement
import com.example.demo.repositories.AchievementRepository
import com.example.demo.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AchievementService(
    @Autowired
    private val achievementRepository: AchievementRepository,
    private val userRepository: UserRepository

) {
    fun findAll(): MutableIterable<achievement> {
        return achievementRepository.findAll()
    }

    fun findById(achievementId: Long): achievement {
        return achievementRepository.findById(achievementId).get()
    }

    fun postAchievement(achievement: achievement, userId: Long): achievement {
        val user = userRepository.findById(userId)
        val newAchievement = achievement
        newAchievement.user_id_id = user.get()
        return achievementRepository.save(newAchievement)
    }

    fun updateAchievement(achievement: achievement): achievement {
        return achievementRepository.save(achievement)
    }

    fun deleteAchievementById(achievementId: Long) {
        return achievementRepository.deleteById(achievementId)
    }
}