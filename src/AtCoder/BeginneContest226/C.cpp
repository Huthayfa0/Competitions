#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef vector<ll> VL;
typedef vector<VL> ML;


#define FAST ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);
#define mp make_pair
#define pb push_back
#define lp(i,s,f) for(ll i = s; i < ll(f); i++)
#define inF freopen("in", "r", stdin);
#define outF freopen("out", "w", stdout);
#define endl '\n'
#define MOD 1000000000
#define mm(arr) memset(arr, 0, sizeof(arr))
#define sz(v) (int) v.size()
#define all(v) v.begin(), v.end()
#define F first
#define S second

//DepthFirstSearch BreadthFirstSearch DijkstraShortestPath
//FloydWarshallShortestPath BellmanFordShortestPath PrimMST
//KruskalMST PrimeCheck Factorization NumberPower Matrix
ll n;
ML arr;
VL tt;
VL vis;
ll dfs(ll i){
    if(vis[i])return 0;
    vis[i]=1;
    ll sum=tt[i];
    lp(j,0,sz(arr[i])){
        sum+= dfs(arr[i][j]-1);
    }
    return sum;
}
void solve(){
   cin>>n;
   tt=VL(n);
   ll m;
   arr=ML(n);
   vis=VL(n);
   lp(i,0,n){
       cin>>tt[i];
       cin>>m;
       arr[i]=VL(m);
       lp(j,0,m)cin>>arr[i][j];
   }
   cout<<dfs(n-1);
}

int main(){
    FAST
    ll t=1;
    while(t--){
        solve();
    }

    return 0;
}
