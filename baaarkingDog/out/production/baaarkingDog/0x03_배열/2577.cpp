#include <bits/stdc++.h>
using namespace std;

int a, b, c, arr[10];

int main() {
	
	cin >> a >> b >> c;
	int x = a * b * c;
	
	while(x >= 1) {
		arr[x % 10]++;
		x /= 10;
	}
	
	
	for(int ele: arr) cout << ele << "\n";
	 
	return 0;
}
