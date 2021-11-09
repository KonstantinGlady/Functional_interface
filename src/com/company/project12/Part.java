package com.company.project12;

import java.util.ArrayList;
import java.util.List;

public class Part {
    String name;
    String manu;
    int hoursToInstall;
    List<Item> models;

    public Part(String name, String manu, int hoursToInstall, Item... it) {
        this.name = name;
        this.manu = manu;
        this.hoursToInstall = hoursToInstall;
        this.models = new ArrayList<>();
        for (Item i : it) {
            models.add(i);
        }
    }

    @Override
    public String toString() {
        return " manu=" + manu + " hours=" + hoursToInstall + " models=" + models;
    }
}
