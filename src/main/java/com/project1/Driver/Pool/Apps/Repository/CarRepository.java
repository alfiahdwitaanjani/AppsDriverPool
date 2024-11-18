package com.project1.Driver.Pool.Apps.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.project1.Driver.Pool.Apps.Entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    @Query(value = "Select * from car where id = ?1", nativeQuery = true)
    Optional<Car> getbyid(int id);

    Car getById(Car car);
}
