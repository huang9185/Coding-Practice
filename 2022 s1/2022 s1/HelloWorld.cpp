#include <iostream>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n; cin >> n;
	int count = 0; // to store # combos

	while (n >= 0)
	{
		if (n % 4 == 0) count++;
		n -= 5;
	}
	cout << count;
	return 0;
}