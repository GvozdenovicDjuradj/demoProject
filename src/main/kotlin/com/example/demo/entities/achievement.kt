package com.example.demo.entities

import javax.persistence.*


@Entity
@Table(name = "achievement", schema="public")
class achievement(
    @Id
    var id: Long? = 0L,
    var value: Int? = 0,
    var explanation: Int? = 0,

    @ManyToOne
    @JoinColumn(name = "user_id_id", referencedColumnName = "id")
    var user_id_id: auth_user? = null

)