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
string x;
ML d;
ML dp;
ll calc(ll i,ll j){
    ll &a=dp[i][j];
    if(a!=-2)return a;
    if(j<1+i)return a=1e18+5;
    if(i!=0) {
        i--;
        if ((d[j][0] - d[i][0] > d[j][1] - d[i][1]) && (d[j][0] - d[i][0] > d[j][2] - d[i][2])) return a = min(min(calc(i+2,j), calc(i+1,j-1)),j - i);
        else return a= min(calc(i+2,j), calc(i+1,j-1));
    }else{
        if ((d[j][0]  > d[j][1])  && (d[j][0] > d[j][2]) ) return a =min(min(calc(i+1,j), calc(i,j-1)), j + 1);
        else return a= min(calc(i+1,j), calc(i,j-1));
    }
}
void solve(){
    cin>>n>>x;
    d=ML(n,VL(3));
    dp=ML(n,VL(n,-2));
    d[0][x[0]-'a']++;
    lp(i,1,n){
        lp(j,0,3)d[i][j]=d[i-1][j];
        d[i][x[i]-'a']++;
    }
    ll ans=calc(0,n-1);
    if(ans==1e18+5)cout<<-1<<endl;
    else cout<<ans<<endl;
}

int main(){
    FAST
    ll t;
    cin>>t;
    while(t--){
        solve();
    }

    return 0;
}
