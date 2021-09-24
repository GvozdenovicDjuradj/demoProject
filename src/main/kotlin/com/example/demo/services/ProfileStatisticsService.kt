package com.example.demo.services

import com.example.demo.entities.ProfileStatistics
import com.example.demo.entities.Statistics
import com.example.demo.repositories.ProfileRepository
import org.nield.kotlinstatistics.standardDeviation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProfileStatisticsService(
    @Autowired
    private val profileRepository: ProfileRepository
) {
    fun getStatistics(): ProfileStatistics {
        val allProfiles = profileRepository.findAll()
        val profileStatistics = ProfileStatistics()
        var paramsList = allProfiles.map { it.games_won_as_connect }
        var statistics = Statistics(
            min = paramsList.minOf { it ?: 0 }.toDouble(),
            max = paramsList.maxOf { it ?: 0 }.toDouble(),
            average = paramsList.sumOf { it ?: 0 }.toDouble() / paramsList.count(),
            std = paramsList.mapNotNull { it }.standardDeviation(),
            count = paramsList.count().toLong()
        )
        profileStatistics.games_won_as_connect_statistics = statistics

        paramsList = allProfiles.map { it.consecutive_logins }
        statistics = Statistics(
            min = paramsList.minOf { it ?: 0 }.toDouble(),
            max = paramsList.maxOf { it ?: 0 }.toDouble(),
            average = paramsList.sumOf { it ?: 0 }.toDouble() / paramsList.count(),
            std = paramsList.mapNotNull { it }.standardDeviation(),
            count = paramsList.count().toLong()
        )
        profileStatistics.consecutive_logins_statistics = statistics

        paramsList = allProfiles.map { it.games_lost_as_cut }
        statistics = Statistics(
            min = paramsList.minOf { it ?: 0 }.toDouble(),
            max = paramsList.maxOf { it ?: 0 }.toDouble(),
            average = paramsList.sumOf { it ?: 0 }.toDouble() / paramsList.count(),
            std = paramsList.mapNotNull { it }.standardDeviation(),
            count = paramsList.count().toLong()
        )
        profileStatistics.games_lost_as_cut_statistics = statistics


        paramsList = allProfiles.map { it.games_lost_as_cut }
        statistics = Statistics(
            min = paramsList.minOf { it ?: 0 }.toDouble(),
            max = paramsList.maxOf { it ?: 0 }.toDouble(),
            average = paramsList.sumOf { it ?: 0 }.toDouble() / paramsList.count(),
            std = paramsList.mapNotNull { it }.standardDeviation(),
            count = paramsList.count().toLong()
        )
        profileStatistics.games_lost_as_cut_statistics = statistics

        paramsList = allProfiles.map { it.games_won_as_cut }
        statistics = Statistics(
            min = paramsList.minOf { it ?: 0 }.toDouble(),
            max = paramsList.maxOf { it ?: 0 }.toDouble(),
            average = paramsList.sumOf { it ?: 0 }.toDouble() / paramsList.count(),
            std = paramsList.mapNotNull { it }.standardDeviation(),
            count = paramsList.count().toLong()
        )
        profileStatistics.games_won_as_cut_statistics = statistics


        paramsList = allProfiles.map { it.consecutive_logins_max }
        statistics = Statistics(
            min = paramsList.minOf { it ?: 0 }.toDouble(),
            max = paramsList.maxOf { it ?: 0 }.toDouble(),
            average = paramsList.sumOf { it ?: 0 }.toDouble() / paramsList.count(),
            std = paramsList.mapNotNull { it }.standardDeviation(),
            count = paramsList.count().toLong()
        )
        profileStatistics.consecutive_logins_max_statistics = statistics


        paramsList = allProfiles.map { it.number_of_achievements }
        statistics = Statistics(
            min = paramsList.minOf { it ?: 0 }.toDouble(),
            max = paramsList.maxOf { it ?: 0 }.toDouble(),
            average = paramsList.sumOf { it ?: 0 }.toDouble() / paramsList.count(),
            std = paramsList.mapNotNull { it }.standardDeviation(),
            count = paramsList.count().toLong()
        )
        profileStatistics.number_of_achievements_statistics = statistics

        paramsList = allProfiles.map { it.games_lost_as_connect }
        statistics = Statistics(
            min = paramsList.minOf { it ?: 0 }.toDouble(),
            max = paramsList.maxOf { it ?: 0 }.toDouble(),
            average = paramsList.sumOf { it ?: 0 }.toDouble() / paramsList.count(),
            std = paramsList.mapNotNull { it }.standardDeviation(),
            count = paramsList.count().toLong()
        )
        profileStatistics.games_lost_as_connect_statistics = statistics

        paramsList = allProfiles.map { it.rating }
        statistics = Statistics(
            min = paramsList.minOf { it ?: 0 }.toDouble(),
            max = paramsList.maxOf { it ?: 0 }.toDouble(),
            average = paramsList.sumOf { it ?: 0 }.toDouble() / paramsList.count(),
            std = paramsList.mapNotNull { it }.standardDeviation(),
            count = paramsList.count().toLong()
        )
        profileStatistics.rating_statistics = statistics

        return profileStatistics

    }

    fun getProfilesCount(): Long {
        return profileRepository.count()
    }
}