
import java.io.*;
import java.util.*;

public class david_p2 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
    BufferedReader br = new BufferedReader(new FileReader("DATA21.txt"));

    int datasets = 10;

    for(int i = 0; i < datasets; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        int R = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        ArrayList<String> rules = new ArrayList<>();

        //storing the rules
        for(int j = 0; j < R; j++) {
            if (st.hasMoreTokens()) {
                char C = st.nextToken().charAt(0);
                if (st.hasMoreTokens()) {
                    String S = st.nextToken();
                    rules.add(C + " " + S);
                }
            }
        }

        // Generate the state of the system
        String state = A;

        for(int g = 0; g < T; g++) {
            StringBuilder newState = new StringBuilder();
            for(int j = 0; j < state.length(); j++) {
                char c = state.charAt(j);
                boolean foundRule = false;
                for(String rule : rules) {
                    if(rule.startsWith(c + " ")) {
                        newState.append(rule.substring(2));
                        foundRule = true;
                        break;
                    }
                }
                if(!foundRule) {
                    newState.append(c);
                }
            }
            state = newState.toString();
        }

        String output = "" + state.charAt(0) + state.charAt(state.length() - 1) + state.length();
        pw.println(output);
    }

    br.close();
    pw.close();
}}