
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(){
    srand(4);
    char inputString[1000];
    int a, b;
    scanf(" %[^\n]", inputString);
    while (strcmp(inputString, "FIM") != 0) {
        a = 'a' + abs(rand() % 26);
        b = 'a' + abs(rand() % 26);
        
        for (int i = 0; inputString[i] != '\0'; i++) {
            if (inputString[i] == a) {
                printf("%c", b);
            } else {
                printf("%c", inputString[i]);
            }
        }
        printf("\n");
        scanf(" %[^\n]", inputString);
    }
    return 0;
}