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
void chmin(ll&a,ll b){if(a>b)a=b;}
void chmax(ll&a,ll b){if(a<b)a=b;}
//DepthFirstSearch BreadthFirstSearch DijkstraShortestPath
//FloydWarshallShortestPath BellmanFordShortestPath PrimMST
//KruskalMST PrimeCheck Factorization NumberPower Matrix
vector<unordered_map<ll,ll>> v;
VL arr;
ll dp(ll rem,ll i) {
    if(i==-1)return abs(rem);
    if(v[i][rem]!=0)return v[i][rem];
    ll x=rem/arr[i];
    if(rem==arr[i]*x)
        return v[i][rem]= abs(x);
    else{
        return v[i][rem]= min(min(abs(x)+1+ dp(rem-(x-1)*arr[i],i-1),abs(x)+1+ dp(rem-(x+1)*arr[i],i-1)),abs(x)+dp(rem-(x)*arr[i],i-1));
    }
}

void solve(){
    ll n,q;
    cin>>n>>q;
    v=vector<unordered_map<ll,ll>>(n);
    arr=VL(n);
    lp(i,0,n)cin>>arr[i];
    cout<<dp(q,n-1)<<endl;

}

int main(){
    FAST
    ll t;
    t=1;
    while(t--){
       solve();
    }
    return 0;
}
