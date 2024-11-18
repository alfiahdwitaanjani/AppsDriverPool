package com.project1.Driver.Pool.Apps.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project1.Driver.Pool.Apps.Entity.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, Integer> {

}
