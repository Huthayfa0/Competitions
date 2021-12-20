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
    string x,s;
    cin>>x>>s;
    vector<char> ans;
    ll j=s.size()-1;

    if(x.size()>s.size()){
        cout<<-1<<endl;return;
    }
    for (int i = x.size()-1; i >=0; --i) {
        if(j<0){
            cout<<-1<<endl;return;
        }
        if(x[i]<=s[j]){
            ans.pb(char(s[j]-x[i]+'0'));
        }else{
            if(j==0||s[j-1]!='1'){
                cout<<-1<<endl;return;
            }
            ans.pb(char(10+s[j]-x[i]+'0'));
            j--;
        }
        j--;
    }
    while (j>=0){
        ans.push_back(s[j--]);
    }
    int i = sz(ans)-1;
    while (ans[i]=='0'&&i!=0)i--;
    for (; i >=0; --i){

        cout<<ans[i];
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
