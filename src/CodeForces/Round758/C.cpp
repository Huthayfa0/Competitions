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
ll N=100005;
ll n;
VL ans(N,0),aa(N),bb(N);
vector<pair<ll,ll>> a(N,pair<ll,ll>()),b(N,pair<ll,ll>());
void fill_after(ll i,ll ch){
    if (ans[i]==1)return;
    ans[i]=1;
    if(ch==1){
        ll x=lower_bound(a.begin(),a.begin()+n,mp(aa[i],i))-a.begin();
        lp(ii,x+1,n){
            if(ans[a[ii].S]==1)break;
            fill_after(a[ii].S,2);
        }
    }else{
        ll x=lower_bound(b.begin(),b.begin()+n,mp(bb[i],i))-b.begin();
        lp(ii,x+1,n){
            if(ans[b[ii].S]==1)break;
            fill_after(b[ii].S,1);
        }
    }
}
void solve(){

    cin>>n;

    lp(i,0,n) {
        ans[i]=0;
        cin >> aa[i];
        a[i].F = aa[i], a[i].S = i;
    }
    lp(i,0,n) { cin >> bb[i]; b[i].F = bb[i], b[i].S = i; }
    sort(a.begin(),a.begin()+n);
    sort(b.begin(),b.begin()+n);
    fill_after(a[n-1].S,2);
    fill_after(b[n-1].S,1);
    lp(i,0,n)
    cout<<ans[i];
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
