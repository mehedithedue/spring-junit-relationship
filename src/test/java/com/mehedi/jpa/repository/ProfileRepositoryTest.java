package com.mehedi.jpa.repository;

import com.mehedi.jpa.entity.Profile;
import com.mehedi.jpa.JpaApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;



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


    @Test
    public void findByID_present(){
        Optional<Profile> profile = profileRepository.findById(1L);
        assertTrue(profile.isPresent());
    }
    @Test
    public void findByID_not_present(){
        Optional<Profile> profile = profileRepository.findById(5L);
        assertFalse(profile.isPresent());
    }
}
