#include <bits/stdc++.h>
using namespace std;

int main() {
	
	string _input;
	cin >> _input;
	
	list<char> L;
	for(auto c: _input) L.push_back(c);
	auto cursor = L.end();
	
	int n;
	cin >> n;
	while(n--) {
		char cmd;
		cin >> cmd;
		
		if(cmd == 'L') {
			if(cursor != L.begin()) {
				cursor--;
			}
		}
		else if(cmd == 'D') {
			if(cursor != L.end()) {
				cursor++;
			}
		}
		else if(cmd == 'B') {
			if(cursor != L.begin()) {
				cursor--;
				cursor = L.erase(cursor);
			}
		}
		else if(cmd == 'P') {
			char c;
			cin >> c;
			L.insert(cursor, c);
		}
		
	}
	
	for(auto c: L) cout << c;
	
	 
	return 0;
}
