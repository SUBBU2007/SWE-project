package dao;

import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAO {

    private static final List<User> mockUsers = new ArrayList<>();

    static {
        // Admin User
        User admin = new User();
        admin.setId(1);
        admin.setName("Admin User");
        admin.setEmail("admin@healthcare.com");
        admin.setPassword("admin123"); // Plain text for demo
        admin.setRole("admin");
        mockUsers.add(admin);

        // Regular User
        User user = new User();
        user.setId(2);
        user.setName("Regular User");
        user.setEmail("user@healthcare.com");
        user.setPassword("user123"); // Plain text for demo
        user.setRole("user");
        mockUsers.add(user);
    }

    public void createUser(User user) {
        // Simulate auto-incrementing ID
        user.setId(mockUsers.size() + 1);
        mockUsers.add(user);
        System.out.println("User added to mock list: " + user.getName());
    }

    public User getUserByEmail(String email) {
        Optional<User> userOptional = mockUsers.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst();
        return userOptional.orElse(null);
    }

    // No hashing needed for the mock implementation
}
