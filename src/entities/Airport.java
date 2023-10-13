package entities;

import utils.UniqueId;

import java.util.List;

public class Airport {

    private String id;
    private String name;
    private Double runawaySize;
    private Double maxFixedWingParkingPlace;
    private List<String> fixedWingId;
    private Double maxRotatedWingParkingPlace;
    private List<String> helicopterId;

    public Airport(){}

    public Airport(String name, Double runawaySize, Double maxFixedWingParkingPlace, List<String> fixedWingId, Double maxRotatedWingParkingPlace, List<String> helicopterId) {
        this.id = UniqueId.generateId("AP");
        this.name = name;
        this.runawaySize = runawaySize;
        this.maxFixedWingParkingPlace = maxFixedWingParkingPlace;
        this.fixedWingId = fixedWingId;
        this.maxRotatedWingParkingPlace = maxRotatedWingParkingPlace;
        this.helicopterId = helicopterId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRunawaySize() {
        return runawaySize;
    }

    public void setRunawaySize(Double runawaySize) {
        this.runawaySize = runawaySize;
    }

    public Double getMaxFixedwingParkingPlace() {
        return maxFixedWingParkingPlace;
    }

    public void setMaxFixedWingParkingPlace(Double maxFixedWingParkingPlace) {
        this.maxFixedWingParkingPlace = maxFixedWingParkingPlace;
    }

    public List<String> getFixedWingId() {
        return fixedWingId;
    }

    public void setFixedWingId(List<String> fixedWingId) {
        this.fixedWingId = fixedWingId;
    }

    public List<String> getHelicopterId() {
        return helicopterId;
    }

    public void setHelicopterId(List<String> helicopterId) {
        this.helicopterId = helicopterId;
    }

    public Double getMaxRotatedWingParkingPlace() {
        return maxRotatedWingParkingPlace;
    }

    public void setMaxRotatedWingParkingPlace(Double maxRotatedWingParkingPlace) {
        this.maxRotatedWingParkingPlace = maxRotatedWingParkingPlace;
    }

    private void fixedWingRunawayCheck(FixedWing fw) {
        if (fw.getMinNeededRunawaySize() > runawaySize) {
            throw new IllegalArgumentException("Cannot accommodate the fixed-wing aircraft: " +
                    runawaySize + "/" + fw.getMinNeededRunawaySize());
        } else {
            this.fixedWingId.add(fw.getId());
        }
    }
}
