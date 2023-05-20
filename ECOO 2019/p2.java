import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class p2 {
    public static void passed(String[] args){
        try {
            BufferedReader bf = new BufferedReader(new FileReader("DATA21.txt"));
            String line = "";
            while ((line = bf.readLine())!= null){
                String[] inputs = line.split(" ");
                long r = Integer.parseInt(inputs[0]);
                long t = Integer.parseInt(inputs[1]);
                String axiom = inputs[2];
                HashMap<Character, String> replacements = new HashMap<>();
                long[] frequency_list = new long[26];
                for(int i = 0; i < r; i++){
                    line = bf.readLine();
                    inputs = line.split(" ");
                    char key = inputs[0].charAt(0);
                    String value = inputs[1];
                    replacements.put(key, value);
                }

                // Record the initial frequency
                for (int i = 0; i < axiom.length(); i++){
                    char cur = axiom.charAt(i);
                    frequency_list[cur-65]++;
                }
                char first = axiom.charAt(0);
                char last = axiom.charAt(axiom.length()-1);
                long length = 0;

                for(int i = 0; i < t; i++){ 
                    length = 0;
                    long[] new_fre = new long[26];
                    first = replacements.get(first).charAt(0);
                    String lstreplace = replacements.get(last);
                    last = lstreplace.charAt(lstreplace.length()-1);
                    
                    for (int j = 0; j < 26; j++) {
                        // # frequency indexes
                        if (frequency_list[j] != 0){
                            char cur = (char)(j+65);
                            long multi = frequency_list[j];
                            String toreplace = replacements.get(cur);
                            for (int x = 0; x < toreplace.length(); x++) {
                                // # update frequency
                                char tmp = toreplace.charAt(x);
                                new_fre[tmp-65] += multi * 1;
                                }
                        }
                    } frequency_list = new_fre;
                }
                for(int im = 0; im < 26; im++) length += frequency_list[im];
                System.out.print(first);
                System.out.print(last);
                System.out.print(" "+length+"\n");

            }
        bf.close();
        } catch (IOException e){}
    }   
}