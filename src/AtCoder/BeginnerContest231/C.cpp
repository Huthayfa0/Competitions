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

void solve(){
    ll n,j;
    cin>>n>>j;
    map<ll,ll> m;
    ll x;
    lp(i,0,n){
        cin>>x;
        m[x]++;
    }
    auto s=m.end();
    s--;
    auto ss=s;
    s--;
    while (ss!=m.begin()){
        s->second+=ss->second;
        ss=s;
        s--;
    }
    lp(i,0,j){
        cin>>x;
        s=m.lower_bound(x);
        if(s==m.end())cout<<0<<endl;
        else
        cout<<s->second<<endl;
    }
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
