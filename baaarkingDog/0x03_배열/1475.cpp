#include <bits/stdc++.h>
using namespace std;

int x, temp, _max, arr[9];

int main() {
	
	cin >> x;
	
	while(x > 0) {
		temp = x % 10;
		if(temp == 9) temp = 6;
		arr[temp]++;
		x /= 10;
	}
	
	for(int i = 0; i < 9; i++) {
		if(_max < arr[i]) {
			if(i == 6) _max = (arr[i] + 1) / 2;
			else _max = arr[i];
		}
	}
	
	cout << _max << "\n";
	
	return 0;
}
