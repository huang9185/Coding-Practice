import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
public class p4 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(new File("DATA41.txt")));
        String line;

        while ((line = reader.readLine()) != null){
            PriorityQueue<PassengerEnter> q = new PriorityQueue<>();
            String[] info = line.split(" ");
            int stops = Integer.parseInt(info[0]);
            int passengers = Integer.parseInt(info[1]);

            for (int i = 0; i < passengers; i++)
            {
                info = reader.readLine().split(" ");
                PassengerEnter passenger = new PassengerEnter(Integer.parseInt(info[0]), Integer.parseInt(info[1]));
                q.add(passenger);
            }

            int count = 0;
            int minBusNum = 0;
            int minTime = Integer.MAX_VALUE;
            while(!q.isEmpty())
            {
                PriorityQueue<PassengerLeave> bus = new PriorityQueue<>();
                int time = count * 10;
                Boolean request = false;
                for (int i = 1; i <= stops; i++){
                    request = false;
                    while(!bus.isEmpty() && bus.peek().enter==i && bus.size() <40) {
                        PassengerLeave current = new PassengerLeave(q.peek().enter, q.poll().leave); 
                        bus.add(current);
                        request = true;
                    }
                    while(!bus.isEmpty() && bus.peek().leave==i){
                        bus.poll();
                    }
                    if(request==true){
                        time++;
                    }
                }
                count++;
                if(minTime > time){
                    minBusNum = count;
                    minTime = time;
                }
            }
            System.out.println("Bus #"+minBusNum);
        }
        reader.close();

    }
    static class PassengerLeave implements Comparable<PassengerLeave> {
        int enter;
        int leave;
        PassengerLeave(int a, int b){
            this.enter = a;
            this.leave = b;
        }
        public int compareTo(PassengerLeave p) {
            return Integer.compare(leave, p.leave);
        }
    }
    static class PassengerEnter implements Comparable<PassengerEnter> {
        int enter;
        int leave;
        PassengerEnter(int a, int b){
            this.enter = a;
            this.leave = b;
        }
        public int compareTo(PassengerEnter p) {
            return Integer.compare(enter, p.enter);
        }
    }

}