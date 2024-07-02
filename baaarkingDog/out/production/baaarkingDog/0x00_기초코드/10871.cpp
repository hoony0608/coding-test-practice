#include <bits/stdc++.h>
using namespace std;

int n, x, temp;
vector<int> a;

int main() {
//	cin >> n >> x;
//	
//	for(int i = 0; i < n; i++) {
//		cin >> temp;
//		if(temp < x) a.push_back(temp);
//	}
//	
//	for(int i: a) cout << i << " ";

	cin >> n >> x;
	
	while(n--) {
		cin >> temp;
		if(temp < x) cout << temp << ' ';
	}
	
	return 0;
}
