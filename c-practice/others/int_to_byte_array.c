#include <stdio.h>

int main(int argc, char const *argv[]) {
  unsigned char bytes[4];
  unsigned char wrong[4];
  unsigned long n = 152152;
  unsigned long a = 0;
  unsigned long b = 0;

  // Converting an int into a 4 byte char array
  bytes[0] = (n >> 24) & 0xFF;
  bytes[1] = (n >> 16) & 0xFF;
  bytes[2] = (n >> 8) & 0xFF;
  bytes[3] = n & 0xFF;

  // Wrong method, but it works fine with GCC compiler
  wrong[0] = n >> 24;
  wrong[1] = n >> 16;
  wrong[2] = n >> 8;
  wrong[3] = n;

  printf("%x %x %x %x\n", bytes[0], bytes[1], bytes[2], bytes[3]);
  printf("%x %x %x %x\n", wrong[0], wrong[1], wrong[2], wrong[3]);

  // Converting back to int
  a = bytes[3] + bytes[2] * 256 + bytes[1] * 256 * 256 + bytes[0] * 256 * 256 * 256;
  // This is wrong way to convert back
  b = bytes[3] + bytes[2] * 256 + bytes[1] * 256 * 2 + bytes[0] * 256 * 4; // wrong

  printf("%lu\n", a);
  printf("%lu\n", b);

  return 0;
}
