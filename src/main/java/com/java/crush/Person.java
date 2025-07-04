package com.java.crush;

import java.time.LocalDate;

public abstract class Person
{
    public String fullName;
    public LocalDate birthDate;

    public Person(String fullName, LocalDate birthDate)
    {
        this.fullName = fullName;
        this.birthDate = birthDate;
    }

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public LocalDate getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate)
    {
        this.birthDate = birthDate;
    }
}