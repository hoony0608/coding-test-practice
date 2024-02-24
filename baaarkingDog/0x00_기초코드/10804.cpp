#include <bits/stdc++.h>
using namespace std;

int arr[21], a, b;

void func(int arr[], int a, int b) {
	int temp = 0;
	
	for(int i = 0; i < (b - a + 1) / 2; i++) {
			temp = arr[a + i];
			arr[a + i] = arr[b - i];
			arr[b - i] = temp; 
		}
}

int main() {
	
	for(int i = 0; i < 21; i++) arr[i] = i;
	
	for(int i = 0; i < 10; i++) {
		cin >> a >> b;
		func(arr, a, b);
	}
	
	for(int ele: arr) {
		if(ele == 0) continue;
		cout << ele << " ";
	}
	 
	return 0;
}
