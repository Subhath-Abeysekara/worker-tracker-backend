package com.intouncommon.backend.Repository;

import com.intouncommon.backend.Entity.uncommonProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface uncommonRepository extends JpaRepository<uncommonProduct, Long> {
    @Query("select P.statecodes from uncommonProduct P where P.id=:id")
    Long getStateCode(Long id);
    @Transactional
    @Modifying
    @Query("update uncommonProduct P set P.statecodes=:state where P.statecodes=:oldState")
    void setStateCode(Long state, Long oldState);
}
