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
#define MOD 1000000007
#define mm(arr) memset(arr, 0, sizeof(arr))
#define sz(v) (int) v.size()
#define all(v) v.begin(), v.end()
#define F first
#define S second

//DepthFirstSearch BreadthFirstSearch DijkstraShortestPath
//FloydWarshallShortestPath BellmanFordShortestPath PrimMST
//KruskalMST PrimeCheck Factorization NumberPower Matrix

void solve()
{
    ll n,m;
    cin>>n>>m;
    string x;
    cin>>x;
    ll l=x.length();
    ll len[2];
    ll mx[4];
    mm(mx);
    mm(len);
    ll c=0;
    lp(i,0,l){
        switch (x[i]) {
           case 'U':
               len[0]++;
               if(len[0]+mx[2]>n-1)
                   goto here;
               mx[0]= max(len[0],mx[0]);
               break;
           case 'L':
               len[1]--;
               if(-len[1]+mx[3]>m-1)
                   goto here;
               mx[1]= max(-len[1],mx[1]);
               break;
            case 'D':
                len[0]--;
                if(-len[0]+mx[0]>n-1)
                    goto here;
                mx[2]= max(-len[0],mx[2]);
                break;
                default:
                    len[1]++;
                    if(len[1]+mx[1]>m-1)
                        goto here;
                    mx[3]= max(len[1],mx[3]);

        }
    }
    here:
    cout<<mx[0]+1<<" "<<mx[1]+1<<endl;
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
