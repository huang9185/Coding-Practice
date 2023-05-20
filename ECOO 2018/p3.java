import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class p3 {
    public static String[] data = new String[22];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("DATA31.txt")));
        String line = "";
        for (int test = 0; test < 10; test++){
            line = br.readLine();
            String[] vars = line.split(" ");
            int n = Integer.parseInt(vars[0]);
            int x = Integer.parseInt(vars[1]);
            int y = Integer.parseInt(vars[2]);
            int z = Integer.parseInt(vars[3]);

            // Read digital codes
            for (int i = 1; i <= n; i++){
                line = br.readLine();
                vars = line.split("");
                String output = "";
                for (int j = 0; j < vars.length; j++){
                    int tmp = Integer.parseInt(vars[j]);
                    if (tmp == 0) tmp = z;
                    else if (tmp % 2 == 0) tmp += x;
                    else if (tmp % 2 != 0) tmp = Math.max(0, tmp-y);
                    output += tmp;
                }
                data[i] = output;
            }

            ArrayList<Integer> fail = new ArrayList<>();
            while((line = br.readLine()).equals("A")){
                for (int count = 1; count <= n; count++) {
                    line = br.readLine();
                    if (!line.equals(data[count])) fail.add(count);
                }
            }

            if (fail.size() == 0) System.out.println("MATCH");
            else {
                System.out.print("FAIL: ");
                for (int i = 0; i < fail.size(); i++){
                    if (i == fail.size()-1) System.out.print(fail.get(i)+"\n");
                    else System.out.print(fail.get(i)+",");
                }
            }
        }
        br.close();
    }
}