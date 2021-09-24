package com.example.demo.controllers

import com.example.demo.services.ProfileStatisticsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("profile_statistics")
class ProfileStatisticsController(
    @Autowired
    private val profileStatisticsService: ProfileStatisticsService
) {

    @GetMapping()
    fun getStatistics() = profileStatisticsService.getStatistics()

    @GetMapping("count")
    fun getProfilesCount() = profileStatisticsService.getProfilesCount()
}