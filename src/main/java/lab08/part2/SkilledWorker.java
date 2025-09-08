package lab08.part2;

import java.util.ArrayList;

public class SkilledWorker extends Employee {
    private ArrayList<String> skills;

    public SkilledWorker(String name, String jobTitle) {
        super(name, jobTitle);
        this.skills = new ArrayList<>();
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void addSkill(String skill) {
        skills.add(skill);
    }

    public String getInfo() {
        String result = super.getInfo();
        return result;
    }

}