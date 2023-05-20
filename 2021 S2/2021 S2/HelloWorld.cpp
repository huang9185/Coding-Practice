
#include <iostream>
bool row[5000005];
bool col[5000005] ;
// false: black
// true: gold
using namespace std;
int main()
{
	int m, n; cin >> m >> n;
	int k, x;
	cin >> k;
	for (int i = 0; i < k; i++)
	{
		char letter; cin >> letter >> x;
		if (letter == 'R'){
			if (row[x] == false) row[x] = true;
			else row[x] = false;
		}
		else
		{
			if (col[x] == false) col[x] = true;
			else col[x] = false;
		}
	}
	int area = 0;
	for(int i = 1; i <=m; i++)
		for (int j = 1; j <= n; j++)
		{
			if (row[i] == false && col[j] == true) area++;
			else if (row[i] == true && col[j] == false) area++;
		}
	cout << area;

	return 0;
}