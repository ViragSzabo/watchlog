package com.java.crush;

import java.util.ArrayList;

public class Group
{
    private int id;
    private String name;
    private final ArrayList<Idol> idols;

    public Group(int id, String name)
    {
        this.id = id;
        this.name = name;
        this.idols = new ArrayList<>();
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public ArrayList<Idol> getIdols()
    {
        return idols;
    }

    public void addIdol(Idol idol)
    {
        idols.add(idol);
    }

    public void removeIdol(Idol idol)
    {
        idols.remove(idol);
    }
}