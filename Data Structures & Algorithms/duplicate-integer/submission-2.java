class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
                continue;
            }
            map.put(num, 1);
        }

        for(int value: map.values()){
            if(value>=2){
                return true;
            }
        }
        return false;
    }
}