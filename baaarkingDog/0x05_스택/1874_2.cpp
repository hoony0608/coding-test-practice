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
		// ���� ���� ���� �Էµ� ���� �ƴϸ� 2ĭ �̻� �ǳʶ� �����̹Ƿ�
		// ���� ������ ��Ģ���� ����� �ʾƵ� �ᱹ���� ��Ģ�� ��� ������ �� 
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
