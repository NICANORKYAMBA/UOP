#include <stdio.h>
extern int limit;   /* a reference: the linker decides which definition it means */
int main(void) { printf("limit = %d\n", limit); return 0; }
