#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef long double ld;
const long double PI = acos(-1);
typedef vector<ll> VL;
typedef vector<VL> ML;
#define FAST ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);
#define mp make_pair
#define pb push_back
#define lp(i,s,f) for(ll i = s; (i) < ll(f); (i)++)
#define re(i,a) lp(i,0,sz(a)) cin >> (a)[i]
#define out(i,a) lp(i,0,sz(a)) cout << (a)[i] << ((i) == sz(a) - 1 ? '\n' : ' ')
#define inF freopen("in", "r", stdin);
#define outF freopen("out", "w", stdout);
#define endl '\n'
#define MOD 100000007
#define mm(arr) memset(arr, 0, sizeof(arr))
#define sz(v) (int) (v).size()
#define all(v) v.begin(), v.end()
#define F first
#define S second
#define decimalpoint cout << std::fixed << setprecision(5)
void chmin(ll&a,ll b){if(a>b)a=b;}
void chmax(ll&a,ll b){if(a<b)a=b;}
//DepthFirstSearch BreadthFirstSearch DijkstraShortestPath
//FloydWarshallShortestPath BellmanFordShortestPath PrimMST
//KruskalMST PrimeCheck Factorization NumberPower Matrix

void solve(){
    string x;
    cin>>x;
    ll n= sz(x);
    ll sum=0;
    vector<char> ans;
    lp(i,0, n){
        sum+=x[i]-'0';
    }
    ll remain=0;
    lp(i,0, n){
        remain+=sum;
        ans.pb(char(remain%10+'0'));
        remain/=10;
        sum-=x[n-i-1]-'0';
    }
    while (remain>0){
        ans.pb(char(remain%10+'0'));
        remain/=10;
    }
    ll zeros=0;
    n= sz(ans);
    lp(i,0, n){
        if(ans[n-i-1]!='0')break;
        zeros++;
    }
    for (int i = n-1-zeros; i >= zeros; --i) {
        cout<<ans[i];
    }
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
