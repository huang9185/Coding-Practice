#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <set>
#define mp make_pair
#define pb push_back
#define pi pair<int, int> // current station, time length

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	int n, w, d, tmp, x, y;
	cin >> n >> w >> d;

	int wdist[n+1]; // adjacency list
	int tdist[n+1];
	vector<int> al[n + 1]; // walk stations from -> to
	
	// Prepare the walking distance adjacency list
	for (int i = 1; i < w; i++) wdist[i] = 1e9;
	wdist[0] = 0;
	wdist[n] = 0;

	// Prepare the graph of walking stations
	for (int i = 0; i < w; i++)
	{
		int from, to;
		cin >> from >> to;
		al[to].pb(from);
	}

	// Complete the adjacency list
	queue<int> q;
	bool visited[w + 1];
	memset(visited, 0, sizeof visited);

	visited[w] = 1;
	q.push(w); // base case

	while (!q.empty())
	{
		int cur = q.front();
		q.pop();
		for (const int next : al[cur])
		{
			if (!visited[next]) wdist[next] = wdist[cur] + 1;
			visited[next] = true;
			q.push(next);
		}
	}

	// Prepare the train adjacency list
	int subwayline[n + 1]; // adjacency  = index -1

	// Sorted set with non unique value
	multiset cdist[n + 1]; // cognitive distance

	for (int i = 1; i <= n; i++)
	{
		cin >> subwayline[i];
		cdist.insert(i-1+wdist[subwayline[i]]);
	}

	// Process the daily swap
	for (int i = 1; i <= d; i++)
	{
		int station1, station2;
		cin >> station1 >> station2;

		// cognitive distance = distance on train + distance walked
		int pastDistance1 = station1 - 1 + wdist[subwayline[station1]];
		int pastDistance2 = station2 - 1 + wdist[subwayline[station2]];

		// remove one from the multiset
		cdist.erase(cdist.find(pastDistance1));
		cdist.erase(cdist.find(pastDistance2));

		// swap per day
		swap(subwayline[station1], subwayline[station2]);

		cdist.insert(station1 - 1 + wdist[subwayline[station1]]);
		cdist.insert(station2 - 1 + wdist[subwayline[station2]]);

		cout << *cdist.begin() << "\n"; // dereference the smallest element pointer of the multiset
	}
	return 0;
}