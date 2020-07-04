public class DriverExam{
   private final String[] answerKey = {"B","D","A","A","C","A","B","A","C","D","B","C","D","A","D","C","C","B","D","A"};
   private String[] studentAnswers = new String[20];
   
   public DriverExam(){
       for(String value : studentAnswers){
           value = "";
       }
   }
  //Accessors
   public String[] getAnswerKey(){
       return answerKey;
   }
   public String[] getStudentAnswers(){
       return studentAnswers;
   }
   
  //Set Student Answers
   public void setStudentAnswers(){
       String placeholder = "";
       for(int index = 0; index < studentAnswers.length; index++){
        
           while(!placeholder.matches("[AaBbCcDd]")){
               placeholder = javax.swing.JOptionPane.showInputDialog("Enter question answer");
           }
           studentAnswers[index] = placeholder.toUpperCase();
           placeholder = ""; 
       } 
   }
  
  //Check Student Answers
   public String[] checkStudentAnswers(String[] answers){
       String firstString = "";
       String secondString = "";
       String[] gradedAnswers = new String[20];
       for(int index = 0; index < 20; index++){
           firstString = answers[index];
           secondString = answerKey[index];
           
           if(firstString.equals(secondString)){
               gradedAnswers[index] = "Right";
           }else{
               gradedAnswers[index] = "Wrong";
           }
        }
        return gradedAnswers;
   }
   
  //Check if Student Passed
   public boolean passed(int correct){
       boolean didPass = false;
       if(correct >= 15){
           didPass = true;
       }
       return didPass;
   }
   
  //Number of Correct Answers
   public int totalCorrect(String[] gradedAnswers){
       int correct = 0;
       
       for(String value : gradedAnswers){
           if(value == "Right"){
               correct++;
           }
       }
       
       return correct;
   }
   
  //Number of Incorrect Answers
   public int totalIncorrect(String[] gradedAnswers){
       int incorrect = 0;
       
       for(String value : gradedAnswers){
           if(value == "Wrong"){
               incorrect++;
           }
       }
       
       return incorrect;
   }
  
  //Return the question numbers that the student missed
   public String questionsMissed(String[] gradedAnswers){
       
       java.util.ArrayList<Integer> missedQuestions = new java.util.ArrayList<Integer>();
       
       for(int index = 0; index < gradedAnswers.length; index++){
           if(gradedAnswers[index] == "Wrong"){
               missedQuestions.add(index + 1);
           }
       }
       
       String missed = missedQuestions.toString();
       
       return missed;
   }
}