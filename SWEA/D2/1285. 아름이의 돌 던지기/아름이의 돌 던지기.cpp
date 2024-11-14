#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_SIZE 100001

int main() {
   int testcase;
   scanf("%d", &testcase);
   
   for(int t = 1; t <= testcase; t++) {
       int size;
       scanf("%d", &size);
       
       int length[MAX_SIZE] = {0}; // Initialize array with zeros
       
       for(int i = 0; i < size; i++) {
           int num;
           scanf("%d", &num);
           length[abs(num)]++;
       }
       
       int minLen = 0;
       int people = 0;
       
       for(int i = 0; i < MAX_SIZE; i++) {
           if(length[i] != 0) {
               minLen = i;
               people = length[i];
               break;
           }
       }
       
       printf("#%d %d %d\n", t, minLen, people);
   }
   
   return 0;
}