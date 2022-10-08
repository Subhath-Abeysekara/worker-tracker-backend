package com.intouncommon.backend.Repository;

import com.intouncommon.backend.Entity.statecodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface statecodesRepository extends JpaRepository<statecodes, Long> {
}
