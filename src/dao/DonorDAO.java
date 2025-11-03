package dao;

import model.Donor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DonorDAO {

    private static final List<Donor> mockDonors = new ArrayList<>();

    static {
        mockDonors.add(createDonor(1, "Alice Johnson", 35, "Kidney", "approved"));
        mockDonors.add(createDonor(2, "Bob Williams", 42, "Liver", "pending"));
    }

    private static Donor createDonor(int id, String name, int age, String organ, String status) {
        Donor d = new Donor();
        d.setId(id);
        d.setName(name);
        d.setAge(age);
        d.setOrgan(organ);
        d.setStatus(status);
        return d;
    }

    public void registerDonor(Donor donor) {
        // Simulate adding to the list for the session
        donor.setId(mockDonors.size() + 1);
        donor.setStatus("pending");
        mockDonors.add(donor);
        System.out.println("Donor added to mock list: " + donor.getName());
    }

    public List<Donor> getAllDonors() {
        return new ArrayList<>(mockDonors); // Return a copy to prevent modification
    }

    public void updateDonorStatus(int donorId, String status) {
        Optional<Donor> donorOptional = mockDonors.stream().filter(d -> d.getId() == donorId).findFirst();
        donorOptional.ifPresent(donor -> {
            donor.setStatus(status);
            System.out.println("Mock donor status updated: " + donor.getName() + " to " + status);
        });
    }
}
