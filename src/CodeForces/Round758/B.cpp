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

void solve(){
    ll n,a,b;
    cin>>n>>a>>b;
    ll max=n/2-1+(n&1);
    if (a>max||b>max||(a==max&&b==max&&(n&1))||abs(a-b)>1){
        cout<<-1<<endl;
        return;
    }
    ll x=1;
    ll y=n;
    bool t= false;
    if(a==0&&b==0){
        cout<<x++;
    }else
    if(a>b){
        cout<<x;
        cout<<" "<<y;
        t=true;
        a--;
        x++;
        y--;
        while (x<y){
            if (a==0&&b==0)break;
            cout<<" "<<x;t= false;
            b--;
            if(a==0&&b==0)break;
            cout<<" "<<y;
            t=true;
            a--;
            x++;
            y--;
        }
    }else{
        cout<<y;
        cout<<" "<<x;t= false;
        b--;x++;y--;
        while (x<y){
            if (a==0&&b==0)break;
            cout<<" "<<y;t=true;
            a--;
            y--;
            if(a==0&&b==0)break;
            cout<<" "<<x;t= false;
            b--;
            x++;

        }
    }
    if(!t){
        lp(i,x,y+1)
        cout<<" "<<i;
    }else{
        for (ll i = y; i >=x; --i) {
            cout<<" "<<i;
        }
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
