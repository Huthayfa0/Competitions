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
#define MOD 1000000007
#define mm(arr) memset(arr, 0, sizeof(arr))
#define sz(v) (int) v.size()
#define all(v) v.begin(), v.end()
#define F first
#define S second

//DepthFirstSearch BreadthFirstSearch DijkstraShortestPath
//FloydWarshallShortestPath BellmanFordShortestPath PrimMST
//KruskalMST PrimeCheck Factorization NumberPower Matrix

void solve()
{
    ll n;
    cin>>n;
    VL arr(n);
    lp(i,0,n) cin>>arr[i];
    string x;
    cin>>x;
    VL b;
    VL r;
    lp(i,0,n){
        if(x[i]=='B')b.pb(arr[i]);
        else r.pb(arr[i]);
    }
    sort(all(b));
    sort(all(r));
    ll z= sz(b);
    bool ans= true;
    lp(i,0,z){
        if(b[i]<=i){
            ans= false;
            break;
        }
    }
    if(ans)
    lp(i,z,n){
        if(r[i-z]>i+1){
            ans= false;
            break;
        }
    }
    cout<<(ans?"YES":"NO")<<endl;
}



int main(){
    FAST
    ll t;
    cin>>t;
    while (t-->0){
        solve();
    }

    return 0;
}
