import aa.MyIO;

public class Aulao {
    public static void main(String args[]){
        //resto das linhas - olhar 1 por 1 e responder
        //cada nome -> checar se eh consoante 3x seguidas
        //{nome} eh facil ? {nome} nao eh facil
        //input.charAt(0);

        String vowel = "aeiou";
        int isCon = 0, isNotVow = 0;
        int num = Integer.parseInt(MyIO.readLine());
        for(int i = 0; i < num;i++){ //check each word
            String input = MyIO.readLine();
            int length = input.length();
            for(int j = 0; j < length && isCon < 3;j++){ //check each characters
                for(int k = 0; k < 5; k++){ //go through vowels
                    if(input.toLowerCase().charAt(j) != vowel.charAt(k)){
                        isNotVow ++;
                    }
                }
                if(isNotVow == 5){ //check if(all vowel)
                    isCon++;
                } else {
                    isCon = 0;
                }
                isNotVow = 0;
            }
            if(isCon == 3){
                MyIO.print(input + " nao eh facil\n");
            } else {
                MyIO.print(input + " eh facil\n");
            }
            isCon = 0;
        }
    }
}

