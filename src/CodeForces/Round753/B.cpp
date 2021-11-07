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

ll sum(ll n) {
    if(n<=0)return 0;
    ll ans=1;
    ans+=((n-1)/4)*4;
    if((n-1)%4==1){
        return ans-n;
    }else if((n-1)%4==2){
        return ans-n-(n-1);
    }else if((n-1)%4==3){
        return ans+n-(n-1)-(n-2);
    }
    return ans;
}
void solve()
{
 ll x,n;
 cin>>x>>n;
    if(x&1)
        cout<<x+(sum(n))<<endl;
    else
        cout<<x-(sum(n))<<endl;
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
