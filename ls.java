/*
Na saída padrão, para cada linha de entrada, escreva outra de saída da seguinte forma X1 X2 X3 X4 
onde cada Xi é um booleano indicando se a é entrada é: 
composta somente por vogais (X1); 
composta somente somente por consoantes (X2); 
um número inteiro (X3); 
um número real (X4). 

Se Xi for verdadeiro, seu valor será SIM, caso contrário, NÃO.
*/
import java.util.Scanner;

class ls{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		String input = "";
		input = sc.nextLine();
		while(!(input.equals("FIM"))){
			System.out.print(MethodOne(input) == 1 ? "SIM " : "NAO ");
			System.out.print(MethodTwo(input) == 1 ? "SIM " : "NAO ");
			System.out.print(MethodThree(input) == 1 ? "SIM " : "NAO ");
			System.out.print(MethodFour(input) == 1 ? "SIM\n" : "NAO\n");
			input = sc.nextLine();
		}
	}
	public static int MethodOne(String input){
		String vowel = "aeiou";
		int length = 0;
		int method1 = 0;
		for(int i = 0; i < input.length(); i++){
			for(int j = 0; j < vowel.length(); j++){
				if(input.charAt(i) == vowel.charAt(j)){
					length++;
				}
			}
		}
		if(length == input.length()){
			method1 = 1;
		}
		return method1;
	}
	public static int MethodTwo(String input){
		String consonant = "bcdfghjklmnpqrstvwxyz";
		int length = 0;
		int method1 = 0;
		for(int i = 0; i < input.length(); i++){
			for(int j = 0; j < consonant.length(); j++){
				if(input.charAt(i) == consonant.charAt(j)){
					length++;
				}
			}
		}
		if(length == input.length()){
			method1 = 1;
		}
		return method1;
	}
	public static int MethodThree(String input){
		int method3;
		try {
			Integer.parseInt(input);
			method3 = 1;
		} catch (Exception e) {
			method3 = 0;
		}
		return method3;
	}
	public static int MethodFour(String input){
		int method4;
		try {
			Float.parseFloat(input);
			method4 = 1;
		} catch (Exception e) {
			method4 = 0;
		}
		return method4;
	}
}