class Solution {
    public int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[nums[0]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int secondSlow = 0;

        while (secondSlow != slow) {
            slow = nums[slow];
            secondSlow = nums[secondSlow];
        }

        return secondSlow;                
    }
}

// 3 1 3 4 2
// 0 1 2 3 4

// 0 3 4 2 3 4 2 
//       s
//         f 
// 1 2 3 2 2
// 0 1 2 3 4

// 0 1 2 3 2 3 2 
//     s 
//         f 

// s = 0
// f = 0

// s = 1
// f = 3

// s = 3
// f = 