#include <bits/stdc++.h>
using namespace std;

int a, b, c, d, sum;

int main() {
	
	for(int i = 0; i < 3; i++) {
		cin >> a >> b >> c >> d;
		sum = a + b + c + d;
		
		if(sum == 3) cout << "A" << "\n";
		else if(sum == 2) cout << "B" << "\n";
		else if(sum == 1) cout << "C" << "\n";
		else if(sum == 0) cout << "D" << "\n";
		else cout << "E" << "\n";
	}
	
	return 0;
}
