#include <bits/stdc++.h>
using namespace std;

int temp, _max = 0, _max_index = 0;

int main() {
	
	for(int i = 0; i < 9; i++) {
		cin >> temp;
		if(temp > _max) {
			_max = temp;
			_max_index = i + 1;
		}
	}
	
	cout << _max << "\n" << _max_index;
	 
	return 0;
}
