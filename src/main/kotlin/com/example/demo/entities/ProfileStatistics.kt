package com.example.demo.entities

class ProfileStatistics(
    var games_won_as_connect_statistics: Statistics? = null,
    var games_won_as_cut_statistics: Statistics? = null,
    var games_lost_as_connect_statistics: Statistics? = null,
    var games_lost_as_cut_statistics: Statistics? = null,
    var number_of_achievements_statistics: Statistics? = null,
    var rating_statistics: Statistics? = null,
    var consecutive_logins_statistics: Statistics? = null,
    var consecutive_logins_max_statistics: Statistics? = null,
) {
}