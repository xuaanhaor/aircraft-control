package entities;

import constants.PlaneType;
import utils.UniqueId;
import utils.Validate;


public class FixedWing extends Airplane {
    private String planeType;
    private Double minNeededRunawaySize;

    public FixedWing(String model, Double cruiseSpeed, Double emptyWeight, Double maxTakeoffWeight, Integer planeType, Double minNeededRunawaySize) {
        super(UniqueId.generateId("FW"), Validate.checkModel(model), cruiseSpeed, emptyWeight, maxTakeoffWeight);
        planeTypeChoice(planeType);
        this.minNeededRunawaySize = minNeededRunawaySize;
    }

    private void planeTypeChoice(Integer planeType) {
        switch (planeType) {
            case 1:
                this.planeType = PlaneType.CAR.getValue();
                break;
            case 2:
                this.planeType = PlaneType.LRG.getValue();
                break;
            case 3:
                this.planeType = PlaneType.PRV.getValue();
                break;
            default:
                throw new IllegalArgumentException("Invalid plane type");
        }
    }

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    @Override
    public void flyMethod() {
        System.out.println("Fixed Wing");
    }

    public void setMinNeededRunawaySize(Double minNeededRunawaySize) {
        this.minNeededRunawaySize = minNeededRunawaySize;
    }

    public Double getMinNeededRunawaySize() {
        return minNeededRunawaySize;
    }
}
