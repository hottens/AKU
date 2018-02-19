import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    // Create a string of bits,
    // where the left-most char corresponds to floor
    // followed by mod from low to high level
    private static String bitString(int aku){
        if(aku < 2) return "" + aku;

        int floor = aku/2;
        int mod = aku%2;

        return "" + bitString(floor)+bitString(mod);
    }

    public static void main(String[] args) throws Exception {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(reader);
        String input = in.readLine();
        String [] temp = input.split(" ");

        int leftbound = Integer.parseInt(temp[1]);
        int rightbound = Integer.parseInt(temp[2]);

        char akuString [] = bitString(Integer.parseInt(temp[0])).toCharArray();

        int countOnes = 0;

        // Loop from left- to right bound
        // Calculate corresponding index of the bitString
        for(int i = leftbound-1; i <= rightbound-1; i++) {
            for(int j = 0; j<akuString.length; j++){
                double power = Math.pow(2,j);
                if((i-(power-1))%(2*power)==0) {
                    if (akuString[j] == '1')
                        countOnes++;
                    break;
                }
            }
        }
        System.out.print(countOnes);
    }
}