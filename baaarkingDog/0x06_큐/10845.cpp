#include <bits/stdc++.h>
using namespace std;

const int _max = 100004;

int n, dat[_max], head = 0, tail = 0, x;
string cmd;

void push(int x) {
	dat[tail++] = x; 
}

void pop() {
	head++;
}

bool isEmpty() {
	return (tail == head) ? 1 : 0;
}

int main() {
	
	cin >> n;
	
	while(n--) {
		cin >> cmd;
		
		if(cmd == "push") {
			cin >> x;
			push(x);
		} else if (cmd == "pop") {
			if(isEmpty()) cout << -1 << "\n";
			else {
				cout << dat[head] << "\n"; 
				pop();
			}
		} else if (cmd == "size") {
			cout << tail - head << "\n";
		} else if (cmd == "empty") {
			cout << isEmpty() << "\n";
		} else if (cmd == "front") {
			if(isEmpty()) cout << -1 << "\n";
			else cout << dat[head] << "\n";
		} else if (cmd == "back") {
			if(isEmpty()) cout << -1 << "\n";
			else cout << dat[tail - 1] << "\n"; 
		}
		
	}
	
	return 0;
}
