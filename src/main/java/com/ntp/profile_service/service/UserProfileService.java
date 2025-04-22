package com.ntp.profile_service.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.ntp.profile_service.dto.request.ProfileCreationRequest;
import com.ntp.profile_service.dto.response.UserProfileResponse;
import com.ntp.profile_service.entity.UserProfile;
import com.ntp.profile_service.mapper.UserProfileMapper;
import com.ntp.profile_service.repository.UserProfileRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
@Service
public class UserProfileService {

    UserProfileRepository userProfileRepository;
    UserProfileMapper userProfileMapper;

    public UserProfileResponse createUserProfile(ProfileCreationRequest request) {
        UserProfile userProfile = userProfileMapper.toUserProfile(request);
        userProfile = userProfileRepository.save(userProfile);
        log.info("User profile created with ID: {}", userProfile.getId());
        return userProfileMapper.toUserProfileResponse(userProfile);
    }

    public UserProfileResponse getUserProfile(String id) {
        UserProfile userProfile = userProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User profile not found"));
        return userProfileMapper.toUserProfileResponse(userProfile);
    }

    public void deleteUserProfile(String id) {
        userProfileRepository.deleteById(id);
        log.info("User profile with ID: {} deleted", id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public List<UserProfileResponse> getAllUserProfiles() {
        List<UserProfile> userProfiles = userProfileRepository.findAll();
        return userProfiles.stream()
                .map(userProfileMapper::toUserProfileResponse)
                .toList();
    }

}
