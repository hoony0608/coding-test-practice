#include <bits/stdc++.h>
using namespace std;

int n;

void printS(string s, int num) {
	for(int i = 0; i < num; i++) cout << s;
}

int main() {
	
	cin >> n;
	
	for(int i = 0; i < n; i++) {
		printS(" ", i);
		printS("*", n - i);
		printS("*", n - i - 1);
		cout << "\n";
	}
	
	for(int i = n - 2; i >= 0; i--) {
		printS(" ", i);
		printS("*", n - i);
		printS("*", n - i - 1);
		cout << "\n";
	}
	 
	return 0;
}
