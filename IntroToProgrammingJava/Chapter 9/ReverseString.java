import java.lang.StringBuilder;

public class ReverseString{
    public static String reverse(String str){
        char[] reverseThisString = str.toCharArray();
        char[] rev = new char[str.length()];
        int end = str.length();
        int i = 0;
        int j = end-1;
        while(i < end && j >=0){
            rev[i] = reverseThisString[j];
            i += 1;
            j -= 1;
        }
       
        String reversed = String.valueOf(rev);
        return reversed; 
    }
}