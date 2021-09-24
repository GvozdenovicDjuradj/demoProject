package com.example.demo.entities

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "auth_user", schema="public")
class auth_user (
        @Id
        var id:Long? = 0L,
        var username:String? = "",
        var first_name: String? = "",
        var last_name:String = "",
        var email:String = ""
)