package com.ntp.profile_service.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntp.profile_service.dto.request.ProfileCreationRequest;
import com.ntp.profile_service.dto.response.UserProfileResponse;
import com.ntp.profile_service.service.UserProfileService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("internal/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class InternalUserProfileController {

    UserProfileService userProfileService;

    @PostMapping
    public UserProfileResponse createUserProfile(@RequestBody ProfileCreationRequest request) {
        return userProfileService.createUserProfile(request);
    }

    @DeleteMapping("/{id}")
    public void deleteUserProfile(@PathVariable String id) {
        userProfileService.deleteUserProfile(id);
    }

}
