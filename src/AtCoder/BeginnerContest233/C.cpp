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
ML arr;
ll n,x;
ll cnt(ll idx,ll val){
    if(idx==n){
        return val==1;
    }
    ll ans=0;
    ll count=1;
    lp(i,1, sz(arr[idx])){
        if(arr[idx][i]!=arr[idx][i-1]){
            ans+=val%arr[idx][i-1]?0:count* cnt(idx+1,val/arr[idx][i-1]);
            count=1;
        }else{
            count++;
        }
    }
    ans+=val%arr[idx][sz(arr[idx])-1]?0:count* cnt(idx+1,val/arr[idx][sz(arr[idx])-1]);
    return ans;
}
void solve(){
    cin>>n>>x;
    arr=ML (n);
    lp(i,0,n){
        ll l;cin>>l;
        arr[i]=VL(l);
        re(j,arr[i]);
        sort(all(arr[i]));
    }
    cout<<cnt(0,x)<<endl;
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
