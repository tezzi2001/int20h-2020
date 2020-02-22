package com.bondarenko.int20h2020.services;

import com.bondarenko.int20h2020.domain.entities.FindDonor;
import com.bondarenko.int20h2020.domain.entities.FindRecipient;
import com.bondarenko.int20h2020.domain.output.BriefDescription;
import com.bondarenko.int20h2020.domain.output.Form;
import com.bondarenko.int20h2020.domain.output.FullDescription;
import com.bondarenko.int20h2020.repositories.FindDonorRepository;
import com.bondarenko.int20h2020.repositories.FindRecipientRepository;
import com.bondarenko.int20h2020.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FindService implements IFindService {
    private FindDonorRepository findDonorRepository;
    private FindRecipientRepository findRecipientRepository;
    private UserRepository userRepository;

    @Override
    public List<Form> getFindDonorForms() {
        List<FindDonor> findDonorList = findDonorRepository.findAll();
        List<Form> formList = new ArrayList<>();
        for (FindDonor findDonor: findDonorList) {
            formList.add(new Form(findDonor.getId(), new BriefDescription(findDonor.getPerson().getName(), findDonor.getPerson().getBloodGroup().getGroupNumber(), findDonor.getPerson().getBloodGroup().getRh(), findDonor.getPerson().getRegion()), new FullDescription(findDonor.getPerson().getBirthDate(), findDonor.getPerson().getEmail(), findDonor.getPerson().getBloodGroup().getGroupNumber(), findDonor.getPerson().getName(), findDonor.getPerson().getRegion(), findDonor.getPerson().getBloodGroup().getRh(), findDonor.getPerson().getSex(), findDonor.getPhone())));
        }
        return formList;
    }

    @Override
    public List<Form> getFindRecipientForms() {
        List<FindRecipient> findRecipientList = findRecipientRepository.findAll();
        List<Form> formList = new ArrayList<>();
        for (FindRecipient findRecipient: findRecipientList) {
            formList.add(new Form(findRecipient.getId(), new BriefDescription(findRecipient.getPerson().getName(), findRecipient.getPerson().getBloodGroup().getGroupNumber(), findRecipient.getPerson().getBloodGroup().getRh(), findRecipient.getPerson().getRegion()), new FullDescription(findRecipient.getPerson().getBirthDate(), findRecipient.getPerson().getEmail(), findRecipient.getPerson().getBloodGroup().getGroupNumber(), findRecipient.getPerson().getName(), findRecipient.getPerson().getRegion(), findRecipient.getPerson().getBloodGroup().getRh(), findRecipient.getPerson().getSex(), findRecipient.getPhone())));
        }
        return formList;
    }

    @Override
    public void setFindDonorForms(String email, int phone) {
        findDonorRepository.save(new FindDonor(userRepository.getPersonByEmail(email).get(), phone));
    }

    @Override
    public void setFindRecipientForms(String email, int phone) {
        findRecipientRepository.save(new FindRecipient(userRepository.getPersonByEmail(email).get(), phone));
    }
}
