/*Desde que foi lançado oficialmente o Pomekon no Brasil, Dabriel 
está tentando realizar seu maior sonho: Ser um Mestre Pomekon. 
Sua meta é conquistar os 151 Pomekons disponíveis. Ele já conseguiu 
capturar muitos monstrinhos, porém em sua cidade aparecem muitos 
Pomekons repetidos, fazendo com que ele capture diversas vezes o 
mesmo Pomekon.

Vendo que sua mochila está bem cheia, Dabriel pediu para que você 
fizesse um programa de computador que informasse a ele quantos 
Pomekons faltam para completar a coleção.

Entrada
A primeira linha do caso de teste consiste de um inteiro 
N (1 ≤ N ≤ 10³), representando a quantidade de Pomekons que Dabriel 
já capturou. As próximas N linhas consistem de uma string 
S (1 ≤ |S| ≤ 10³), representando o nome de cada Pomekons. 
O nome de cada Pomekons consiste apenas de letras maiúsculas e 
minúsculas.

Saída
Você deverá imprimir: "Falta(m) X pomekon(s).", onde X representa 
a quantidade Pomekons não capturados.
*/

public class pokemon {
    public static int obtained = 0, remaining = 151;
    public static String[] obtainedArray = new String[151];
    public static void addPokemon(){
        int has = 0;
        String newPokemon = MyIO.readLine();
        for(int i = 0; i <= obtained; i++){
            if(newPokemon.equals(obtainedArray[i])){
                has = 1;
                break;
            }
        }
        if(has == 0){
            obtainedArray[obtained] = newPokemon;
            obtained++;
        } else {
            has = 0;
        }
    }
    public static void main(String[] args){
        int n = Integer.parseInt(MyIO.readLine());
        for(int i = 1; i <= n; i++){
            addPokemon();
        }
        remaining -= obtained;
        MyIO.print("Falta(m) " + remaining + " pomekon(s).\n");
    }
}
