#include <bits/stdc++.h>
using namespace std;

int arr[11], temp, sum, _min = 101;

int main() {
	
	for(int i = 0; i < 7; i++) {
		cin >> temp;
		
		if(temp % 2 == 1) {
			sum += temp;
			if(_min > temp) _min = temp;
		}
	}
	
	if(sum == 0) {
		cout << -1  << "\n";
	} else {
		cout << sum << "\n" << _min << "\n";
	}
	 
	return 0;
}
