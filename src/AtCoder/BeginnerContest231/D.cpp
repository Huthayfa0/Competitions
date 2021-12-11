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
VL isVisited;
vector<VL> lst;
VL parent;
ll dfs(ll v = 0) {
        isVisited[v] = true;
        for (ll &e:lst[v]) {
            if (!isVisited[e]) {
                parent[e] = v;
                if(!dfs(e)) return false;
            }else{
                if(e!=parent[v])
                    return false;
            }
        }
        return true;
}

void solve(){
    ll n,m;
    cin>>n>>m;isVisited=VL(n,0);
    ll ans=true;
    parent=VL(n,0);
    lst=vector<VL>(n,VL());
    vector<pair<ll,ll>> ad(m);
    lp(i,0,m){
        cin>>ad[i].F>>ad[i].S;ad[i].F--;ad[i].S--;
        lst[ad[i].F].pb(ad[i].S);
        lst[ad[i].S].pb(ad[i].F);
    }
    for (const VL& c:lst) {
        if(sz(c)>2){
            ans= false;
            break;
        }
    }
    if(ans)
    lp(i,0,n) {
        if(isVisited[i])continue;
        if(!dfs(i)){
            ans=false;break;
        }
    }

    cout<<(ans?"Yes":"No");
    cout<<endl;
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
