package com.mehedi.jpa.repository;

import com.mehedi.jpa.entity.Profile;
import com.mehedi.jpa.JpaApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.UUID;



@SpringBootTest( classes = JpaApplication.class)
public class ProfileRepositoryTest {

    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    BadgesToProfileRepository badgesToProfileRepository;
    @Test
    @Transactional
    public void saveTest() {
        Profile profile = new Profile();
        profile.setName("Demo Profile");
        profile.setId(String.valueOf(UUID.randomUUID()));
//
//        BadgesToProfile badgesToProfile = new BadgesToProfile();
//        badgesToProfile.setId(String.valueOf(UUID.randomUUID()));
//        badgesToProfile.setBadgeName("Testing Badge");
//
//        Set<BadgesToProfile> badgesToProfileSet = Set.of(badgesToProfile);
//
//
//        profile.setBadges(badgesToProfileSet);
//        badgesToProfile.setProfile(profile);

        profileRepository.save(profile);
//        badgesToProfileRepository.save(badgesToProfile);

    }
}
