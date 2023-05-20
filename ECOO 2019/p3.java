import java.util.*;
import java.io.*;


class p3 {
    public static void main(String[] args){
        try{
            BufferedReader input = new BufferedReader(new FileReader(new File("DATA32.txt")));
            String line = "";
            
            while((line = input.readLine()) != null){
                if (line.isEmpty()) break;
                String[] numbers = line.split(" ");
                int j = Integer.parseInt(numbers[0]);
                int w = Integer.parseInt(numbers[1]);
                int h = Integer.parseInt(numbers[2]);
                char[][] matrix = new char[h][w];
                String[] columns = new String[w];

                int start = 0, end = 0;
                int boundary = 0;

                for (int i = 0; i < h; i++){ // row
                    line = input.readLine();
                    for (int x = 0; x < w; x++){ // col
                        matrix[h-i-1][x] = line.charAt(x);
                    }
                }

                if (j < h) boundary = j+1;
                else boundary = h-1;
                int ground = 0;


                for (int i = 0; i < w; i++){
                    String column = "";
                    for (int x = 1; x <= boundary; x++){
                        column += matrix[x][i];
                        
                    }
                    columns[i] = column;
                    if (column.charAt(ground) == 'L') start = i;
                    if (column.charAt(ground) == 'G') end = i;
                }

                boolean jump = false;
                String substring = "";
                for (int i = start+1; i <= end; i++){
                    
                    if (columns[i].charAt(ground) == '.' || columns[i].charAt(ground) == 'G') {
                        if (jump == true){
                            
                            if (substring.contains("@")){
                                System.out.println(i+1);
                                break;
                            }
                        }
                        if (columns[i].charAt(ground) == 'G'){
                            System.out.println("CLEAR");
                            break;
                        }
                        jump = false;
                    }
                    else {
                        if (jump == false){
                            if (columns[i].contains(".") == false) {
                                System.out.println(i+1);
                                break;
                            }
                            jump = true;
                            boolean flag = false;
                            for (int x = 1; x < boundary; x++){
                                if (columns[i].charAt(x) == '.'){
                                    // Check for jumping space in the previous column
                                    if (columns[i-1].substring(ground, x+1).contains("@")){
                                        System.out.println(i);
                                        flag = true;
                                        break;
                                    }
                                    substring = columns[i+1].substring(ground, x+1);
                                    break;
                                }
                            }
                            if (flag == true) break;
                        }
                        else {
                            System.out.println(i+1);
                            break;
                        }
                    }
                }
                

            } input.close();
        } catch (IOException e) {  }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static String next () throws IOException {
        while (st == null || ! st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
    static char readCharacter () throws IOException {
        return next().charAt(0);
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}


