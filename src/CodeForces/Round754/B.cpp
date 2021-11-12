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
void solve(){
    ll n;
    string x;
    cin>>n>>x;
    bool b=false;
    lp(i,1,n){
        if(x[i-1]>x[i]){
            b= true;
            break;
        }
    }
    if(b){
        cout<<1<<endl;
        ll count=0;
        lp(i,0,n){
            if(x[i]=='1')
                count++;
        }
        VL xx;
        lp(i,0,n-count){
            if(x[i]=='1')
            xx.pb(i+1);
        }
        lp(i,n-count,n){
            if(x[i]=='0')
                xx.pb(i+1);
        }
        cout<<sz(xx);
        lp(i,0, sz(xx)){
            cout<<" "<<xx[i];
        }
        cout<<endl;
    }else{
        cout<<0<<endl;
    }
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
