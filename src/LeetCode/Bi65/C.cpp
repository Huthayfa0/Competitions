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
    static bool cmp(vector<int> x,vector<int> y){
        return x[1]>y[1];
    }
    vector<int> maximumBeauty(vector<vector<int>>& items, vector<int>& queries) {
        sort(items.begin(),items.end(),cmp);
        unsigned int n=queries.size();
        vector<int> ans(n);
        vector<vector<int>> que(n,vector<int>(2));
        for (int i = 0; i < n; ++i) {
            que[i][0]=i;
            que[i][1]=queries[i];
        }
        int m=items.size();
        sort(que.begin(),que.end(), cmp);
        int c=0;
        for (int i = 0; i <n; ++i) {
            int x=que[i][1];
            while (c<m){
                if(items[c][0]<=x){
                    break;
                }
                c++;
            }
            if(c==m)break;
            ans[que[i][0]]=items[c][1];
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
