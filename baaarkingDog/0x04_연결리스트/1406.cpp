#include <bits/stdc++.h>
using namespace std;

const int _MAX = 600004;

string _input;
char dat[_MAX], cmd;
int pre[_MAX], nxt[_MAX], unused = 1, n;

void insert(int addr, char c) {
	dat[unused] = c;
	pre[unused] = addr;
	nxt[unused] = nxt[addr];
	if(nxt[addr] != -1) pre[nxt[addr]] = unused;
	nxt[addr] = unused;
	unused++;
}

void erase(int addr) {
	if(nxt[addr] != -1) pre[nxt[addr]] = pre[addr];
	nxt[pre[addr]] = nxt[addr];
}

void traverse() {
	int cur = nxt[0];
	while(cur != -1) {
		cout << dat[cur];
		cur = nxt[cur];
	}
}

int main() {
	
	fill(nxt, nxt + _MAX, -1);
	fill(pre, pre + _MAX, -1);
	
	cin >> _input;
	
	int cursur = 0;
	for(auto c: _input) {
		insert(cursur, c);
		cursur++;
	}
	
	cin >> n;
	while(n--) {
		cin >> cmd;
		if(cmd == 'L' && pre[cursur] != -1) cursur = pre[cursur];
		else if(cmd == 'D' && nxt[cursur] != -1) cursur = nxt[cursur];
		else if(cmd == 'B' && pre[cursur] != -1) {
			erase(cursur);
			cursur = pre[cursur];
		} else if(cmd == 'P') {
			char c;
			cin >> c;
			insert(cursur, c);
			cursur = nxt[cursur];
		}
	}
	
	traverse();
	
	return 0;
}
