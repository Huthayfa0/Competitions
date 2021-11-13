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
bitset<1005> dd;
void solve(){
 ll n;
 cin>>n;
 ll ans=0;
 ll x;
    lp(i,0,n){
        cin>>x;
        ans+=!dd[x];
    }
    cout<<ans<<endl;
}

int main(){
    FAST
    dd=0;
    lp(i,1,150){
        lp(j,1,150){
            ll x=i*3+j*3+i*j*4;
            if(x<1005){
                dd[x]=true;
            }
        }
    }
    ll t;
    t=1;
    //cin>>t;
    while(t--){
        solve();
    }

    return 0;
}
