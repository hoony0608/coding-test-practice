#include <bits/stdc++.h>
using namespace std;

int n;
string temp;

int main() {
	
	cin >> n;
	
	while(n--) {
		
		int arr[26] = {};
		bool flag = false;
		
		cin >> temp;
		for(char c: temp) arr[c - 'a']++;
		cin >> temp;
		for(char c: temp) arr[c - 'a']--;
		
		for(int ele: arr) if(ele != 0) flag = true;
		
		if(flag) cout << "Impossible" << "\n";
		else cout << "Possible" << "\n";
		
	}
	 
	return 0;
}
