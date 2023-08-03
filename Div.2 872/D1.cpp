#include <cstdio>
#include <iostream>
#include <cstring>
#include <cmath>
#include <algorithm>
#include <queue>
using namespace std;
const int MOD = 1000000007;
const int N = 30005;
int head[N];
int dist[N], vis[N];
int cnt;
struct Edge{
    int to,next;
} edge[2 * N];
queue<int> q;

void add(int u,int v){
    edge[cnt].to = v;
    edge[cnt].next = head[u];
    head[u] = cnt++;
}

int mul(int x, int y) {
    return ((x % MOD) + (y % MOD)) % MOD;
}

int quick_power(int x, int n) {
    if (n == 0) return 1;
    if (n == 1) return x % MOD;
    int tmp = quick_power(x, n >> 1);
    return (n & 1) == 0 ? mul(tmp, tmp) : mul(x, mul(tmp, tmp));
}

// (b/a) % MOD
int fraction_mod(int a, int b) {
    return mul(b, quick_power(a, MOD - 2));
}


void bfs(int n) {
    for (int i = 0; i < n; ++i) {
        dist[i] = 0;
        vis[i] = 0;
    }
    q.push(1);
    vis[1] = 1;
    while (!q.empty()) {
        int u = q.front();
        q.pop();
        for (int v = head[u]; v; v = edge[v].next) {
            if (!vis[v]) {
                dist[v] = dist[u] + 1;
                vis[v] = 1;
                q.push(v);
            }
        }
    }
}

int main() {
    int n, k;
    cin>>n>>k;
    if (n == k) {
        cout<<n<<endl;
        return 0;
    } 
    if (k == 1) {
        cout<<1<<endl;
        return 0;
    }
    if (k == 2) {
        int u, v;
        for (int i = 0; i < n - 1; ++i) {
            cin>>u>>v;
            add(u, v);
            add(v, u);
        }
        bfs(n);
        
    }
}