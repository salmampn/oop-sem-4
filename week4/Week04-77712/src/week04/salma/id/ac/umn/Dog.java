package week04.salma.id.ac.umn;

public class Dog {
    // Attributes
    String name, breed, color;
    int age;

    // Constructor
    public Dog(String name, String breed, String color, int age) {
        this.name = name;
        this.breed = breed;
        this.color = color;
        this.age = age;
    }

    // Methods to return attribute
    public String getName() {
        return name;
    }

    public String getbreed() {
        return breed;
    }

    public String getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }

    public void bio() {
        System.out.println("Hi, my name is " + this.getName() + ". I'm a " + this.getbreed() + " and I'm "
                + this.getAge() + " years old. My fur is " + this.getColor() + ".");
    }

    public static void main(String[] args) {
        // Create an object dog
        Dog tuffy = new Dog("Tuffy", "Papillon", "white", 5);
        tuffy.bio();

        Dog dogs[] = {
                new Dog("Bruno", "Golden", "cream", 3),
                new Dog("Timmy", "Pemrania", "orange", 4),
                new Dog("Rex", "Bulldog", "black", 6)
        };

        for (Dog dog : dogs) {
            dog.bio();
        }
    }
}
