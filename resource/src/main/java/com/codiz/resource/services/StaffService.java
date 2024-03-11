package com.codiz.resource.services;

import com.codiz.resource.dto.StaffRegistrationDetails;
import com.codiz.resource.models.StaffModel;
import com.codiz.resource.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StaffService {

    private final StaffRepository staffRepository;

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

            newStaff = staffRepository.save(staff);

        } catch (Exception e) {
            throw new RuntimeException("could not register staff");
        }
        return newStaff;
    }
}
