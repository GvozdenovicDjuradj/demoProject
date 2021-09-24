package com.example.demo.controllers

import com.example.demo.entities.profile
import com.example.demo.services.ProfileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("profile")
class ProfileController(
    @Autowired
    private val profileService: ProfileService
) {

    @GetMapping()
    fun findAll() = profileService.findAll()

    @GetMapping("{profileId}")
    fun findById(
        @PathVariable profileId: Long,
    ) = profileService.findById(profileId)

    @PostMapping()
    fun post(
        @RequestBody profile: profile,
        @RequestParam(value = "userId", required = true) userId: Long,
    ){
        profileService.postProfile(profile, userId)
    }
    @PutMapping()
    fun update(@RequestBody profile: profile) = profileService.updateProfile(profile)

    @DeleteMapping("/{profileId}")
    fun delete(@PathVariable profileId: Long) = profileService.deleteProfileById(profileId)


}