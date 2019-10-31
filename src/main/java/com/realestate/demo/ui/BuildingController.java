package com.realestate.demo.ui;

import java.util.List;

import com.realestate.demo.bl.exception.BuildingNotFoundException;
import com.realestate.demo.bl.repositories.BuildingRepository;
import com.realestate.demo.model.BuildingEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class BuildingController {

    private final BuildingRepository repository;

    BuildingController(BuildingRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/buildings")
    List<BuildingEntity> all() {
        return repository.findAll();
    }

    @PostMapping("/buildings")
    BuildingEntity newBuilding(@RequestBody BuildingEntity buildingEntity) {
        return repository.save(buildingEntity);
    }

    // Single item

    @GetMapping("/buildings/{id}")
    BuildingEntity one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new BuildingNotFoundException(id));
    }

    @PutMapping("/buildings/{id}")
    BuildingEntity replaceBuilding(@RequestBody BuildingEntity newBuilding, @PathVariable Long id) {

        return repository.findById(id)
                .map(building -> {
                    building.setName(newBuilding.getName());
                    building.setRole(newBuilding.getRole());
                    return repository.save(building);
                })
                .orElseGet(() -> {
                    newBuilding.setId(id);
                    return repository.save(newBuilding);
                });
    }

    @DeleteMapping("/buildings/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
