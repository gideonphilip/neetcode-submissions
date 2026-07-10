class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> store = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (store.containsKey(complement)) {
                return new int[] { store.get(complement), i };
            }
            store.put(nums[i], i);
        }

        return new int[] { -1, -1 };
    }
}
