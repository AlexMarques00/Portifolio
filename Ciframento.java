/*
O Imperador Júlio César foi um dos principais nomes do Império Romano. Entre suas contribuições, 
temos um algoritmo de criptografia chamado Ciframento de César. Segundo os historiadores, César 
utilizava esse algoritmo para criptografar as mensagens que enviava aos seus generais durante as 
batalhas. A ideia básica é um simples deslocamento de caracteres.

Assim, por exemplo, se a chave utilizada para criptografar as mensagens for 3, todas as ocorrências 
do caractere a são substituídas pelo caractere d, as do b por e, e assim sucessivamente.

Crie um método ITERATIVO que recebe uma string como parâmetro e retorna outra contendo a entrada de 
forma cifrada. Neste exercício, suponha a chave de ciframento três. Na saída padrão, para cada linha 
de entrada, escreva uma linha com a mensagem criptografada.
*/

import java.util.Scanner;

class Ciframento{
    public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char inputArray[] = input.toCharArray();
        String letters = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
        char lettersArray[] = letters.toCharArray();
        while(!(input.equals("FIM"))){
            for(int i = 0; i < inputArray.length; i++){
                for(int j = 0; j < lettersArray.length; j++){
                    if(inputArray[i] == lettersArray[j]){
                        inputArray[i] = lettersArray[j+3];
                        break;
                    }
                }
            }
            for(int i = 0; i < inputArray.length; i++){
                System.out.print(inputArray[i]);
            }
            System.out.print("\n");
            input = sc.nextLine();
            inputArray = input.toCharArray();
        }
    }
}