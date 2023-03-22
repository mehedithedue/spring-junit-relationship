package com.mehedi.jpa.repository;

import com.mehedi.jpa.entity.Car;
import com.mehedi.jpa.entity.TagsToProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsToProfileRepository extends JpaRepository<TagsToProfile, String> {
}
