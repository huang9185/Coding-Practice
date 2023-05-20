import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class p2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(new File("DATA21.txt")));
        String line = "";
        for (int test = 0; test < 10; test++){
            line = br.readLine();
            int routes = Integer.parseInt(line.split(" ")[0]);

            // Keep track of smallest diameter and routes
            int small_d = 70010;
            ArrayList<Integer> small_routes = new ArrayList<>();

            for (int i = 1; i <= routes; i++){
                line = br.readLine();
                String[] details = line.split(" ");
                int roundabouts = Integer.parseInt(details[1]);
                int route_num = Integer.parseInt(details[0]);
                for (int j = 1; j <= roundabouts; j++){
                    int num = Integer.parseInt(details[j+1]);
                    if (num < small_d){
                        small_d = num;
                        small_routes = new ArrayList<>();
                        small_routes.add(route_num);
                    } else if (num == small_d) {
                        if (!small_routes.contains(route_num)) small_routes.add(route_num);
                    }
                }
            }
            System.out.print(small_d + " " + "{");
            for (int r = 0; r < small_routes.size(); r++){
                if (r == small_routes.size()-1) System.out.print(small_routes.get(r));
                else System.out.print(small_routes.get(r) + ",");
            }
            System.out.print("}\n");
        }

        br.close();
    }
}