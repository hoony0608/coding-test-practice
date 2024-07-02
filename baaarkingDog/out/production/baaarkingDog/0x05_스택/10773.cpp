#include <bits/stdc++.h>
using namespace std;

stack<int> S;
int k, _input, sum;

int main() {
	
	cin >> k;
	while(k--) {
		cin >> _input;
		if(_input == 0) S.pop();
		else S.push(_input);
	}
	
	while(S.size()) {
		sum += S.top();
		S.pop();
	}
	
	cout << sum << "\n";
	 
	return 0;
}
