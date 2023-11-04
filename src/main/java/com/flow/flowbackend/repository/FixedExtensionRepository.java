package com.flow.flowbackend.repository;

import com.flow.flowbackend.entity.FixedExtension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FixedExtensionRepository extends JpaRepository<FixedExtension, String> {

    @Modifying
    @Query("UPDATE FixedExtension f SET f.isBlocked = :isBlocked where f.name = :name")
    int updateIsBlocked(String name, boolean isBlocked);

}
