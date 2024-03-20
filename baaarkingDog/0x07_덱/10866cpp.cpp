#include <bits/stdc++.h>
using namespace std;

const int MX = 5001;
int dat[2 * MX + 1];
int head = MX, tail = MX, n, x;
string cmd;

void push_front(int x) {
	dat[head--] = x;
}

void push_back(int x) {
	dat[++tail] = x;
}

void pop_front() {
	if(head < tail) head++;
}

void pop_back() {
	if(head < tail) tail--;
}

int size() {
	return tail - head;
}

bool empty() {
	return head == tail;
}

int front() {
	if(head < tail) return dat[head + 1];
	else return -1;
}

int back() {
	if(head < tail) return dat[tail];
	else return -1;
}

int main() {
	
	cin >> n;
	while(n--) {
		cin >> cmd;
		
		if(cmd == "push_front") {
			cin >> x;
			push_front(x);
		}
		
		else if(cmd == "push_back") {
			cin >> x;
			push_back(x);
		}
		
		else if(cmd == "pop_front") {
			cout << front() << "\n";
			pop_front();
		}
		
		else if(cmd == "pop_back") {
			cout << back() << "\n";
			pop_back();
		}
		
		else if(cmd == "size") {
			cout << size() << "\n";
		}
		
		else if(cmd == "empty") {
			cout << empty() << "\n";
		}
		
		else if(cmd == "front") {
			cout << front() << "\n";
		}
		
		else if(cmd == "back") {
			cout << back() << "\n";
		}
		
	}
	
	 
	return 0;
}
