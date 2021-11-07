#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

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
//KruskalMST PrimeCheck Factorization
bool cmp(ll x,ll y){
    return __builtin_popcount((unsigned int)x)>= __builtin_popcount((unsigned int)y);
}
void solve() {
ll n,m;
cin>>n>>m;
vector<string> x(n);
    lp(i,0,n) cin>>x[i];
    vector<ll> arr(n);
    lp(i,0,n){
        lp(j,0,m){
            if(x[i][j]=='y')
                arr[i]|=1<<j;
        }
    }
    sort(all(arr),cmp);
    ll v=(1<<m);
    ll count=0;
    lp(i,0,n){
        lp(j,i+1,n){
            ll y=arr[i]|arr[j];
            if((y+1)==v) {
                count += n - j - 1;
                continue;
            }
            lp(k,j+1,n){
                ll xx=y|arr[k];
                if((xx+1)==v)
                    count++;
            }
        }
    }
    cout<<count<<endl;
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


