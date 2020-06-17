//buggered, but figured it couldnt hurt to try to use a class in java before we get there
//import IntroToProgrammingJava.AClass;//Package does not exist. Must figure out how to make a Java package to have classes imported
public class ClassPractice{
    public void main(String args[]){
        AClass a = new AClass();
        
        int returned = a.SetNumbers(5,7);
        System.out.println(a.Message + returned);
    }
    
    
    //illegal static declaration in inner class ClassPractice.AClass. I think this needs to be referenced from outside the main class in its own "file"
 

}
