package com.cgnexus.example_19.model;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * A base class for JPA entities providing common auditing fields.
 * <p>
 * This class uses {@link MappedSuperclass} to indicate that its fields should be
 * mapped to the database columns of its subclasses, but it does not represent
 * a separate table itself. It includes standard audit information: creation timestamp,
 * creator identity, last update timestamp, and last updater identity.
 * <p>
 * To automatically populate these fields, JPA Auditing should be enabled:
 * 1. Add {@code @EnableJpaAuditing} to a Spring configuration class.
 * 2. Ensure {@code spring-data-jpa} is a dependency.
 * 3. Add {@code @EntityListeners(AuditingEntityListener.class)} to this class or
 * concrete entity subclasses. (Recommended to add it here).
 * 4. Annotate the fields in this class with {@code @CreatedDate}, {@code @CreatedBy},
 * {@code @LastModifiedDate}, {@code @LastModifiedBy}.
 * 5. Provide a bean of type {@code AuditorAware<String>} in the Spring context
 * to resolve the current user for {@code @CreatedBy} and {@code @LastModifiedBy}.
 * <p>
 * Using {@link Data} generates standard boilerplate code (getters, setters, toString,
 * equals, hashCode). Consider using more specific annotations like {@link Getter},
 * {@link Setter} if {@code @Data}'s {@code equals}/{@code hashCode} generation causes
 * issues, although this is less common in {@code MappedSuperclass} compared to
 * {@code @Entity} classes with relationships.
 */
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    /**
     * Timestamp indicating when the entity was first persisted.
     * Automatically populated by {@link AuditingEntityListener} if JPA Auditing is enabled.
     */
    @CreatedDate
    private LocalDateTime createdAt;

    /**
     * Identifier (e.g., username) of the principal that created the entity.
     * Automatically populated by {@link AuditingEntityListener} via an {@code AuditorAware} bean
     * if JPA Auditing is enabled.
     */
    @CreatedBy
    private String createdBy;

    /**
     * Timestamp indicating when the entity was last modified.
     * Automatically populated by {@link AuditingEntityListener} if JPA Auditing is enabled.
     */
    @LastModifiedDate
    private LocalDateTime updatedAt;

    /**
     * Identifier (e.g., username) of the principal that last modified the entity.
     * Automatically populated by {@link AuditingEntityListener} via an {@code AuditorAware} bean
     * if JPA Auditing is enabled.
     */
    @LastModifiedBy
    private String updatedBy;
}