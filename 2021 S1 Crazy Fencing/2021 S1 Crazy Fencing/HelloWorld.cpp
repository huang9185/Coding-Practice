#include <iostream>
#include <vector>

using namespace std;
int h[100001];
int w[100001];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	
	int n; cin >> n;

	for (int i = 0; i < n + 1; i++) cin >> h[i];
	for (int i = 0; i < n; i++) cin >> w[i];

	int area = 0;
	for (int i = 0; i < n; i++)
	{
		area += (h[i] + h[i + 1]) * w[i];
	}
	if (area / 2 * 2 != area) cout << area/2 << ".5";
	else cout << area/2;
	return 0;
}