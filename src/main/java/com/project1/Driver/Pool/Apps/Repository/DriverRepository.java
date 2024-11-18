package com.project1.Driver.Pool.Apps.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.project1.Driver.Pool.Apps.Entity.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {
    @Query(value = "Select * from driver where id = ?1", nativeQuery = true)
    Optional<Driver> getbyid(int id);

    Driver getById(Driver driver);
}
