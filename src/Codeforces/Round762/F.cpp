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
    ll n,m,k;
    cin>>n>>m>>k;
    ll x=n/m;
    ll y=n%m;
    ll v=y+y*x;
    ll ii=0;
    lp(i,0,k){
        ll j=ii;
        lp(xx,0,y){
            cout<<x+1;
            lp(z,0,x+1){
                cout<<" "<<((n+j++)%n)+1;
            }
            cout<<endl;
        }
        lp(xx,y,m){
            cout<<x;
            lp(z,0,x){
                cout<<" "<<((n+j++)%n)+1;
            }
            cout<<endl;
        }
        ii+=v;
        ii%=n;
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
