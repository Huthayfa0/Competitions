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
ll gcd(ll a,ll b){
    return (b!=0? gcd(b,a%b):a);
}
void solve(){
    ll n;
   cin>>n;
   vector<pair<ll,ll>> arr(n);
   set<pair<ll,ll>> s;
    lp(i,0,n)cin>>arr[i].F>>arr[i].S;
    lp(i,0,n) {
        lp(j, i + 1, n) {
            auto p=mp(arr[i].F-arr[j].F,arr[i].S-arr[j].S);
            if(p.F==0&&p.S==0) continue;
            ll t= gcd(max(abs(p.F),abs(p.S)),min(abs(p.F),abs(p.S)));
            p.F/=t;
            p.S/=t;
            s.insert(p);
            p.F*=-1;p.S*=-1;
            s.insert(p);
        }
    }
    cout<<sz(s)<<endl;
}

int main(){
    FAST
    ll t=1;
    while(t--){
        solve();
    }

    return 0;
}
