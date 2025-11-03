package dao;

import model.Assessment;

import java.util.ArrayList;
import java.util.List;

public class AssessmentDAO {

    private static final List<Assessment> mockAssessmentRules = new ArrayList<>();

    static {
        mockAssessmentRules.add(createRule(1, "fever,cough", "Common Cold or Flu. Rest and drink fluids."));
        mockAssessmentRules.add(createRule(2, "headache,nausea", "Migraine or Dehydration. Drink water and rest in a dark room."));
        mockAssessmentRules.add(createRule(3, "fever,rash", "Possible infection. Consult a doctor."));
        mockAssessmentRules.add(createRule(4, "cough", "Could be a common cold, allergies, or something more serious. If it persists, see a doctor."));
    }

    private static Assessment createRule(int id, String symptom, String suggestion) {
        Assessment rule = new Assessment();
        rule.setId(id);
        rule.setSymptom(symptom);
        rule.setSuggestion(suggestion);
        return rule;
    }

    public List<Assessment> getAllAssessmentRules() {
        return new ArrayList<>(mockAssessmentRules); // Return a copy
    }
}
