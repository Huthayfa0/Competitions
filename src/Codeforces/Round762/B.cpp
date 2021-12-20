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
#define MOD 100000007
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
void solve(){
    unordered_set<ll> x;
    ll n;cin>>n;
    ll count=0;
    for (int i = 1; i*i <= n; ++i) {
        count++;
        x.insert(i*i);
    }
    for (int i = 2; i*i*i <= n; ++i) {
        if(!x.contains(i*i*i))count++;
    }
    cout<<(count)<<endl;
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
