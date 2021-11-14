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
ML dp;
void solve(){
    ll u,v,n,m;cin>>u>>v;
    ll ans=((u-u%3)/3)*(v-v%3);
    n=v%3;
    m=u%3;
    if(n==0){
        if(m!=0)
        ans+=m==1?v/3:(v/3)*2;
    }else{
        if(m==0)
            ans+=n==1?u/3:(u/3)*2;
        else if(m==n){
            ans+=m==1?((v/3+u/3)+1):(2*(v/3+u/3)+2);
        }else{
            ans+=m==1?(2*(v/3))+u/3+1:(2*(u/3))+v/3+1;
        }
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
