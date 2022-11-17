public class pet extends PetShelter {

    /** Class constructor 
     * @param pet's name, age, type of animal, breed, health and time it has been in the shelter.
     */
    public pet(String name, int age, String animalType, String breed, String health, int timeInShelter) {
        super(name, age, animalType, breed, health, timeInShelter);

    }

    public static void main(String[] args) {
        pet Tangbao = new pet("Tangbao", 1, "Cat", "Domestic Short Hair", "Good", 1);
        System.out.println(Tangbao);
    }
 
}
