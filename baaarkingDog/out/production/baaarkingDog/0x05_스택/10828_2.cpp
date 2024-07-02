#include <bits/stdc++.h>
using namespace std;

stack<int> S;
int n, _input;
string cmd;

int main() {
	
	cin >> n;
	
	while(n--) {
		cin >> cmd;
		
		if(cmd == "push") {
			cin >> _input;
			S.push(_input);
		}
		if(cmd == "pop") {
			if(S.empty()) cout << -1 << "\n";
			else {
				cout << S.top() << "\n";
				S.pop();
			}
		}
		if(cmd == "size") {
			cout << S.size() << "\n";
		}
		if(cmd == "empty") {
			if(S.empty()) cout << 1 << "\n";
			else cout << 0 << "\n";
		}
		if(cmd == "top") {
			if(S.empty()) cout << -1 << "\n";
			else cout << S.top() << "\n";
		}
	}
	
	 
	return 0;
}
