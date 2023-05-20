#include <iostream>
#include <vector>
#include <string>

#define mp make_pair
#define pb push_back
#define ll long long
#define f(i, a, b) for(int i = a; i < b; i++)

using namespace std;

ll input[5001];
ll odds[5001];
ll even[5001];
ll output[5001];
int n;
ll smallest; // Keep track of the smallest value of a fixed length

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin >> n;

	for (int i = 1; i <= n; i++) cin >> input[i];
	// For odd number as length
	for (int l = 1; l <= n; l += 2)
	{
		smallest = 200001;
		// Generate the absolute value and assign them to the mid point
		for (int low = 1; low + l - 1 <= n; low++)
		{
			odds[low + l / 2] += abs(input[low] - input[low + l - 1]);
			smallest = min(smallest, odds[low + l / 2]);
		}
		output[l] = smallest;
	}

	// For even numbers
	for (int l = 2; l <= n; l += 2)
	{
		smallest = 200001;
		for (int low = 1; low + l - 1 <= n; low++)
		{
			even[low + l / 2] += abs(input[low] - input[low + l - 1]);
			smallest = min(smallest, even[low + l / 2]);
		}
		output[l] = smallest;
	}
	for (int i = 1; i <= n; i++) cout << output[i] << " ";
	return 0;
}