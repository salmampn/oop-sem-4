package week11.salma.id.ac.umn;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Job> jobs = new ArrayList<>();
    private static ArrayList<Candidate> candidates = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String email, password;

        System.out.println("\n=== MENU ===");
        System.out.println("1. Login");
        System.out.println("2. Sign Up");
        System.out.println("0. Exit Program");
        System.out.print("Pilih menu: ");
        int menuChoice = input.nextInt();
        input.nextLine();

        switch (menuChoice) {
            case 1:
                System.out.println("\n=== LOGIN ===");
                System.out.print("Email : ");
                email = input.nextLine();
                System.out.print("Password : ");
                password = input.nextLine();

                login(email, password);
                break;
            case 2:
                System.out.println("\n=== SIGN UP ===");
                System.out.print("Name : ");
                String name = input.nextLine();
                String domain;
                if (name.equals("Admin")) {
                    domain = "@admin.com";
                } else {
                    domain = "@google.com";
                }
                email = name.toLowerCase().replaceAll("\\s", "") + domain;
                System.out.println("Email : " + email);
                System.out.print("Password : ");
                password = input.nextLine();

                signUp(name, email, password);
                break;
            case 0:
                System.out.println("Exiting Program...");
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                break;
        }

        input.close();
    }

    private static void login(String email, String password) {
        if (email.endsWith("@admin.com")) {
            Admin admin = new Admin("Admin", email);
            System.out.println("Selamat datang, " + admin.getName() + "!");
            menuAdmin(admin);
        } else if (email.endsWith("@google.com")) {
            Candidate candidate = new Candidate("Kandidat", email);
            System.out.println("Selamat datang, " + candidate.getName() + "!");
            menuCandidate(candidate);
        } else {
            System.out.println("Email tidak terdaftar.");
        }
    }

    private static void signUp(String name, String email, String password) {
        Candidate newCandidate = new Candidate(name, email);
        candidates.add(newCandidate);
        System.out.println("Pendaftaran berhasil. Selamat datang, " + name + "!");
        menuCandidate(newCandidate);
    }

    private static void menuAdmin(Admin admin) {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== WELCOME ===");
            System.out.println("1. Submissions");
            System.out.println("2. Send Email");
            System.out.println("0. Keluar");
            System.out.print("Pilihan : ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n=== Submissions ===");
                    admin.displaySubmissions();
                    break;
                case 2:
                    System.out.println("\n=== Send Email ===");
                    System.out.print("To : ");
                    String recipient = input.nextLine();
                    System.out.print("Add Details (Lolos/Tidak Lolos) : ");
                    String status = input.nextLine();
                    boolean pass = status.equalsIgnoreCase("Lolos");
                    admin.sendEmail(recipient, pass);
                    break;
                case 0:
                    System.out.println("Exiting to Main Menu...");
                    main(new String[0]);
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        } while (choice != 0);

        input.close();
    }

    private static void menuCandidate(Candidate candidate) {
        Scanner input = new Scanner(System.in);
        int choice;

        ArrayList<Job> jobs = createJobs();
        do {
            System.out.println("\n=== WELCOME ===");
            System.out.println("1. Search Job");
            System.out.println("2. Apply Now");
            System.out.println("3. Submission");
            System.out.println("0. Keluar");
            System.out.print("Pilihan : ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n=== Jobs ===");
                    for (Job job : jobs) {
                        System.out.println(job);
                    }
                    break;
                case 2:
                    System.out.println("\n=== Apply Job ===");
                    System.out.print("Name : ");
                    String applicantName = input.nextLine();
                    System.out.print("Education : ");
                    String education = input.nextLine();
                    System.out.print("ID Position you want to Apply (1-3) : ");
                    int jobID = input.nextInt();
                    input.nextLine();
                    applyJob(candidate, applicantName, education, jobID);
                    break;
                case 3:
                    candidate.displaySubmission();
                    break;
                case 0:
                    System.out.println("Exiting to Main Menu...");
                    main(new String[0]);
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        } while (choice != 0);

        input.close();
    }

    private static void applyJob(Candidate candidate, String name, String education, int jobID) {
        ArrayList<Job> jobs = createJobs();
        if (jobID >= 1 && jobID <= jobs.size()) {
            Job selectedJob = jobs.get(jobID - 1);
            candidate.applyJob(selectedJob, name, education);
            System.out.println("\nSubmission status : Success!");
            System.out.println("Thank you for applying.");
            Admin admin = getAdmin();
            if (admin != null) {
                String submission = "Name: " + name + "\nEducation: " + education + "\n" + selectedJob;
                admin.addSubmission(submission);
            }
        } else {
            System.out.println("\nID pekerjaan tidak valid.");
        }
    }

    private static Admin getAdmin() {
        for (Candidate candidate : candidates) {
            if (candidate.getEmail().endsWith("@admin.com")) {
                return new Admin(candidate.getName(), candidate.getEmail());
            }
        }
        return null;
    }

    private static ArrayList<Job> createJobs() {
        ArrayList<Job> jobs = new ArrayList<>();
        jobs.add(new Job(1, "Manager E-commerce", "Full Time", "Sales",
                "to 2 years of experience in Ecommerce Organization", "Jakarta, Indonesia"));
        jobs.add(new Job(2, "Tax Manager", "Full Time", "Finance", "Minimum of bachelor's degree in Accounting.",
                "Jakarta, Indonesia"));
        jobs.add(new Job(3, "Business Intelligence Analyst", "Part Time", "Marketing & Advertising",
                "Minimum of bachelor's degree in IT, Math or Business", "Jakarta, Indonesia"));
        return jobs;
    }
}
