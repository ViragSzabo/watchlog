package com.java.crush;

import java.time.LocalDate;

public class Idol extends Person
{
    private String stageName;

    public Idol(String stageName, LocalDate birthDate)
    {
        super("", birthDate);
        this.stageName = stageName;
    }

    public String getStageName()
    {
        return stageName;
    }

    public void setStageName(String stageName)
    {
        this.stageName = stageName;
    }
}