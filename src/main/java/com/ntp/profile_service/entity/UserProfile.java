package com.ntp.profile_service.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Node("user-profile")
public class UserProfile {

    @Id
    @GeneratedValue(generatorClass = UUIDStringGenerator.class)
    String id;
    @Property("userId")
    String userId;
    String firstName;
    String lastName;
    LocalDate dateOfBirth;
    String city;
}
