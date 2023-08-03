#include <cstdio>
#include <iostream>
#include <cstring>
using namespace std;

char s[100];
int main() {
    int t;
    cin>>t;
    for (int i = 0; i < t; ++i) {
        scanf("%s", s);
        bool flag = false;
        for (int j = 0; j < strlen(s) - 1; ++j) {
            if (s[j] != s[j + 1]) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            printf("%d\n", -1);
        } else {
            printf("%d\n", (int)strlen(s) - 1);
        }
    }
}
