package com.realestate.demo.bl.repositories;

import com.realestate.demo.model.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<BuildingEntity, Long> {
}
