/*
Você está digitando um texto longo com um teclado quebrado. Bem, não tão quebrado.
O único problema com o teclado é que às vezes a tecla "home" ou a tecla "end" é automaticamente pressionada
(internamente). Você não está ciente deste problema, já que você está focado no texto e nem sequer ligou
o monitor! Depois que você terminar de digitar, você pode ver um texto na tela (se você ligar o monitor).
Em chinês, podemos chamar este texto de Beiju. Sua tarefa é encontrar o texto Beiju.

Entrada
Há diversos casos de teste. Cada teste é uma única linha que contém pelo menos uma e, no máximo,
100.000 letras, underscores e dois caracteres especiais '[' e ']'. '[' Significa que a tecla "Home" é
pressionada internamente, e ']' significa que a tecla "End" é pressionada internamente. A entrada é terminada
por fim de arquivo (EOF). O tamanho do arquivo de entrada não excede 5MB.

Saída
Para cada caso, imprimir o texto Beiju na tela.
*/

#include <stdio.h>
#include <string.h>

int main()
{
    char input[100000], begin[100000], end[100000], output[100000];
    while (fgets(input, sizeof(input), stdin) != NULL){
        int beginIndex = 0, endIndex = 0, homeEnd = 0; //nothing = 0 ||home = 1 || end = 2
        for(int i = 0; i < strlen(input); i++){
            if(input[i] == '['){
                homeEnd = 1;
            } else if(input[i] == ']'){
                homeEnd = 2;
            } else {
                if(homeEnd == 1 && input[i] != ']'){
                    begin[beginIndex] = input[i];
                    beginIndex++;
                    //printf("begin: %s\n", begin); //asads
                } else if(homeEnd == 2 || homeEnd == 0){
                    end[endIndex] = input[i];
                    endIndex++;
                    //printf("end: %s\n", end); //asads
                    if(homeEnd == 2){
                        strcat(begin, output);
                        //printf("begincatoutput: %s\n", begin); //asads
                        strcat(begin, end);
                        //printf("begincatoutputcatend: %s\n", begin); //asads
                        strcpy(output, begin);
                        //printf("output: %s\n", output); //asads
                        for(int j = strlen(begin); j >= 0; j--){
                            begin[j] = '\0';
                        }
                        for(int j = strlen(end); j >= 0; j--){
                            end[j] = '\0';
                        }
                        beginIndex = 0;
                        endIndex = 0;
                        homeEnd = 0;
                    }
                }
            }
        }
        strcat(begin, output);
        //printf("begincatoutput: %s\n", begin); //asads
        strcat(begin, end);
        //printf("begincatoutputcatend: %s\n", begin); //asads
        for(int j = strlen(output); j >= 0; j--){
            output[j] = '\0';
        }
        strcpy(output, begin);
        //printf("finaloutput?:\n"); //asads
        //aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
        for(int j = strlen(begin); j >= 0; j--){
            begin[j] = '\0';
        }
        for(int j = strlen(end); j >= 0; j--){
            end[j] = '\0';
        }
        beginIndex = 0;
        endIndex = 0;
        homeEnd = 0;
    }
    printf("%s", output);
}

/*
This_is_a_[Beiju]_text
v
BeijuThis_is_a__text

[[]][]Happy_Birthday_Tsinghua_University
v
Happy_Birthday_Tsinghua_University
*/