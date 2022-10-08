package com.intouncommon.backend.Repository;

import com.intouncommon.backend.Entity.producers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface producerRepository extends JpaRepository<producers, Long> {
}
