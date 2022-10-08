package com.workTraker.backend.Repository.exception;

import com.workTraker.backend.Entity.employee;
import org.apache.catalina.util.Introspection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface employeeRepo extends JpaRepository<employee, Long> {
}
