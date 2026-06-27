#include <unordered_map>
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int,int> position;
        for (int i=0;i<nums.size();i++){
            int complement = target - nums[i];

            if(position.find(complement) != position.end()){
                return {position[complement], i};
            }
            position[nums[i]] = i;

        }
    }
};
