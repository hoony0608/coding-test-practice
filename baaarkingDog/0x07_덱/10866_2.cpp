#include <bits/stdc++.h>
using namespace std;

deque<int> DQ;
int n, x;
string cmd;

int main() {
	
	cin >> n;
	
	while(n--) {
		cin >> cmd;
		
		if(cmd == "push_front") {
			cin >> x;
			DQ.push_front(x);
		} else if (cmd == "push_back") {
			cin >> x;
			DQ.push_back(x);
		} else if (cmd == "pop_front") {
			if(!DQ.empty()) {
				cout << DQ.front() << "\n";
				DQ.pop_front();
			} else cout << -1 << "\n";
		} else if (cmd == "pop_back") {
			if(!DQ.empty()) {
				cout << DQ.back() << "\n";
				DQ.pop_back();
			} else cout << -1 << "\n";
		} else if (cmd == "size") {
			cout << DQ.size() << "\n";
		} else if (cmd == "empty") {
			cout << DQ.empty() << "\n";
		} else if (cmd == "front") {
			if(!DQ.empty()) cout << DQ.front() << "\n";
			else cout << -1 << "\n";
		} else if (cmd == "back") {
			if(!DQ.empty()) cout << DQ.back() << "\n";
			else cout << -1 << "\n";
		}
	}
	
	 
	return 0;
}
