#include <stdio.h>

int main(int argc, char const *argv[]) {
  int arr1[5] = {1, 2, 3, 4, 5};
  int arr2[] = {1, 2, 3, 4, 5, 6, 7};
  int arr3[5] = {1};
  int ar1Len, ar2Len, ar3Len;

  printf("arr1 length: %lu\n", sizeof(arr1));
  printf("arr2 length: %lu\n", sizeof(arr2));
  printf("arr3 length: %lu\n", sizeof(arr3));

  ar1Len = sizeof(arr1) / sizeof(int);
  for (size_t i = 0; i < ar1Len; i++) {
    printf("%d ", arr1[i]);
  }
  printf("\n");

  ar2Len = sizeof(arr2) / sizeof(int);
  for (size_t i = 0; i < ar2Len; i++) {
    printf("%d ", arr2[i]);
  }
  printf("\n");

  ar3Len = sizeof(arr3) / sizeof(int);
  for (size_t i = 0; i < ar3Len; i++) {
    printf("%d ", arr3[i]);
  }
  printf("\n");

  return 0;
}
