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
map<pair<ll,ll>,ll> ma;
ll ask(ll l,ll r){
    auto p=mp(l,r);
    if(ma.contains(p))return ma[p];
    cout<<"? "<<l<<" "<<r<<endl;
    cout.flush();
    ll x;
    cin>>x;
    if(x==-1)
        while (true){}
    return ma[p]=x;
}
void ans(ll i,ll j,ll k){
    cout<<"! "<<i<<" "<<j<<" "<<k<<endl;
    cout.flush();
}
void solve(){
    ll n;
    cin>>n;
    ll max= ask(1,n);
    ll mid;
    ll l=1,r=n;
    while (r-l>1){
        mid=l+(r-l)/2;
        ll a= ask(1,mid);
        if(a<max)l=mid+1;
        else r=mid;
    }

    ll k=ask(1,l)==max?l:r;
    l=1;
    while (r-l>1){
        mid=l+(r-l)/2;
        ll a= ask(mid,r);
        if(a<max)r=mid-1;
        else l=mid;
    }
    ll i=ask(r,n)==max?r:l,j=(i+k)/2;
    max=2*max-k*k-i*i-k-i;
    max/=2;
    ll b=-k-i-1,c=-max;
    ll discriminant = b*b - 4*c;
    if (discriminant > 0) {
        ll x1 = (-b + sqrt(discriminant)) / 2;
        ll x2 = (-b - sqrt(discriminant)) / 2;
        if(ask(x1-1,x1+1)==1)
            j=x1;
        else
            j=x2;
    }else if (discriminant == 0) {
        j = -b/2;
    }
    ans(i,j,k);
    ma.clear();
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
