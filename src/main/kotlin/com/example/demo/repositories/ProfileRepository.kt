package com.example.demo.repositories

import com.example.demo.entities.profile
import org.springframework.data.repository.CrudRepository

interface ProfileRepository: CrudRepository<profile, Long?> {

}