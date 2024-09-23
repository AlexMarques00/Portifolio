/*
Crie um método iterativo que recebe uma string como parâmetro e retorna true se essa é um palíndromo.
Na saída padrão, para cada linha de entrada, escreva uma linha de saída com SIM/NAO indicando se a linha é um palíndromo.
Destaca-se que uma linha de entrada pode ter caracteres não letras
A entrada termina com a leitura de FIM
*/

import java.util.Scanner;

class Palindrome{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		while(!(input.equals("FIM"))){
			boolean palindrome = IsPalindrome(input);
			if(palindrome == true){
				System.out.println("SIM");
			} else {
				System.out.println("NAO");
			}
			input = sc.nextLine();
		}
	}
	public static boolean IsPalindrome(String text){
		boolean resp = true;
		for(int i = 0; i < (text.length()) / 2; i++){
			int j = text.length() - i - 1;
			if(!(text.charAt(j) == text.charAt(i))){
				resp = false;
				i = text.length();
			}
		}
		return resp;
	}
}