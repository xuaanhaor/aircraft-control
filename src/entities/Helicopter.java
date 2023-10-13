package entities;

import utils.UniqueId;

public class Helicopter extends Airplane {

    private Double range;

    public Helicopter(String model, Double cruiseSpeed, Double emptyWeight, Double maxTakeoffWeight, Double range) {
        super(UniqueId.generateId("RW"), model, cruiseSpeed, emptyWeight, maxTakeoffWeight);
        if (maxTakeoffWeight > 1.5 * emptyWeight) {
            throw new IllegalArgumentException("Max takeoff weight cannot exceed 1.5 times empty weight");
        }
        this.range = range;
    }

    public Double getRange() {
        return range;
    }

    public void setRange(Double range) {
        this.range = range;
    }

    @Override
    public void flyMethod() {
        System.out.println("Rotated Wing");
    }
}
