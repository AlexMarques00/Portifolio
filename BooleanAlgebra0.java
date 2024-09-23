//3 1 1 1 and(or(A , B) , not(and(B , C)))
import java.util.Scanner;

public class BooleanAlgebra0 {
    public static int valores[] = new int[4]; 
	public static String input;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		boolean resp;
		int n = sc.nextInt();
		while(n != 0){
			for(int i = 0; i < n; i++){
				valores[i] = sc.nextInt();
			}
			input = sc.nextLine().trim();
			String bufferA[] = input.split("A");
			input = bufferA[0];
			for(int i = 1; i < bufferA.length; i++){
				input += valores[0] + bufferA[i];
			}
			String bufferB[] = input.split("B");
			input = bufferB[0];
			for(int i = 1; i < bufferB.length; i++){
				input += valores[1] + bufferB[i];
			}
			String bufferC[] = input.split("C");
			input = bufferC[0];
			for(int i = 1; i < bufferC.length; i++){
				input += valores[2] + bufferC[i];
			}
			String bufferD[] = input.split("D");
			input = bufferD[0];
			for(int i = 1; i < bufferD.length; i++){
				input += valores[3] + bufferD[i];
			}
			resp = algebra();
			System.out.println((resp)?(1):(0));
			n = sc.nextInt();
		}
		sc.close();
    }
	public static boolean algebra(){
		int firstClosed = 0;
		for(; firstClosed < input.length(); firstClosed++){
			if(input.charAt(firstClosed) == ')'){
				break;
			}
		}
		String bufferString = "";
		for(int i = 0; i < firstClosed; i++){
			bufferString += input.charAt(i);
		}
		String varsBuffer = "";
		int firstOpened;
		for(firstOpened = firstClosed-1; bufferString.charAt(firstOpened) != '('; firstOpened--){
			varsBuffer = bufferString.charAt(firstOpened) + varsBuffer;
		}
		String bufferArray[] = varsBuffer.split(" , ");
		int a = Integer.parseInt(bufferArray[0]);
		int c = 2;
		if(bufferArray.length == 1){
			if(a == 0){
				c = 1;
			} else {
				c = 0;
			}
		} else {
			int b = Integer.parseInt(bufferArray[1]);
			String operator = "";
			for(int i = firstOpened-1; i >= firstOpened-2; i--){
				operator = bufferString.charAt(i) + operator;
			}
			if(operator.equals("or")){
				c = ((a == 1) || (b == 1))?(1):(0);
				try{
					c = ((c == 1) || (Integer.parseInt(bufferArray[2]) == 1))?(1):(0);
				} catch(Exception e){
				}
			} else if(operator.equals("nd")){
				c = ((a == 1) && (b == 1))?(1):(0);
				try{
					c = ((c == 1) && (Integer.parseInt(bufferArray[2]) == 1))?(1):(0);
				} catch(Exception e){
				}
			}
		}
		String tmp = input;
		for(; tmp.charAt(firstOpened-1) != '(' && tmp.charAt(firstOpened-1) != ' ';firstOpened--);
		firstOpened--;
		input = "";
		for(int i = 0; i < firstOpened+1; i++){
			input += tmp.charAt(i);
		}
		input += c;
		for(int i = firstClosed+1; i < tmp.length();i++){
			input += tmp.charAt(i);
		}
		if(!isDone()){
			return algebra();
		} else {
			return lastAlgebra();
		}
	}
	public static boolean isDone(){
		int n = 0;
		for(int i = 0; i < input.length(); i++){
			if(input.charAt(i) == '('){
				n++;
			}
		}
		return (n == 1);
	}
	public static boolean lastAlgebra(){
		char type = input.charAt(0);
		char a, b;
		boolean resp;
		if(type == 'n'){ //not
			a = input.charAt(4);
			resp = !(a == '1');
		} else if(type == 'a'){ //and
			a = input.charAt(4);
			b = input.charAt(8);
			resp = ((a == '1') && (b == '1'));
			try{
				resp = resp && (input.charAt(12) == '1');
			}catch(Exception e){
			}
		} else { //or
			a = input.charAt(3);
			b = input.charAt(7);
			resp = ((a == '1') || (b == '1'));
			try{
				resp = resp || (input.charAt(11) == '1');
			}catch(Exception e){
			}
		}
		return resp;
	}
}
