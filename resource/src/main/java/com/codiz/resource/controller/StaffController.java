package com.codiz.resource.controller;

import com.codiz.resource.dto.StaffRegistrationDetails;
import com.codiz.resource.models.StaffModel;
import com.codiz.resource.services.StaffService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/staff")
public class StaffController {

    private final StaffService staffService;

    @PostMapping("/register")
    public StaffModel register(@RequestBody StaffRegistrationDetails regDetails)
    {
        log.info("service to register a new staff");
        return staffService.registerStaff(regDetails);
    }

    @GetMapping("/get-all-staff")
    public List<StaffModel> getAllStaff()
    {
        log.info("request to get all staff");
        return staffService.getAllStaff();
    }

    @GetMapping("/get/{id}")
    public StaffModel getStaff(@PathVariable Long id)
    {
        log.info("request to get staff with id : "+id);
        return staffService.getStaff(id);
    }

    @PutMapping("/update-staff/{id}")
    public StaffModel updateStaff(@PathVariable Long id,
                                  @RequestBody StaffRegistrationDetails details)
    {
        log.info("request to update staff details");
        return staffService.updateStaff(id,details);
    }
}
