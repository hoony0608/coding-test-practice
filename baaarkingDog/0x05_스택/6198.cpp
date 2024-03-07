#include <bits/stdc++.h>
using namespace std;

stack<int> S;
int n, h;
long long answer;

int main() {
	
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> n;
	
	while(n--) {
		cin >> h;
		
		while(!S.empty() && S.top() <= h) S.pop();
		answer += S.size();
		S.push(h);
	}
	
	cout << answer;
	return 0;
}
