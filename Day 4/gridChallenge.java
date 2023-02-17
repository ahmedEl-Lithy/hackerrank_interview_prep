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
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) {
        List<String> sortedStrings = new ArrayList<>();
        grid.stream().forEach((item)->{
            char charArray[] = item.toCharArray();
            Arrays.sort(charArray);
            sortedStrings.add(new String(charArray));
        });
        
        boolean result = false;
        for(int i=0; i<sortedStrings.get(0).length(); i++) {
        result = false;
            for(int j=0; j<sortedStrings.size();j++) {
                if(sortedStrings.size() > j+1){
                    if(sortedStrings.get(j).charAt(i) 
                    < sortedStrings.get(j+1).charAt(i)) {
                        result = true;
                    } else{
                        result = false;
                        break;
                    }
                }
            }
        }
        
        return result == true ? "YES" : "NO";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                    .collect(toList());

                String result = Result.gridChallenge(grid);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
