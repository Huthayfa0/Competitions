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
    ll n,m;
    cin>>m>>n;
    ML arr(m,VL(n));
    VL ans(n,0);
    pair<ll,ll> mm;
    ll mmi=-1;
    lp(i,0,m) {
        lp(j,0,n)cin >> arr[i][j];
        pair<ll,ll> tm=arr[i][0]>arr[i][1]?pair{0,1}:pair{1,0};
        chmax(ans[0],arr[i][0]);
        chmax(ans[1],arr[i][1]);
        lp(j, 2, n) {
            chmax(ans[j],arr[i][j]);
            if(arr[i][j]>arr[i][tm.F]){
                tm.S=tm.F;
                tm.F=j;

            }else{
                if(arr[i][j]>arr[i][tm.S]){
                    tm.S=j;
                }
            }}

        if(mmi==-1||arr[i][tm.S]>arr[mmi][mm.S]){
            mmi=i;
            mm=tm;
        }
    }
    if(m>=n) {
        ans[mm.S] = arr[mmi][mm.S];
        ans[mm.F] = arr[mmi][mm.F];
    }
    cout<<(*min_element(ans.begin(), ans.end()))<<endl;
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
