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
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
     double positiveCount=0, negativeCount=0, zerosCount=0;
     double arrSize = Double.valueOf(arr.size());
     
    for(int i : arr){
        if(i>0){
            positiveCount++;
        }else if(i<0){
            negativeCount++;
        }else{
            zerosCount++;
        }
    }
    
    System.out.println(String.format("%.6f", positiveCount / arrSize));
    System.out.println(String.format("%.6f", negativeCount / arrSize));
    System.out.println(String.format("%.6f", zerosCount / arrSize));
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
