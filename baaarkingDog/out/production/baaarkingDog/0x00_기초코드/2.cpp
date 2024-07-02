#include <bits/stdc++.h>
using namespace std;

int n;
vector<int> v;
bool flag = false;

void func2(vector<int> v, int n) {
	
	for(int i = 0; i < n - 1; i++) {
		for(int j = i + 1; j < n; j++) {
			if(v[i] + v[j] == 100) {
				flag = true;
				break;
			}
		}
	}
	
	if(flag) cout << 1 << "\n";
	else cout << 0 << "\n";
}

int main() {
	
	v = {1, 52, 48};
	n = 3;
	
	func2(v, 3);
	
	return 0;
}
