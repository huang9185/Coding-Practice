#include <iostream>
#include <vector>
#include <string>

#define mp make_pair
#define pb push_back
#define ll long long
#define f(i, a, b) for(int i = a; i < b; i++)

using namespace std;

bool input[2][200001];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int c; cin >> c;
	int sum = 0;
	f(i, 1, c + 1)
	{
		cin >> input[0][i];
		if (input[0][i] == 1) sum += 3;
	}
	f(i, 1, c + 1)
	{
		cin >> input[1][i];
		if (input[1][i] == 1) sum += 3;
	}

	// if odd and first level, check down and right
	// if second level, check right
	// if even, check right
	// if second level, check right
	// if last column, check down
	for (int i = 1; i < c + 1; i++)
	{
		bool first = input[0][i];
		bool second = input[1][i];

		if (i % 2 == 0)
		{
			if (i == c) {}
			else
			{
				if (first)
				{
					if (input[0][i + 1]) sum -= 2;
				}
				if (second)
				{
					if (input[1][i + 1]) sum -= 2;
				}
			}
		}
		else
		{
			if (i == c)
			{
				if (first && second) sum -= 2;
		}
			else
			{
				if (first)
				{
					if (second) sum -= 2;
					if (input[0][i + 1]) sum -= 2;
				}
				if (second)
				{
					if (input[1][i + 1]) sum -= 2;
				}
			}
		}
	}
	cout << sum << "\n";

	return 0;
}