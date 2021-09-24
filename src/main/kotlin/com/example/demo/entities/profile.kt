package com.example.demo.entities

import javax.persistence.*

@Entity
@Table(name = "profile", schema="public")
class profile (
    @Id
    var id: Long? = 0L,
    var name: String? = "",
    var games_won_as_connect: Int? = 0,
    var games_won_as_cut: Int? = 0,
    var games_lost_as_connect: Int? = 0,
    var games_lost_as_cut: Int? = 0,
    var number_of_achievements: Int? = 0,
    var rating: Int? = 0,
    var consecutive_logins: Int? = 0,
    var consecutive_logins_max: Int? = 0,

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    var user_id: auth_user? = null
)