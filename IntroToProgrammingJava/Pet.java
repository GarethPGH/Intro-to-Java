public class Pet{
    private String name;
    private String animal;
    private int age;
    
    public void setName(String petName){
        name = petName;
    }
    
    public void setAnimal(String species){
        animal = species;
    }
    
    public void setAge(int petAge){
        age = petAge;
    }
    
    public String getName(){
        return name;
    }
    
    public String getAnimal(){
        return animal;
    }
    
    public int getAge(){
        return age;
    }
}