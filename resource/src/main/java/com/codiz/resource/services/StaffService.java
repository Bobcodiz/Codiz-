package com.codiz.resource.services;

import com.codiz.resource.dto.StaffRegistrationDetails;
import com.codiz.resource.models.StaffModel;
import com.codiz.resource.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class StaffService {

    private final StaffRepository staffRepository;

    //registering a staff
    public StaffModel registerStaff(StaffRegistrationDetails regDetails) {
        log.info("service to register staff");
        StaffModel newStaff = null;
        try {
            StaffModel staff = new StaffModel();
            staff.setFirstName(regDetails.getFirstName());
            staff.setLastName(regDetails.getLastName());
            staff.setEmail(regDetails.getEmail());
            staff.setPhoneNumber(regDetails.getPhoneNumber());
            staff.setPassword(regDetails.getPassword());

            log.info("checking if the staff already exist by email");
            if (!staffRepository.existsStaffModelByEmail(regDetails.getEmail()))
            {
                log.info("inserting the new staff");
                newStaff = staffRepository.save(staff);
            }else {
                log.info("the user already exist");
                throw new RuntimeException("could not insert user");
            }



        } catch (Exception e) {
            throw new RuntimeException("could not register staff");
        }
        return newStaff;
    }

    //getting all staff
    public List<StaffModel> getAllStaff() {
        log.info("service to get all the staff was called");
        List<StaffModel> staffs;
        try {
            staffs = staffRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("no staff exist");
        }
        return staffs;
    }

    //getting a specific staff by id

    public StaffModel getStaff(Long id) {
        log.info("getting a staff");
        StaffModel staff;
        try {
            staff = staffRepository.findById(id).get();
            if (!staffRepository.existsById(id))
            {
                throw new RuntimeException("the staff does not exist");
            }

        } catch (Exception e) {
            throw new RuntimeException("the staff does not exist");
        }
        return staff;
    }
}
