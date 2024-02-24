#include <bits/stdc++.h>
using namespace std;

int n, total_y, total_m;

int main() {
	
	cin >> n;
	int arr[n];
	
	for(int i = 0; i < n; i++) cin >> arr[i];
	
	for(int ele: arr) {
		total_y += (ele / 30 + 1) * 10;
		total_m += (ele / 60 + 1) * 15;
	}
	
	if(total_y > total_m) cout << "M " << total_m;
	else if(total_y < total_m) cout << "Y " << total_y;
	else cout << "Y M " << total_m;
	 
	return 0;
}
