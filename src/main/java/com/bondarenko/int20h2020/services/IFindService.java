package com.bondarenko.int20h2020.services;

import com.bondarenko.int20h2020.domain.output.Form;

import javax.transaction.Transactional;
import java.util.List;

public interface IFindService {
    List<Form> getFindDonorForms();
    List<Form> getFindRecipientForms();
    @Transactional
    void setFindDonorForms(String email, int phone);
    @Transactional
    void setFindRecipientForms(String email, int phone);
}
