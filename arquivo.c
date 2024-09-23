#include <stdio.h>
#include <string.h>


int main(){
    FILE *arquivoWrite = fopen("arquivo.txt", "w");
    if(arquivoWrite == NULL){
        printf("ERRO - cant open file write");
        return 1;
    }
    int n;
    float input;
    scanf("%d", &n); 
    for(int i = 0; i < n; i++){
        scanf("%f", &input);
        fprintf(arquivoWrite, "%f\n", input);
    }
    fclose(arquivoWrite);
    double output;
    FILE *arquivoRead = fopen("arquivo.txt", "r");
    if(arquivoRead == NULL){
        printf("ERRO - cant open file read");
        return 1;
    }
    char line[1024];
    int lineLength;
    fgets(line, sizeof(line), arquivoRead);
    sscanf(line, "%lf", &output);
    lineLength = strlen(line);
    fseek(arquivoRead, 0, SEEK_SET);
    for(int i = n-1; i >= 0; i--){
        fseek(arquivoRead, i * lineLength, SEEK_SET);
        fscanf(arquivoRead, "%lf", &output);
        printf("%g\n", output);
    }
    fclose(arquivoRead);
    return 0;
}