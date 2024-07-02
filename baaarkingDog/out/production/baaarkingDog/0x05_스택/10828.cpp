#include <bits/stdc++.h>
using namespace std;

const int _MAX = 10004;

int dat[_MAX], pos, n, _input;
string cmd;

void push(int x) {
	dat[pos] = x;
	pos++;
}

int pop() {
	if(pos == 0) return -1;
	return dat[--pos];
}

int size() {
	return pos;
}

int empty() {
	return (pos == 0) ? 1 : 0;
}

int top() {
	return (pos == 0) ? -1 : dat[pos - 1];
}

int main() {
	
	cin >> n;
	
	while(n--) {
		cin >> cmd;
		if(cmd == "push") {
			cin >> _input;
			push(_input);
		}
		if(cmd == "pop") {
			cout << pop() << "\n";
		}
		if(cmd == "size") {
			cout << size() << "\n";
		}
		if(cmd == "empty") {
			cout << empty() << "\n";
		}
		if(cmd == "top") {
			cout << top() << "\n";
		}
	}
	
	 
	return 0;
}
