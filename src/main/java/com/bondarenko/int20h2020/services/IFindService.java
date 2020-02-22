package com.bondarenko.int20h2020.services;

import com.bondarenko.int20h2020.domain.output.Form;

import java.util.List;

public interface IFindService {
    List<Form> getFindDonorForms();
    List<Form> getFindRecipientForms();
    Form setFindDonorForms(Form form);
    Form setFindRecipientForms(Form from);
}
