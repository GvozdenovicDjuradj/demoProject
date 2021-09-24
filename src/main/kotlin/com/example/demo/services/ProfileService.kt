package com.example.demo.services

import com.example.demo.entities.auth_user
import com.example.demo.entities.profile
import com.example.demo.repositories.ProfileRepository
import com.example.demo.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProfileService(
    @Autowired
    private val profileRepository: ProfileRepository,
    private val userRepository: UserRepository
    ) {

    fun findAll(): MutableIterable<profile> {
        return profileRepository.findAll()
    }

    fun findById(profileId: Long): profile {
        return profileRepository.findById(profileId).get()
    }

    fun postProfile(profile: profile, userId: Long): profile {
        val user = userRepository.findById(userId)
        val newProfile = profile
        newProfile.user_id = user.get()
        return profileRepository.save(newProfile)
    }

    fun updateProfile(profile: profile): profile {
        return profileRepository.save(profile)
    }

    fun deleteProfileById(profileId: Long) {
        return profileRepository.deleteById(profileId)
    }

}