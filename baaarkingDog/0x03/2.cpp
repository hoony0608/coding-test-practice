#include <bits/stdc++.h>
using namespace std;

int n;
vector<int> v;
bool flag = false;

int func2(vector<int> v, int n) {
	int arr[101] = {};
	
	for(int i = 0; i < n; i++) {
		if(arr[100 - v[i]] == 1) return 1;
		arr[v[i]]++;
	}
	
	return 0;
	
}

int main() {
	
	v = {1, 23, 53, 77, 60};
	n = 5;
	
	cout << func2(v, n) << "\n";
	
	return 0;
}
