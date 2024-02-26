#include <bits/stdc++.h>
using namespace std;

stack<int> S;
int n, _input, _MAX;
bool flag = false;
vector<char> v;

int main() {
	
	cin >> n;
	while(n--) {
		cin >> _input;
				
		if(_MAX < _input) {
			for(int i = _MAX + 1; i <= _input; i++) {
				S.push(i);
				v.push_back('+');
			}
			_MAX = _input;
		} else {
			if(S.empty() || S.top() < _input) {
				flag = true;
				break;
			}
		}
		
		while(!S.empty() && S.top() >= _input) {
			S.pop();
			v.push_back('-');
		}
	}
	
	if(flag) cout << "NO\n";
	else for(auto c: v) cout << c << "\n";
	 
	return 0;
}
