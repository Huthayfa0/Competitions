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
#define decimalpoint cout << std::fixed << setprecision(2)
typedef complex<ld> point;

using namespace __gnu_pbds;
#define ordered_set tree<pair<ll,ll>, null_type,less<>, rb_tree_tag,tree_order_statistics_node_update>
void chmin(ll&a,ll b){if(a>b)a=b;}
void chmax(ll&a,ll b){if(a<b)a=b;}
//DepthFirstSearch BreadthFirstSearch DijkstraShortestPath
//FloydWarshallShortestPath PrimMST MatrixExponentiation
//KruskalMST PrimeCheck Factorization NumberPower
//DivisionInverse Combinations Geometry
//LinesGeometry CirclesGeometry

bool srt(const pair<ll,pair<ll,ll>> &a,
               const pair<ll,pair<ll,ll>> &b)
{
    return (a.S.F < b.S.F);
}
void solve(){
    ll n,l;cin>>n>>l;
    vector<pair<ll,pair<ll,ll>>>ants(n);
    lp(i,1,n+1){
        ants[i-1].F=i;
        cin>>ants[i-1].S.F>>ants[i-1].S.S;
    }
    sort(all(ants),srt);
    VL ans;
    while(n>0){
        lp(i,0,n){
            if(ants[i].S.S){
                ants[i].S.F++;
            }else{
                ants[i].S.F--;
            }
        }
        lp(i,1,n){
            if(ants[i].S.F<=ants[i-1].S.F){
                ants[i].S.S^=1;
                ants[i-1].S.S^=1;
                if(ants[i].S.F<ants[i-1].S.F){
                    ants[i].S.F++;
                    ants[i-1].S.F--;
                }
            }
        }
        if(ants[n-1].S.F==l&&ants[0].S.F==0){
            ans.pb(min(ants[0].F,ants[n-1].F));
            ans.pb(max(ants[0].F,ants[n-1].F));
            ants.pop_back();
            ants.erase(ants.begin());
            n--;
            n--;
        }else {
            if (ants[0].S.F == 0) {
                ans.pb(ants[0].F);
                ants.erase(ants.begin());
                n--;
            }
            if (ants[n - 1].S.F == l) {
                ans.pb(ants[n - 1].F);
                ants.pop_back();
                n--;
            }
        }
    }
    out(i,ans);
}

int main(){
    FAST
    ll t=1;
    cin>>t;
    ll nn=t;
    while(t--){
       cout<<"Case #"<<nn-t<<": ";//<<endl;
        solve();
    }

    return 0;
}
