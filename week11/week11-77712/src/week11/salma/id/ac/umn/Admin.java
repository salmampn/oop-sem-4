package week11.salma.id.ac.umn;

import java.util.ArrayList;

class Admin extends User {
    private ArrayList<String> submissions;

    public Admin(String name, String email) {
        super(name, email);
        this.submissions = new ArrayList<>();
        submissions.add("1. Veyne Aurelius - Business Intelligence Analyst");
        submissions.add("2. Chloe Vlence - Manager E-commerce");
    }

    public void sendEmail(String recipient, boolean pass) {
        String status = pass ? "Lolos" : "Tidak Lolos";
        String message = pass ? "Congratulation! You being advanced to step 2 : Interview process."
                : "Unfortunately, based on the result we will not be advancing your application to the next step.";
        if (pass) {
            for (int i = 0; i < submissions.size(); i++) {
                if (submissions.get(i).startsWith(recipient)) {
                    submissions.set(i, submissions.get(i) + "\nDetails : " + message);
                    break;
                }
            }
        }

        System.out.println("\nEmail has been sent to " + recipient);
        System.out.println("Message Content: " + message);
    }

    public void addSubmission(String submission) {
        submissions.add(submission);
    }

    public void displaySubmissions() {
        if (submissions.isEmpty()) {
            System.out.println("Tidak ada submission saat ini.");
        } else {
            System.out.println("=== Submissions ===");
            for (String submission : submissions) {
                System.out.println(submission);
            }
        }
    }
}