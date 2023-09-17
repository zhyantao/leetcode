#include "bits/stdc++.h"

using namespace std;

char func(char a, char b) {
    if (a < b)
        return a;
    return b;
}

int main() {
    int a = '7', b = '8', c = '9';
    cout << func(func(a, b), func(b, c)) << endl;
}