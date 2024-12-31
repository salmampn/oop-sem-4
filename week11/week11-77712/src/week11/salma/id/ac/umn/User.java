package week11.salma.id.ac.umn;

class User {
    protected String email;
    protected String name;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void displayMessage(String message) {
        System.out.println("Details : " + message);
    }
}