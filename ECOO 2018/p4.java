import java.io.*;

public class p4 {
    public static void main(String[] args) throws IOException {
        long[] side_length = new long[100];
        square[] squares = new square[100];
        side_length[0]=1;
        side_length[1]=1;
        side_length[2]=2;
        side_length[3]=3;
        squares[0] = new square(1, 0, 0, -1);
        squares[1] = new square(0, 0, -1, -1);
        squares[2] = new square(1, 2, -1, 0);
        squares[3] = new square(4, 2, 1, -1);
        for (int i = 4; i < 90; i++) {

            side_length[i] = side_length[i-1]+side_length[i-2];
            // Down right up left
            // Down
            long urx = squares[i-1].urx;
            long ury = squares[i-1].dly;
            long dlx = squares[i-2].dlx;
            long dly = ury-side_length[i];
            squares[i] = new square(urx, ury, dlx, dly);

            // Right
            i++;
            side_length[i] = side_length[i-1]+side_length[i-2];
            urx = squares[i-1].ury;
            ury = squares[i-2].ury;
            dlx = urx-side_length[i];
            dly = ury-side_length[i];
            squares[i] = new square(urx, ury, dlx, dly);

            // Up
            i++;
            side_length[i] = side_length[i-1]+side_length[i-2];
            urx = squares[i-3].urx;
            dlx = squares[i-1].dlx;
            dly = squares[i-3].ury;
            ury = side_length[i]+ dly;
            squares[i] = new square(urx, ury, dlx, dly);

            // Left
            i++;
            side_length[i] = side_length[i-1]+side_length[i-2];
            urx = squares[i-1].urx + side_length[i];
            ury = squares[i-1].ury;
            dlx = urx - side_length[i];
            dly = ury - side_length[i];
            squares[i] = new square(urx, ury, dlx, dly);
        }
        BufferedReader br = new BufferedReader(new FileReader(new File("Ignore")));
        for (int test = 0; test < 10; test++){
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            for (int i = 0; i < squares.length; i++){
                // Check if within the range
                square s = squares[i];
                if (x <= s.urx && x >= s.dlx && y <= s.ury && y >= s.dly) {
                    System.out.println(i+1);
                    break;
                }
            }
        }
        br.close();
    }
    static class square{
        long urx;
        long ury;
        long dlx;
        long dly;
        square(long urx,long ury,long dlx,long dly ){
            this.urx = urx;
            this.ury = ury;
            this.dlx = dlx;
            this.dly = dly;
        }
    }
}
