#include <bits/stdc++.h>
using namespace std;

stack<int> S;
int n, _input, cnt;
string answer;

int main() {
	
	cin >> n;
	
	int cnt = 1;
	while(n--) {
		cin >> _input;
		
		while(cnt <= _input) {
			S.push(cnt++);
			answer += "+\n";
		}
		// 가장 끝의 값이 입력된 값이 아니면 2칸 이상 건너뛴 수열이므로
		// 당장 문제의 규칙에는 벗어나지 않아도 결국에는 규칙에 벗어난 수열이 됨 
		if(S.top() != _input) {
			cout << "NO\n";
			return 0;
		}
		S.pop();
		answer += "-\n";
	}
	
	cout << answer;
	return 0;
}
