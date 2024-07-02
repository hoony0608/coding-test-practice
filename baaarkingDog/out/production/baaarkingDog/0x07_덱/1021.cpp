#include <bits/stdc++.h>
using namespace std;

deque<int> DQ, DQ1, DQ2;
int n, m, x, answer, move1, move2;

int main() {
	
	cin >> n;
	for(int i = 1; i <= n; i++) DQ.push_back(i);
	
	cin >> m;
	while(m--) {
		DQ1 = DQ;
		DQ2 = DQ;
		move1 = 0, move2 = 0;
		
		cin >> x;
		
		while(DQ1.front() != x) {
			DQ1.push_back(DQ1.front());
			DQ1.pop_front();
			move1++;
		}
		
		while(DQ2.front() != x) {
			DQ2.push_front(DQ2.back());
			DQ2.pop_back();
			move2++;
		}
		
		if(move1 < move2) {
			answer += move1;
			DQ = DQ1;
		} else {
			answer += move2;
			DQ = DQ2;
		}
		
		DQ.pop_front();
	}
	
	cout << answer << "\n";
	return 0;
}
