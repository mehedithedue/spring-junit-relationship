package com.mehedi.jpa.repository;

import com.mehedi.jpa.entity.BadgesToProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadgesToProfileRepository extends JpaRepository<BadgesToProfile, String> {
}
