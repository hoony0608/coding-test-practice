#include <bits/stdc++.h>
using namespace std;

stack<pair<int, int>> S;
int n, k, idx; 

int main() {
	
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	
	S.push({100000001, 0});
	cin >> n;
	for(int i = 1; i <= n; i++) {
		cin >> k;
		
		while(S.top().first < k) S.pop(); // 현재 입력된 높이보다 배열의 끝값이 작으면 pop 
		cout << S.top().second << " "; // 위의 과정을 거친 배열의 끝 값을 출력 
		S.push({k, i});
	}
		
	return 0;
}
