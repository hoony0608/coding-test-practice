#include <bits/stdc++.h>
using namespace std;

int arr[9], a, b, sum;

int main() {
	
	for(int i = 0; i < 9; i++) {
		cin >> arr[i];
		sum += arr[i];
	}
	
	sort(arr, arr + 9);
	
	// 제외할 숫자 2개 정하기 
	for(int i = 0; i < 8; i++) {
		for(int j = i + 1; j < 9; j++) {
			if(sum - (arr[i] + arr[j]) == 100) {
				a = arr[i];
				b = arr[j];
			}
		}
	}
	
	for(int ele: arr) {
		if(ele != a && ele != b) cout << ele << "\n";
	}
	
	return 0;
}
