#include <bits/stdc++.h>
using namespace std;

int n, x, temp, arr[201];

int main() {
	
	cin >> n;
	for(int i = 0; i < n; i++) {
		cin >> temp;
		arr[100 + temp]++;
	}
	cin >> x;
	
	cout << arr[100 + x] << "\n";
	 
	return 0;
}
