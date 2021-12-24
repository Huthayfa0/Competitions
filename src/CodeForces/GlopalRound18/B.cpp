#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef long double ld;
const long double PI = acos(-1);
typedef vector<ll> VL;
typedef vector<VL> ML;
#define FAST ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);
#define mp make_pair
#define pb push_back
#define lp(i,s,f) for(ll i = s; (i) < ll(f); (i)++)
#define re(i,a) lp(i,0,sz(a)) cin >> (a)[i]
#define out(i,a) lp(i,0,sz(a)) cout << (a)[i] << ((i) == sz(a) - 1 ? '\n' : ' ')
#define inF freopen("in", "r", stdin);
#define outF freopen("out", "w", stdout);
#define endl '\n'
#define MOD 100000007
#define mm(arr) memset(arr, 0, sizeof(arr))
#define sz(v) (int) (v).size()
#define all(v) v.begin(), v.end()
#define F first
#define S second
#define decimalpoint cout << std::fixed << setprecision(5)
void chmin(ll&a,ll b){if(a>b)a=b;}
void chmax(ll&a,ll b){if(a<b)a=b;}
//DepthFirstSearch BreadthFirstSearch DijkstraShortestPath
//FloydWarshallShortestPath BellmanFordShortestPath PrimMST
//KruskalMST PrimeCheck Factorization NumberPower Matrix
ll count(ll n,ll x){
    ll ans=(n+1)/(1<<(x+1))*(1<<x);
    ans+=max((n+1)%(1<<(x+1))-(1<<x),0LL);
    return ans;
}

void solve(){
    ll l,r;cin>>l>>r;
    ll n=r-l+1;

    ll ans=n-1;
    lp(i,0,31){
        ll count1= count(r,i)- count(l-1,i);
    chmin(ans,n-count1);
    }
    cout<<ans<<endl;
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
