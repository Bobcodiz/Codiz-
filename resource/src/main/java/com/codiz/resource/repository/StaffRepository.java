package com.codiz.resource.repository;

import com.codiz.resource.models.StaffModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<StaffModel,Long> {
    boolean existsStaffModelByEmail(String email);
}
