#include <iostream>
#include <vector>
#include <string>

#define mp make_pair
#define pb push_back
#define ll long long
#define f(i, a, b) for(int i = a; i < b; i++)

using namespace std;
int dts[2001][2001];
vector<int> pa;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n, m, r, c;
	cin >> n >> m >> r >> c;
	
	if ((n == r && m % 2 == 0 && c % 2 != 0) ||
		(m == c && n % 2 == 0 && r % 2 != 0))
	{
		cout << "IMPOSSIBLE";
		return 0;
	}

	char initial = 'a';
	// All palindroms in rows, no palindroms in cols
	if (n == r && c == 0)
	{
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= m; j++)
			{
				if (i > n / 2) dts[i][j] = static_cast<int>(initial+1);
				else dts[i][j] = static_cast<int>(initial);
			}
	}
	// All palidroms in cols, no palindroms in rows
	else if (m == c && r == 0)
	{
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= m; j++)
			{
				if (j < m / 2) dts[i][j] = static_cast<int>(initial+1);
				else dts[i][j] = static_cast<int>(initial);
			}
	}
	// All palindroms in rows, even columns and even cs
	else if (n == r && m % 2 == 0)
	{
		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= m; j++)
			{
				if (j <= c / 2 || m - j < c / 2) dts[i][j] = static_cast<int> ('b');
				else dts[i][j] = static_cast < int> (initial);
			}
		}
	}
	// All palindroms in rows, odd columns, and even cs
	else if (n == r && (m % 2) != 0 && c&2 == 0)
	{
		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= m; j++)
			{
				if (j <= c / 2 || m - j < c / 2) dts[i][j] = static_cast<int> ('b');
				else dts[i][j] = static_cast <int> (initial);
			}
		}
	}
	// All palindroms in rows, odd columns, and odd cs
	else if (n == r && m % 2 != 0 && c & 2 != 0)
	{
		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= m; j++)
			{
				if (j <= c / 2 || m - j < c / 2 || j == m/2+1) dts[i][j] = static_cast<int> ('b');
				else dts[i][j] = static_cast <int> (initial);
			}
		}
	}
	// All palindroms in cols, even rows and even rs
	else if (m == c && n % 2 == 0 && r%2 == 0)
	{
		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= m; j++)
			{
				if (i <= r / 2 || n-i < r / 2) dts[i][j] = static_cast<int> ('b');
				else dts[i][j] = static_cast <int> (initial);
			}
		}
	}
	// All palindroms in cols, odd rows and even rs
	else if (m == c && n % 2 != 0 && r & 2 == 0)
	{
		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= m; j++)
			{
				if (i <= r / 2 || n-i < r / 2) dts[i][j] = static_cast<int> ('b');
				else dts[i][j] = static_cast <int> (initial);
			}
		}
	}
	// All palindroms in cols, odd rows and odd rs
	else if (m == c && n % 2 != 0 && r & 2 == 0)
	{
		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= m; j++)
			{
				if (i <= r / 2 || n-i < r / 2 || i == n/2+1) dts[i][j] = static_cast<int> ('b');
				else dts[i][j] = static_cast <int> (initial);
			}
		}
	}

	// No palindroms in rows, not all palindroms in columns
	else if (r == 0 && c != m)
	{
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= m; j++)
			{
				if (j == m) dts[i][j] = static_cast<int>(initial + 2);
				else if (j > c && i == n) dts[i][j] = static_cast<int>('b');
				else dts[i][j] = static_cast<int>(initial);
			}
	}
	// No palindroms in columns, not all palindroms in rows
	else if (c == 0 && r != n)
	{
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= m; j++)
			{
				if (i <= r) dts[i][j] = static_cast<int>('b');
				else if (j <= m / 2) dts[i][j] = static_cast<int>(initial + 4);
				else dts[i][j] = static_cast<int>(initial);
			}
	}
	
	else
	{
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= m; j++)
			{
				if (i <= r || j <= c) dts[i][j] = static_cast<int>('b');
				else dts[i][j] = static_cast<int>(initial);
			}
	}

	

	// Output
	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= m; j++)
		{
			cout << static_cast<char>(dts[i][j]);
			if (j == m) cout << "\n";
		}
	return 0;
}
