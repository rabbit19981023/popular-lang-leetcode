#include <iostream>
#include <vector>
#include <map>

using namespace std;

class TwoSum {
public:
  vector<int> _do(vector<int> nums, int target) {
    map<int, int> m;

    for (int i = 0; i < nums.size(); i++) {
      int current = nums[i];
      int diff = target - current;

      if (m.find(current) != m.end()) {
        return { m[current], i };
      }

      m.insert(pair<int, int>(diff, i));
    }

    return { };
  }
};
