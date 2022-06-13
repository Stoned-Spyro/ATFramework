package API;

import API.BussinesLogic.MeasurementsTest;
import API.BussinesLogic.WaterStoragesTest;
import org.testng.annotations.Test;

public class APITest {

    private static final WaterStoragesTest waterStoragesTest = new WaterStoragesTest();
    private static final MeasurementsTest measurementTest = new MeasurementsTest();

    @Test
    public void createWaterStorage(){
        waterStoragesTest
            .createStorage()
            .getAllStorages()
            .updateStorage("2")
            .getAllStorages();

    }
    @Test
    public void createMeasurement(){
        measurementTest
                .createMeasurement()
                .getAllMeasurements();

    }
    @Test
    public void findMeasurementsByStorage(){
        measurementTest
                .getAllMeasurements()
                .FindMeasurementByWaterStorage("2");
    }
    @Test
    public void findWaterStorageByName(){
        waterStoragesTest
                .getAllStorages()
                .findWaterStorageByName("Zubra")
                .deleteStorage("6");
    }

}
