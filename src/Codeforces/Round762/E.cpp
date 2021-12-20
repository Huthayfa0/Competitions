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
    ll n;cin>>n;
    VL arr(n);
    lp(i,0,n)cin>>arr[i];
    sort(all(arr));
    VL ans(n+1,-1);
    VL temp;
    ll j=0;
    ll filled=0;
    lp(i,0,n+1){
        if(j<n){
            if (arr[j] != i) {
                ans[i] = filled;
                if (temp.empty()) {
                    break;
                } else {
                    filled += i - temp[sz(temp) - 1];
                    temp.pop_back();
                }
            } else {
                ll xx = 1;
                j++;
                while (j < n && arr[j] == i) {
                    temp.pb(arr[j]);
                    j++;
                    xx++;
                }
                ans[i] = xx + filled;
            }
        }else{
            ans[i] = filled;
            if (temp.empty()) {
                break;
            } else {
                filled += i - temp[sz(temp) - 1];
                temp.pop_back();
            }
        }
    }
    cout<<ans[0];
    lp(i,1,n+1){
        cout<<" "<<ans[i];
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
