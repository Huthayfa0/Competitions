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

//DepthFirstSearch BreadthFirstSearch DijkstraShortestPath
//FloydWarshallShortestPath BellmanFordShortestPath PrimMST
//KruskalMST PrimeCheck Factorization NumberPower Matrix
class Solution {
public:
    vector<int> maximumBeauty(vector<vector<int>>& items, vector<int>& queries) {
        map<int,int> dp;
        for (auto x:items) {
            dp[x[0]]= max(dp[x[0]],x[1]);
        }
        auto ite=dp.begin();
        while (ite!=dp.end()){
            auto tt=ite;
            ite++;
            (*ite).second= max((*ite).second,(*(tt)).second);
        }
        int m=queries.size();
        vector<int> ans(m);
        for (int i = 0; i < m; ++i) {
            auto x= dp.lower_bound(queries[i]);
            if((*x).first!=queries[i]&&x!=dp.begin())x--;
             ans[i]=(*x).first<=queries[i]?(*x).second:0;
        }
        return ans;
    }
};
void solve(){
    Solution x;
    vector<vector<int>> a={{1, 2}, {3, 2}, {2, 4}, {5, 6}, {3, 5}};
    vector<int> b={1, 2, 3, 4, 5, 6};
    auto t=x.maximumBeauty(a, b);
}

int main(){
    FAST
    ll t;
    t=1;
    //cin>>t;
    while(t--){
        solve();
    }

    return 0;
}
