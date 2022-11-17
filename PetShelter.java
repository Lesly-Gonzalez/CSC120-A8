/*
@File       : PetShelter.java
@Time       : 2022/11/16 4:00 PM EST
@Authors     : JCrouser edited by Lily G., Juniper H., Lesly H., and Priscilla T.
@Desc       : A Java file that implements the contract file provided by Professor JCrouser. We chose to create a Petshelter and used different methods to interact with the pets.
*/

import java.util.Hashtable; //imports Hashtable so that we can store a list of pets (key: name, value: type of animal) in the pet shelter


public class PetShelter implements Contract {
    private Hashtable<String, Boolean> petsAvailable; // Hashtable to store pets in the shelter
    private String name;
    private int age;
    private String animalType;
    private String breed;
    protected String health;
    protected int timeInShelter;


    /** Class constructor 
     * @param pet's name, age, type of animal, breed, health and time it has been in the shelter.
     */
    public PetShelter(String name, int age, String animalType, String breed, String health, int timeInShelter) {
        this.name = name; // listing the attributes for our method
        this.age = age;
        this.animalType = animalType;
        this.breed = breed;
        this.health = health;
        this.timeInShelter = timeInShelter;

        this.petsAvailable = new Hashtable<String, Boolean>(); // initializing hashtable with attributes

        System.out.println("Welcome to our Pet Shelter!");
        this.petsAvailable.put(this.name, true);
    }

    /** Get the name of the pet
     * @return pet's name
     */
    public String getName() { 
        return this.name;
    }

    /** Get the age of the pet
     * @return pet's age
     */
    public int getAge() { 
        return this.age;
    }

    /** Get the type of animal
     * @return pet's species
     */
    public String animalType() { 
        return this.animalType;
    }

    /** Get the breed of the pet
     * @return pet's breed
     */
    public String breed() { 
        return this.breed;
    }

    /* METHODS */

    /** Grab a pet to adopt
     * @param some pet
     */
    public void grab(String item) { 
        this.name = item;

        if (this.petsAvailable.get(item) == true) {
            System.out.println(name + " is a " + animalType + " available for adoption!");
        } else {
            System.out.println(name + "is unavaible for adoption");
        }
    }

    /** Drop a pet into a new home
     * @param some pet
     * @return string with adoption confirmation message
     */
    public String drop(String item) { 
        this.name = item;
        String adopted = (name + " has been adopted into a loving home!");
        undo();
        return adopted;

    }

    /** Examine the health of a pet
     * @param health status of a pet
     */
    public void examine(String item) { 
        this.health = item;
        System.out.println(name + " is in " + health + " condition");

    }

    /** Give the pet items to use
     * @param toy or accesory for the pet
     */
    public void use(String item) {
        System.out.println(name + " is using the " + item + ". So cute!");
    }

    /** Walk the pet
     * @param direction 
     * @return boolean
     */
    public boolean walk(String direction) { 
        if (health != "Tired") {
            System.out.println(name + " is walking to " + direction);
            return true;
        } else {
            System.out.println(name + " is too tired to walk to " + direction);
            return false;
        }

    }

    /** Let the pet fly (if it can)
     * @param direction: horizontally(x) and altitude: vertically(y)
     * @return boolean whether the pet can fly or not
     */
    public boolean fly(int x, int y) { 

        String animal = this.animalType.toLowerCase();

        if (animal.equals("bird") && y > 0 && x > 0) {
            System.out.println(name + " is flying " + x + " meters to the front of the shelter");
            return true;
        } else if (animal.equals("bird") && y > 0 && x < 0) {
            System.out.println(name + " is flying " + x + " meters to the back of the shelter");
            return true;
        } else if (animal.equals("bird") && y < 0) {
            System.out.println(name + " cannot got below floor level.");
            return false;
        } else {
            System.out.println(name + " isn't a bird! " + animalType + "s can't fly!");
            return false;
        }
    }

    /** Counts the number of days the pet has been in the shelter minus the day they arrived
     * @return time in the shelter -1
     */
    public Number shrink() { 
        this.timeInShelter -= 1;
        System.out.println(name + " has been in their happy new home for " + timeInShelter + " days!");
        return timeInShelter;
    }

    /** Counts the number of days the pet has been in the shelter
     * @return time in the shelter +1
     */
    public Number grow() { 
        this.timeInShelter += 1;
        System.out.println(name + " has been in the shelter for " + timeInShelter + " days.");
        return timeInShelter;

    }

    /** Let's the pet play, updates the health status, and puts the pet to rest.
     * @param some toy 
     */
    public void play(String item) { 
        System.out.println(name + " is playing with " + item + " right now!");
        health = "Tired";
        rest();
    }

    /** Puts the pet to rest and updates the health status
     */
    public void rest() { 
        examine("resting");

    }

    /** Removes a pet from the shelter
     */
    public void undo() { 
        petsAvailable.put(name, false);

    }

    /**  @return string of name, age, breed, and specie of pet at shelter
     */
    public String toString() { 
        return this.name + " is a " + this.age + " year old " + this.breed + " " + this.animalType;
    }


    public static void main(String[] args) { // main for testing
        PetShelter mPetShelter = new pet("Tangbao", 1, "cat", "Domestic Short Hair", "Good", 10);
        System.out.println(mPetShelter);
        mPetShelter.grab("Tangbao");
        mPetShelter.use("cat tree");
        mPetShelter.grow();
        mPetShelter.shrink();
        mPetShelter.walk("the couch");
        mPetShelter.rest();
        mPetShelter.examine("tired");
        mPetShelter.drop("Tangbao");
        mPetShelter.fly(3, 1);

    }

}