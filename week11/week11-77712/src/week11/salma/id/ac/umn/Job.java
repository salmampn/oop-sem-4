package week11.salma.id.ac.umn;

class Job {
    private int id;
    private String title;
    private String type;
    private String category;
    private String qualification;
    private String location;

    public Job(int id, String title, String type, String category, String qualification, String location) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.category = category;
        this.qualification = qualification;
        this.location = location;
    }

    @Override
    public String toString() {
        return "ID : " + id +
                "\nJob Title : " + title +
                "\nJob Type : " + type +
                "\nJob Category : " + category +
                "\nQualification : " + qualification +
                "\nLocation : " + location +
                "\n---------------------------------------------------------------------------------";
    }
}