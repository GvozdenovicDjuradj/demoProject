package com.example.demo.repositories

import com.example.demo.entities.auth_user
import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<auth_user, Long?> {
}