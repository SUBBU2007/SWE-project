package dao;

import model.TestCost;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestDAO {

    private static final List<TestCost> mockTestCosts = new ArrayList<>();

    static {
        mockTestCosts.add(createTestCost(1, "MRI Scan", "City Diagnostics", 300.00, true));
        mockTestCosts.add(createTestCost(2, "X-Ray", "General Labs", 75.50, true));
        mockTestCosts.add(createTestCost(3, "Blood Test", "County Labs", 50.00, false));
        mockTestCosts.add(createTestCost(4, "MRI Scan", "Advanced Imaging", 350.00, false));
    }

    private static TestCost createTestCost(int id, String testName, String labName, double cost, boolean insurance) {
        TestCost tc = new TestCost();
        tc.setId(id);
        tc.setTestName(testName);
        tc.setLabName(labName);
        tc.setCost(cost);
        tc.setInsurance(insurance);
        return tc;
    }

    public List<TestCost> getTestCostsByName(String testName) {
        return mockTestCosts.stream()
                .filter(tc -> tc.getTestName().equalsIgnoreCase(testName))
                .collect(Collectors.toList());
    }

    public void addTest(TestCost testCost) {
        // Simulate adding to the list
        testCost.setId(mockTestCosts.size() + 1);
        mockTestCosts.add(testCost);
        System.out.println("Test added to mock list: " + testCost.getTestName());
    }
}
