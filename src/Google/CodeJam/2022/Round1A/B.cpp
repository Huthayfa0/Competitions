#include<bits/stdc++.h>
#include <iostream>
#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>
using namespace std;
typedef long long ll;
typedef long double ld;
typedef vector<ll> VL;
typedef vector<VL> ML;
const double PI = acos(-1.0);
const ld EPS = 1e-18;

#define FAST ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);
#define mp make_pair
#define pb push_back
#define lp(i,s,f) for(ll i = s; (i) < ll(f); (i)++)
#define re(i,a) lp(i,0,sz(a)) cin >> (a)[i]
#define out(i,a) lp(i,0,sz(a)) cout << (a)[i] << ((i) == sz(a) - 1 ? '\n' : ' ')
#define inF freopen("in", "r", stdin);
#define outF freopen("out", "w", stdout);
#define endl '\n'
#define MOD 1000000007
#define inf 0x3f3f3f3f3f3f3f3fLL
#define mm(arr) memset(arr, 0, sizeof(arr))
#define sz(v) (int) (v).size()
#define all(v) (v).begin(), (v).end()
#define F first
#define S second
#define decimalpoint cout << std::fixed << setprecision(6)
typedef complex<ld> point;

using namespace __gnu_pbds;
#define ordered_set tree<pair<ll,ll>, null_type,less<>, rb_tree_tag,tree_order_statistics_node_update>
void chmin(ll&a,ll b){if(a>b)a=b;}
void chmax(ll&a,ll b){if(a<b)a=b;}
//DepthFirstSearch BreadthFirstSearch DijkstraShortestPath
//FloydWarshallShortestPath PrimMST MatrixExponentiation
//KruskalMST PrimeCheck Factorization NumberPower
//DivisionInverse Combinations Geometry SegmentsIntersection

const ll MX=1e9;
void solve(){
    ll n;
    cin>>n;
    VL a(n);
    ll cnt=0;
    ll sum=0;
    lp(i,0,n){
        if(i>=30){
            a[i]=MX-cnt-1;
            cnt++;
        }else{
            a[i]=1<<i;
        }
        sum+=a[i];
    }
    out(i,a);
    cout.flush();
    VL b(n);
    re(i,b);
    lp(i,0,n)sum+=b[i];
    sum/=2;
    sort(all(b));
    sort(all(a));
    vector<ll> ans;
    while(!b.empty()&&sum>b[b.size()-1]){
        sum-=b[b.size()-1];
        ans.push_back(b[b.size()-1]);
        b.pop_back();
    }
    while(!a.empty()&&sum>a[a.size()-1]){
        sum-=a[a.size()-1];
        ans.push_back(a[a.size()-1]);
        a.pop_back();
    }


    ll x=1;
    while(sum>0){
        if(sum&1)
            ans.push_back(x);
        x<<=1;
        sum>>=1;
    }
    out(i,ans);
    cout.flush();
}

int main(){
    FAST
    ll t=1;
   cin>>t;
  // ll nn=t;
    while(t--){
      // cout<<"Case #"<<nn-t<<": ";//<<endl;
       solve();
    }
    return 0;
}
