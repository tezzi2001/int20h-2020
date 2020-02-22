package com.bondarenko.int20h2020.controllers;

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
    public Form addFindDonor(Form form) {
        return findService.setFindDonorForms(form);
    }

    @PostMapping("/addFindRecipient")
    public Form addFindRecipient(Form form) {
        return findService.setFindDonorForms(form);
    }
}
