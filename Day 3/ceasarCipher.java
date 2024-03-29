import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
       String alphabet, cryp="";    
        char letter;
        int pos, newPos;
            
        for(int x = 0; x<s.length(); x++) {
            letter=s.charAt(x);
            if(Character.isLowerCase(letter))
                alphabet = "abcdefghijklmnopqrstuvwxyz";
            else
                alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                
            if(alphabet.indexOf(letter)!=-1){
                pos = alphabet.indexOf(letter);
                newPos = (pos+k)%alphabet.length();    
                letter = alphabet.charAt(newPos);
            }
            
            cryp += letter;
        }
        
        return cryp;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
