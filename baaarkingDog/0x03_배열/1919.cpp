#include <bits/stdc++.h>
using namespace std;

int answer, arr[26];
string temp;

int main() {
	
	cin >> temp;
	for(auto c: temp) arr[c - 'a']++;
	
	cin >> temp;
	for(auto c: temp) arr[c - 'a']--;
	
	for(auto ele: arr) {
		answer += abs(ele);
	}
	
	cout << answer << "\n";
	 
	return 0;
}
