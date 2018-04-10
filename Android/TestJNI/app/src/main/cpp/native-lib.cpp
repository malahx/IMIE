#include <jni.h>

extern "C"

int isPrime(int n) {
    if (n <= 1)  return 0;
    if (n <= 3)  return 1;

    // This is checked so that we can skip
    // middle five numbers in below loop
    if (n%2 == 0 || n%3 == 0) return 0;

    for (int i=5; i*i<=n; i=i+6)
        if (n%i == 0 || n%(i+2) == 0)
            return 0;

    return 1;
}

JNIEXPORT jbooleanArray JNICALL
Java_fr_imie_malah_testjni_MainActivity_calc(JNIEnv *env, jobject instance) {

    int max = 1000000;
    int numbers[max];

    for (int i = 0; i < max; i++) {
        numbers[i] = isPrime(i);
    }
    return env->NewBooleanArray(max);

}