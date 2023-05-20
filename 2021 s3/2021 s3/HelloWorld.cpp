#include <iostream>
#include <cstdio>
typedef long long ll;
#define ti tuple<ll, ll, ll> // position, time per metre, sound range

using namespace std;

// Time is in the shape of a U with the vertex at the bottom
// Tuple takes much more than than simply 2d array

int people[200005][3];
int n, p, w, d;
ll getTime(int i);
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	int starti = 1000000001;
	int endi = 0;

	cin >> n;


	for (int i = 1; i <= n; i++)
	{
		cin >> p >> w >> d;
		if (p < starti) starti = p;
		if (p > endi) endi = p;
		people[i][0] = p;
		people[i][1] = w;
		people[i][2] = d;
	}

	ll shortestTime = 10000000000;
	// Binary Search: start from the middle

	while(starti <= endi)
	{
		int mid = (starti + endi) / 2;
		shortestTime = getTime(mid);
		ll tRight = getTime(mid + 1);
		ll tLeft = getTime(mid - 1);
		if (tRight == shortestTime && shortestTime == tLeft) break;
		else if (tRight < shortestTime) starti=mid;
		else if (tLeft < shortestTime) endi=mid;
		else if (tRight > shortestTime && tLeft > shortestTime)break;
	}
	cout << shortestTime;
	return 0;
}

ll getTime(int i) // given position of speaker
{
	ll currentTime = 0;
	ll walk;
	// Iterate through every person
	for (int j = 1; j <= n; j++)
	{
		p = people[j][0];
		w = people[j][1];
		d = people[j][2];
		walk = abs(p - i) - d;
		if (walk > 0) currentTime += walk*w;
	}
	return currentTime;
}