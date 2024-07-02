#include <bits/stdc++.h>
using namespace std;

int n;


int main() {
	
	cin >> n;
	
	while(n--) {
		list<char> L;
		string _input;
		auto cursor = L.begin();
		
		cin >> _input;
		for(auto c: _input) {
			if(c == '<') {
				if(cursor != L.begin()) cursor--;
			} else if(c == '>') {
				if(cursor != L.end()) cursor++;
			} else if(c == '-') {
				if(cursor != L.begin()) {
					cursor--;
					cursor = L.erase(cursor);
				}
			} else L.insert(cursor, c);
		}
		
		for(auto c: L) cout << c;
		cout << "\n";
	}
	 
	return 0;
}
