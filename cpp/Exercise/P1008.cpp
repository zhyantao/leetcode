#include <iostream>
#include <vector>
#include <cstring>

using namespace std;

int convert2int(vector<int> &path) {
    int ans = 0;
    int base = 1;
    for (int i = 8; i >= 0; i--) {
        ans += path[i] * base;
        base *= 10;
    }
    return ans;
}

void permutation(vector<int> &nums, int depth, vector<bool> used, vector<int> &path) {
    if (depth == 9) {
        int num = convert2int(path);
        if (num % 6 == 0) {
            cout << num / 6 << " " << num / 3 << " " << num / 2 << endl;
        }
        return;
    }

    for (int i = 0; i < 9; i++) {
        if (used[i]) {
            continue;
        }

        if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
            continue;
        }

        path.push_back(nums[i]);
        used[i] = true;

        permutation(nums, depth + 1, used, path);

        used[i] = false;
        path.pop_back();
    }
}

int main() {

    int a, b, c;
    for (a = 123; a <= 333; a++) {
        b = a * 2;
        c = a * 3;
        if ((a / 100 + a / 10 % 10 + a % 10 + b / 100 + b / 10 % 10 + b % 10 + c / 100 + c / 10 % 10 + c % 10 ==
             1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9)
            &&
            ((a / 100) * (a / 10 % 10) * (a % 10) * (b / 100) * (b / 10 % 10) * (b % 10) * (c / 100) * (c / 10 % 10) *
             (c % 10) == (1) * (2) * (3) * (4) * (5) * (6) * (7) * (8) * (9)))
            printf("%d %d %d\n", a, b, c);
    }

    return 0;
}