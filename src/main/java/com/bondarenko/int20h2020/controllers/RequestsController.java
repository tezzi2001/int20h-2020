package com.bondarenko.int20h2020.controllers;

import com.bondarenko.int20h2020.domain.entities.FindDonor;
import com.bondarenko.int20h2020.domain.entities.Person;
import com.bondarenko.int20h2020.domain.output.Form;
import com.bondarenko.int20h2020.services.IFindService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class RequestsController {
    private IFindService findService;

    @GetMapping("/findDonors")
    public List<Form> getFindDonors() {
        return findService.getFindDonorForms();
    }

    @GetMapping("/findRecipient")
    public List<Form> getFindRecipient() {
        return findService.getFindRecipientForms();
    }

    @PostMapping("/addFindDonor")
    public void addFindDonor(String email, int phone) {
        findService.setFindDonorForms(email, phone);
    }

    @PostMapping("/addFindRecipient")
    public void addFindRecipient(String email, int phone) {
        findService.setFindRecipientForms(email, phone);
    }
}
