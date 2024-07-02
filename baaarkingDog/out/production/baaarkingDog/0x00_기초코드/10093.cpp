#include <bits/stdc++.h>
using namespace std;

long long temp, _min, _max; 

int main() {
	
	cin >> _min >> _max;
	
	if(_min != _max) {
		if(_min > _max) {
			temp = _min;
			_min = _max;
			_max = temp;
		}	
	
		cout << _max - _min - 1 << "\n";
	
		for(long long i = _min + 1; i < _max; i++) {
			cout << i << " ";
		}
			cout << "\n";
	} else cout << 0 << "\n";
	
	 
	return 0;
}
