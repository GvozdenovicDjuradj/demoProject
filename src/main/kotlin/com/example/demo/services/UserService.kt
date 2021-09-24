package com.example.demo.services

import com.example.demo.entities.auth_user
import com.example.demo.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService(
    @Autowired
    private val userRepository: UserRepository
) {
    fun findAll(): MutableIterable<auth_user> {
        return userRepository.findAll()
    }

    fun findById(userId: Long): auth_user {
        return userRepository.findById(userId).get()
    }

    fun postUser(user: auth_user): auth_user {
        return userRepository.save(user)
    }

    fun updateUser(user: auth_user): auth_user {
        return userRepository.save(user)
    }

    fun deleteUserById(userId: Long) {
        return userRepository.deleteById(userId)
    }
}