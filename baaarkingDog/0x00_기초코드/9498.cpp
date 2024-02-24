#include <bits/stdc++.h>
using namespace std;

int testScore;

int main() {
	
	cin >> testScore;
	if(testScore >= 90) cout << "A" << "\n";
	else if(testScore >= 80) cout << "B" << "\n";
	else if(testScore >= 70) cout << "C" << "\n";
	else if(testScore >= 60) cout << "D" << "\n";
	else cout << "F" << "\n";
	
	return 0;
}
