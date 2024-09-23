import java.util.Scanner;

class BalanceParenthesis{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        while(!input.equals("FIM")){
            int resp = 0;
            for(int i = 0; i < input.length(); i++){
                if(input.charAt(i) == '('){
                    resp++;
                } else if(input.charAt(i) == ')'){
                    resp--;
                }
                if(resp < 0){
                    break;
                }
            }
            if(resp == 0){
                System.out.println("correto");
            } else {
                System.out.println("incorreto");
            }
            input = sc.nextLine();
        }
        sc.close();
    }
}