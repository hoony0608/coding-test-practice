#include <bits/stdc++.h>
using namespace std;

int n, k, s, y, arr[13], answer;

int main() {
	
	cin >> n >> k;
	
	for(int i = 0; i < n; i++) {
		cin >> s >> y;
		arr[6 * s + y]++;
	}
	
	for(int ele: arr) {
		answer += ((ele + k - 1) / k);
	}
	cout << answer << "\n";
	
	return 0;
}
