package week11.salma.id.ac.umn;

import java.util.ArrayList;

public class Candidate extends User {
    private ArrayList<String> submissions;

    public Candidate(String name, String email) {
        super(name, email);
        this.submissions = new ArrayList<>();
    }

    public void applyJob(Job job, String name, String education) {
        String submission = "Name: " + name + "\nEducation: " + education + "\n" + job;
        submissions.add(submission);
    }

    public void displaySubmission() {
        if (submissions.isEmpty()) {
            System.out.println("Anda belum mendaftar pekerjaan.");
        } else {
            System.out.println("\n=== Submission ===");
            for (String submission : submissions) {
                System.out.println(submission);
            }
        }
    }
}