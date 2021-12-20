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
    string x;
    cin>>x;
    ll n=x.size();
    if(n%2!=0){
        cout<<"No"<<endl;
        return;
    }
    bool acc=true;
    for (int i = 0; i < n / 2; ++i) {
        if(x[i]!=x[i+n/2]){
            acc= false;
            break;
        }
    }
    cout<<(acc?"Yes":"No")<<endl;
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
