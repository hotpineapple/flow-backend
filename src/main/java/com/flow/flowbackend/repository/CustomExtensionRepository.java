package com.flow.flowbackend.repository;

import com.flow.flowbackend.entity.CustomExtension;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomExtensionRepository extends JpaRepository<CustomExtension, String> {
    Optional<CustomExtension> findByName(String name);

    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    @Query(value = "SELECT COUNT(*) FROM CustomExtension c WHERE c.enabled = true")
    int countByEnabled();

    List<CustomExtension> findAllByEnabled(boolean enabled, Sort sort);

    Optional<CustomExtension> findByNameAndEnabled(String name, boolean enabled);

}
