package com.mehedi.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;




@Entity
@Table(name = "profile")
@SQLDelete(sql = "UPDATE profile SET is_deleted = true WHERE id=?")
@FilterDef(
        name = "deletedUserFilter",
        parameters = @ParamDef(name = "isDeleted", type = "boolean")
)
@Filter(
        name = "deletedUserFilter",
        condition = "is_deleted = :isDeleted"
)
public class Profile {
    @Id
    @GeneratedValue()
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column(name = "name")
    private String name;

    @CreatedDate
    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Instant createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Instant updatedAt;

    @ManyToMany(mappedBy = "usedBy")
    private Set<Car> cars = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "profile", targetEntity = BadgesToProfile.class)
    private Set<BadgesToProfile> badges;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "profile")
    private Set<TagsToProfile> tags;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Set<BadgesToProfile> getBadges() {
        return badges;
    }

    public void setBadges(Set<BadgesToProfile> badges) {
        this.badges = badges;
    }

    public Set<TagsToProfile> getTags() {
        return tags;
    }

    public void setTags(Set<TagsToProfile> tags) {
        this.tags = tags;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void assignedCar(Car car) {
        cars.add(car);
    }

    public void assignTags(TagsToProfile tagsToProfile) {
        tags.add(tagsToProfile);
    }

    public void assignBadge(BadgesToProfile badgesToProfile) {
        badges.add(badgesToProfile);
    }
}