#include <bits/stdc++.h>
using namespace std;

int n, x, answer, arr[2000001];
bool flag[1000001];

int main() {
	
	ios_base::sync_with_stdio(0);
	cin.tie(NULL); cout.tie(NULL);
	
	// ют╥б 
	cin >> n;
	int arr[n] = {};
	for(int i = 0; i < n; i++) cin >> arr[i];
	cin >> x;
	
	for(int i = 0; i < n; i++) {
		if(x - arr[i] > 0 && flag[x - arr[i]]) answer++;
		flag[arr[i]] = true;	
	}
	
	cout << answer << "\n";
	
	return 0;
}
