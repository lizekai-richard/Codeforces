#include <cstdio>
#include <iostream>
#include <cstring>
#include <cmath>
#include <algorithm>
using namespace std;

const int N = 20001;
int arr[N];

int main() {
    int T, n, m;
    cin>>T;
    for(int t = 0; t < T; ++t) {
        cin>>n>>m;
        for (int i = 0; i < n * m; ++i) cin>>arr[i];
        sort(arr, arr + n * m);
        int smallest = arr[0];
        int second_smallest = arr[1];
        int largest = arr[n * m - 1];
        int second_largest = arr[n * m - 2];

        int res1 = (n * m - min(m, n)) * (largest - smallest) + (min(n, m) - 1) * (largest - second_smallest);
        int res2 = (n * m - min(m, n)) * (largest - smallest) + (min(n, m) - 1) * (second_largest - smallest);
        int res = max(res1, res2);
        cout<<res<<endl;
    }
}