#include <stdio.h>
#include <string.h>

void isPalindrome(char input[]){
	int length = strlen(input);
	int palindromeBool = 1;
	for(int i = 0; i < length / 2; i++){
		if(input[i] != input[length - i - 1]){
			palindromeBool = 0;
			i = length / 2;
		}
	}
	if(palindromeBool == 1){
		printf("SIM\n");
	} else {
		printf("NAO\n");
	}
}

int main(){
	char input[500];
	scanf(" %[^\r\n]", input);
	while(strcmp(input, "FIM") != 0){
		isPalindrome(input);
		scanf(" %[^\r\n]", input);
	}
}