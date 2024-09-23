import java.util.Random;
import java.util.Scanner;

public class Alteration {
    private static final Random gerador = new Random();
    public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
        gerador.setSeed(4);
        String inputString = sc.nextLine();
        char input[] = inputString.toCharArray();
        while(!(inputString.equals("FIM"))){
            char a = (char)('a' + Math.abs(gerador.nextInt() % 26));
            char b = (char)('a' + Math.abs(gerador.nextInt() % 26));
            for(int i = 0; i < input.length; i++){
                if(input[i] == a){
                    System.out.print(b);
                } else {
                    System.out.print(input[i]);
                }
            }
            System.out.print("\n");
            inputString = sc.nextLine();
            input = inputString.toCharArray();
        }
    }
}
