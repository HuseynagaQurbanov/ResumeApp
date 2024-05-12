package com.company.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserForm {

    @NotEmpty(message = "Bos ola bilmez")
    @Size(min = 3, message = "3 xarakterden asagi ola bilmez")
    private String name;

    @NotEmpty(message = "Bos ola bilmez")
    private String surname;
    private Integer nationalityId;

    public UserForm() {
    }

    public UserForm(Integer nationalityId, String surname, String name) {
        this.nationalityId = nationalityId;
        this.surname = surname;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(Integer nationalityId) {
        this.nationalityId = nationalityId;
    }
}
