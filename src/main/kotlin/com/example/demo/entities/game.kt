package com.example.demo.entities

import javax.persistence.*

@Entity
@Table(name = "game", schema="public")
class game (
        @Id
        var id: Long? = 0L,

        @ManyToOne
        @JoinColumn(name = "connect_player_id", referencedColumnName = "id")
        var connect_player_id: auth_user? = null,
        @ManyToOne
        @JoinColumn(name = "cut_player_id", referencedColumnName = "id")
        var cut_player_id: auth_user? = null,
        @ManyToOne
        @JoinColumn(name = "board_id", referencedColumnName = "id")
        var board_id: board? = null,
        var edges_configuration:String? = "",
        var player_won:Int?=0,
        var timestamp:Long?=0L
)