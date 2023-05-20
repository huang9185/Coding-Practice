#include <iostream>
#include <vector>
#include <string>
#include <map>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	int x, y, g; cin >> x;

	// Must be in the same group
	vector<string> same;
	for (int i = 0; i < 2 * x; i++) { string s; cin >> s; same.push_back(s); }

	// Must be in the different groups
	cin >> y;
	vector<string> different;
	for (int i = 0; i < 2 * y; i++) { string s2; cin >> s2; different.push_back(s2); }

	map<string, int> dts; // {col}

	cin >> g;
	string line = "";
	string tmp = "";
	cin.ignore();
	for (int i = 0; i < g; ++i)
	{
		getline(cin, line);
		tmp = "";
		for (char j : line)
		{
			if (j == ' ')
			{
				dts.insert(pair<string, int>(tmp, i));
				tmp = "";
			}
			else tmp += j;
		}
		dts.insert(pair<string, int>(tmp, i));

	}

	int count = 0;
	for (int i = 0; i < x * 2; i += 2)
	{
		string s4 = same[i];
		int pos = dts.find(s4)->second;
		string s3 = same[i + 1];
		int pos1 = dts.find(s3)->second;

		if (pos != pos1) count++;
	}

	for (int i = 0; i < 2 * y; i += 2)
	{
		string s4 = different[i];
		string s3 = different[i + 1];
		int pos = dts.find(s4)->second;
		int pos1 = dts.find(s3)->second;

		if (pos == pos1) count++;
	}

	cout << count;

	return 0;
}

