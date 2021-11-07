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
bool cmp(pair<ll,pair<ll,ll>> f,pair<ll,pair<ll,ll>> s){
    return ((f.second.second-f.second.first)<(s.second.second-s.second.first));
}
bool act(vector<ll>*ans,vector<pair<ll,pair<ll,ll>>> x,ll n,ll i){
    if(i==n)return true;
    lp(j,x[i].S.F,x[i].S.S+1){
        if((*ans)[j]==0){
            (*ans)[j]=x[i].F+1;
            if(act(ans,x,n,i+1)){
                return true;
            }else {
                (*ans)[j] = 0;
            }
        }
    }
    return false;
}
void solve() {
ll n;
cin>>n;
vector<pair<ll,pair<ll,ll>>> x(n);
    lp(i,0,n){
        cin>>x[i].S.F>>x[i].S.S;
        x[i].S.F--;x[i].S.S--;
        x[i].F=i;
    }
    sort(all(x),cmp);
    vector<ll> ans(n);
    if(act(&ans,x,n,0)){
        cout<<ans[0];
        lp(i,1,n){
            cout<<" "<<ans[i];
        }
        cout<<endl;
    }else{
        cout<<"impossible"<<endl;
    }
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


