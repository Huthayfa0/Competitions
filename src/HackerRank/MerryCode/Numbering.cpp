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
    ll n,b;
    vector<char> xx;
    cin>>n>>b;
    while (n>0){
        ll x=n%b;
        if(x>9){
            xx.pb(char('A'+(x-10)));
        }else{
            xx.pb(char(x+'0'));
        }
        n/=b;
    }
    while (!xx.empty()){
        cout<<xx[xx.size()-1];
        xx.pop_back();
    }
    cout<<endl;
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
