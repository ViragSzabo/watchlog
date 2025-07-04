package com.java.crush;

import java.util.ArrayList;

public class Company
{
    private String name;
    private final ArrayList<Group> groups;

    public Company(String name)
    {
        this.name = name;
        this.groups = new ArrayList<>();
    }

    public String getName()
    {
        return name;
    }

    public void  setName(String name)
    {
        this.name = name;
    }

    public ArrayList<Group> getGroups()
    {
        return groups;
    }

    public void addGroup(Group group)
    {
        groups.add(group);
    }

    public void removeGroup(Group group)
    {
        groups.remove(group);
    }
}