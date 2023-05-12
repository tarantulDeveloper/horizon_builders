package com.horizonbuilders.server.repository;

import com.horizonbuilders.server.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {
    Boolean existsByName(String name);

//    @Modifying
//    @Query("UPDATE position p SET p.name = :name,p.salary =:salary WHERE id = :id")
//    void update(@Param(value = "id") int id, @Param(value = "name") String name,@Param(value = "salary") double salary);
}
