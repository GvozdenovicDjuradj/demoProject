package com.example.demo.entities

import javax.persistence.*

@Entity
@Table(name = "board", schema="public")
class board (
        @Id
        var id: Long? = 0L,

        var board_alias:String? = "",
        var nodes_configuration: String? = "",
        var edges_configuration:String? = "",

        @ManyToOne
        @JoinColumn(name = "creator_id", referencedColumnName = "id")
        var creator_id: auth_user? = null
)