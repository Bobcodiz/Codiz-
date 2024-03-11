package com.codiz.resource.controller;

import com.codiz.resource.dto.StaffRegistrationDetails;
import com.codiz.resource.models.StaffModel;
import com.codiz.resource.services.StaffService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
