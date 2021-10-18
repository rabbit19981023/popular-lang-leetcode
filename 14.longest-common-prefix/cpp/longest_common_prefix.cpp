#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if (! isValid(strs)) {
            return "";
        }
        
        int low = 1;
        int high = getMinLen(strs);
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (isCommonPrefix(mid, strs)) {
                low = mid + 1;
                continue;
            }

            high = mid - 1;
        }

        mid = (low + high) / 2;
        return strs[0].substr(0, mid);
    };

    bool isValid(vector<string>& strs) {
        return ! ((typeid(strs) != typeid(vector<string>)) || (strs.size() == 0));
    };

    int getMinLen(vector<string>& strs) {
        int minLen = strs[0].length();

        for (int i = 1; i < strs.size(); i++) {
            if (strs[i].length() < minLen) {
                minLen = strs[i].length();
            }
        }

        return minLen;
    };

    bool isCommonPrefix(int mid, vector<string>& strs) {
        string prefix = strs[0].substr(0, mid);

        for (int i = 1; i < strs.size(); i++) {
            if (! startsWith(strs[i], prefix, 0)) {
                return false;
            }
        }

        return true;
    };

    bool startsWith(string str, string match, int pos) {
        if (str.find(match) == pos) {
            return true;
        }

        return false;
    };
};

class Test {
public:
    vector<string> strs;
    Test(vector<string> s) { strs = s; }
};

int main(void) {
    /* 
     * Test Case 
     */
    // creates a pointer refers to the class instance.
    Test* test_ptr_01 = new Test({ "flower", "flow", "flight" });
    Test* test_ptr_02 = new Test({ "dog", "racecar", "car" });

    Solution solution;

    // use `->` to find the member whom test_ptr points to.
    string result_01 = solution.longestCommonPrefix(test_ptr_01->strs);
    string result_02 = solution.longestCommonPrefix(test_ptr_02->strs);

    cout << "" << endl;
    cout << "Expected: 'fl'\n" << "Output: " << result_01 << endl;
    cout << "" << endl;

    cout << "Expected: ''\n" << "Output: " << result_02 << endl;
    cout << "" << endl;

    return 0;
};
