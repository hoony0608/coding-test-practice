#include <bits/stdc++.h>
using namespace std;

string word;

int main() {
	cin >> word;
	
	for(int i = 'a'; i <= 'z'; i++) {
		int cnt = 0;
		for(char c: word) if(i == c) cnt++;
		cout << cnt << ' ';
	}
	
	return 0;
}
