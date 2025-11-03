package dao;

import model.BloodBank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BloodDAO {

    private static final List<BloodBank> mockBloodBanks = new ArrayList<>();

    static {
        mockBloodBanks.add(createBloodBank(1, "City Hospital", "New York", "A+", 10));
        mockBloodBanks.add(createBloodBank(2, "General Hospital", "New York", "O-", 5));
        mockBloodBanks.add(createBloodBank(3, "County Hospital", "Los Angeles", "B+", 8));
        mockBloodBanks.add(createBloodBank(4, "Downtown Clinic", "New York", "A+", 2));
    }

    private static BloodBank createBloodBank(int id, String hospital, String city, String bloodGroup, int units) {
        BloodBank bb = new BloodBank();
        bb.setId(id);
        bb.setHospital(hospital);
        bb.setCity(city);
        bb.setBloodGroup(bloodGroup);
        bb.setUnits(units);
        return bb;
    }

    public List<BloodBank> getBloodStockByCityAndGroup(String city, String bloodGroup) {
        return mockBloodBanks.stream()
                .filter(bb -> bb.getCity().equalsIgnoreCase(city) && bb.getBloodGroup().equalsIgnoreCase(bloodGroup))
                .collect(Collectors.toList());
    }

    public void addBloodStock(BloodBank bloodBank) {
        // Simulate adding to the list
        bloodBank.setId(mockBloodBanks.size() + 1);
        mockBloodBanks.add(bloodBank);
        System.out.println("Blood stock added to mock list: " + bloodBank.getHospital());
    }
}
