import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class p1 {
    public static void main(String[] args) throws IOException {

        try {
            BufferedReader bf = new BufferedReader(new FileReader(new File("C:/Users/Elyn/Downloads/ICS4U/ECOO 2019/DATA11.txt")));
            String line = "";
            while ((line = bf.readLine())!= null){
                String[] inputs = line.split(" ");
                int n = Integer.parseInt(inputs[0]); // initial # clean shirts
                int d = Integer.parseInt(inputs[2]);
                line = bf.readLine();
                inputs = line.split(" ");
                int[] frequency_list = new int[d+1];
                for (String day : inputs) {
                    int cur = Integer.parseInt(day);
                    frequency_list[cur]++;
                }
                int dirty = 0;
                int laundry = 0;
                for (int i = 1; i <= d; i++)
                {
                    if (n <= 0) {
                        laundry++;
                        n += dirty;
                        dirty = 0;
                    }
                    n = n-1 + frequency_list[i];     
                    dirty++;           
                }
                System.out.println(laundry);
                }
                bf.close();

        } catch (IOException e){}
    }
}