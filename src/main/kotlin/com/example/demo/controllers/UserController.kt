package com.example.demo.controllers

import com.example.demo.entities.auth_user
import com.example.demo.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("user")
class UserController(
    @Autowired
    private val userService: UserService
) {
    @GetMapping()
    fun findAll() = userService.findAll()

    @GetMapping("{userId}")
    fun findById(
        @PathVariable userId: Long,
    ) = userService.findById(userId)

    @PostMapping()
    fun post(
        @RequestBody user: auth_user,
    ){
        userService.postUser(user)
    }
    @PutMapping()
    fun update(@RequestBody user: auth_user) = userService.updateUser(user)

    @DeleteMapping("/{userId}")
    fun delete(@PathVariable userId: Long) = userService.deleteUserById(userId)
}