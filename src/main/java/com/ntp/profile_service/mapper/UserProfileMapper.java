package com.ntp.profile_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ntp.profile_service.dto.request.ProfileCreationRequest;
import com.ntp.profile_service.dto.response.UserProfileResponse;
import com.ntp.profile_service.entity.UserProfile;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {

    @Mapping(target = "id", ignore = true)
    UserProfile toUserProfile(ProfileCreationRequest creationRequest);

    UserProfileResponse toUserProfileResponse(UserProfile userProfile);
}
