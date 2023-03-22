package com.mehedi.jpa.controller;

import com.mehedi.jpa.entity.BadgesToProfile;
import com.mehedi.jpa.entity.Car;
import com.mehedi.jpa.entity.Profile;
import com.mehedi.jpa.entity.TagsToProfile;
import com.mehedi.jpa.repository.BadgesToProfileRepository;
import com.mehedi.jpa.repository.CarRepository;
import com.mehedi.jpa.repository.ProfileRepository;
import com.mehedi.jpa.repository.TagsToProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    CarRepository carRepository;
    @Autowired
    TagsToProfileRepository tagsToProfileRepository;
    @Autowired
    BadgesToProfileRepository badgesToProfileRepository;


    @GetMapping
    List<Profile> getProfiles() {
        return profileRepository.findAll();
    }


    @GetMapping("/cars")
    List<Car> getProfileCar() {
        return carRepository.findAll();
    }

    @GetMapping("/tags")
    List<TagsToProfile> getProfileTags() {
        return tagsToProfileRepository.findAll();
    }

    @PostMapping
    Profile createProfile(@RequestBody Profile profile) {
        return profileRepository.save(profile);
    }

    @PutMapping("/{profileId}/cars/{carId}")
    Profile assignCars(@PathVariable Long profileId, @PathVariable Long carId) {
        Profile profile = profileRepository.findById(profileId).get();
        Car car = carRepository.findById(carId).get();
        car.setUsedBy(profile);
        profile.assignedCar(car);
        return profileRepository.save(profile);
    }


    @PutMapping("/{profileId}/tags/{tagId}")
    Profile assigneTags(@PathVariable Long profileId, @PathVariable String tagId) {
        Profile profile = profileRepository.findById(profileId).get();
        TagsToProfile tagsToProfile = tagsToProfileRepository.findById(tagId).get();
        tagsToProfile.setProfile(profile);
        profile.assignTags(tagsToProfile);
        return profileRepository.save(profile);
    }
    @PutMapping("/{profileId}/badge/{badgeId}")
    Profile assignBadge(@PathVariable Long profileId, @PathVariable String badgeId) {
        Profile profile = profileRepository.findById(profileId).get();
        BadgesToProfile badgesToProfile = badgesToProfileRepository.findById(badgeId).get();
        badgesToProfile.setProfile(profile);
        profile.assignBadge(badgesToProfile);
        return profileRepository.save(profile);
    }
}