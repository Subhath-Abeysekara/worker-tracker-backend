package com.intouncommon.backend.Repository;

import com.intouncommon.backend.Entity.productImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productionImageRepository extends JpaRepository<productImages, Long> {
}
