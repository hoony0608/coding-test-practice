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
		
		while(S.top().first < k) S.pop(); // ���� �Էµ� ���̺��� �迭�� ������ ������ pop 
		cout << S.top().second << " "; // ���� ������ ��ģ �迭�� �� ���� ��� 
		S.push({k, i});
	}
		
	return 0;
}
