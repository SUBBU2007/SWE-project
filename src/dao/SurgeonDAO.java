package dao;

import model.Surgeon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SurgeonDAO {

    private static final List<Surgeon> mockSurgeons = new ArrayList<>();

    static {
        mockSurgeons.add(createSurgeon(1, "Dr. John Doe", "Orthopedic", "City Hospital", "123 Main St, New York", "555-1234"));
        mockSurgeons.add(createSurgeon(2, "Dr. Jane Smith", "Cardiology", "General Hospital", "456 Oak Ave, New York", "555-5678"));
        mockSurgeons.add(createSurgeon(3, "Dr. Emily White", "Orthopedic", "Uptown Medical", "789 Pine St, New York", "555-8765"));
    }

    private static Surgeon createSurgeon(int id, String name, String specialty, String hospital, String location, String contact) {
        Surgeon s = new Surgeon();
        s.setId(id);
        s.setName(name);
        s.setSpecialty(specialty);
        s.setHospital(hospital);
        s.setLocation(location);
        s.setContact(contact);
        return s;
    }

    public List<Surgeon> getSurgeonsBySpecialty(String specialty) {
        if (specialty == null || specialty.trim().isEmpty()) {
            return new ArrayList<>(); // Return empty list if no specialty is provided
        }
        return mockSurgeons.stream()
                .filter(s -> s.getSpecialty().equalsIgnoreCase(specialty))
                .collect(Collectors.toList());
    }
}
