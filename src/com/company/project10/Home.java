package com.company.project10;

public class Home {

    String community;
    double price;
    int numBedrooms;
    double acres;
    double schoolDistance;
    double trainDistance;

    public Home(String community, double price, int numBedrooms, double acres, double schoolDistance, double trainDistance) {
        this.community = community;
        this.price = price;
        this.numBedrooms = numBedrooms;
        this.acres = acres;
        this.schoolDistance = schoolDistance;
        this.trainDistance = trainDistance;
    }

    @Override
    public String toString() {
        return "price " + price + " number of bedrooms " + numBedrooms + " in community " + community
                + " properties " + acres + " school distance "
                + schoolDistance + " train distance " + trainDistance;
    }
}
