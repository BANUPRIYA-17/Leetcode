#include <limits.h>

int thirdMax(int* nums, int numsSize) {
    long first = LONG_MIN;
    long second = LONG_MIN;
    long third = LONG_MIN;

    for (int i = 0; i < numsSize; i++) {
        long n = nums[i];

        if (n == first || n == second || n == third) {
            continue;
        }

        if (n > first) {
            third = second;
            second = first;
            first = n;
        } else if (n > second) {
            third = second;
            second = n;
        } else if (n > third) {
            third = n;
        }
    }

    if (third == LONG_MIN) {
        return (int)first;
    }

    return (int)third;
}
