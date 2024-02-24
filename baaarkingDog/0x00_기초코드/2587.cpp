#include <bits/stdc++.h>
using namespace std;

int arr[5], sum, avg;

int main() {
	
	for(int i = 0; i < 5; i++) {
		cin >> arr[i];
	}
	
	sort(arr, arr + 5);
	
	for(int ele: arr) {
		sum += ele;
	}
	
	cout << sum / 5 << "\n" << arr[2] << "\n";
	 
	return 0;
}
