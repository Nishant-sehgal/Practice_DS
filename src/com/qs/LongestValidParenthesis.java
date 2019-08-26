package com.qs;

public class LongestValidParenthesis {

	public static void main(String[] args) {
		// longestValidParentheses("))((");
		//System.out.println(search(new int[] {5, 1,3 }, 0));
		System.out.println(searchRange(new int[] {1,2,3,4 },4));
	}

    public static int[] searchRange(int[] nums, int target) {
        
        if(null == nums || nums.length==0){
            return new int[]{-1,-1};
        }
        
        int start = 0,end = nums.length-1;
        int firstIdx = -1,secondIdx  =-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]==target && mid==0){
            	firstIdx = mid;
            	break;
            }
            if(mid>0 && nums[mid]==target && nums[mid-1]!=target){
                firstIdx = mid;
                break;
            }
            
            if(nums[mid]>=target){
                end = mid -1;
            }else{
                start = mid+1;
            }
        }
        start = 0;end = nums.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]==target && mid==nums.length-1){
            	secondIdx = mid;
            	break;
            }
            if(mid < nums.length-1 && nums[mid]==target && nums[mid+1]!=target){
            	secondIdx = mid;
                break;
            }
            
            if(nums[mid]<=target){
            	start = mid+1;
            }else{
            	end = mid -1;
            }
        }
        return new int[]{firstIdx,secondIdx};
    }
	public static int search(int[] nums, int target) {
		int index = -1;
		if (null == nums || nums.length == 0) {
			return index;
		}

		int start = 0, end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;

			if (nums[mid] == target) {
				return mid;
			}

			if (nums[mid] >= nums[start]) {
				if (target >= nums[start] && target < nums[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				if(target>nums[mid] && target<=nums[end]){
					start = mid + 1;
				}else{
					end = mid - 1;
				}				
			}
		}
		return index;
	}

	public static int longestValidParentheses(String s) {
		int left = 0, right = 0, maxlength = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}
			if (left == right) {
				maxlength = Math.max(maxlength, 2 * right);
			} else if (right >= left) {
				left = right = 0;
			}
		}
		left = right = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}
			if (left == right) {
				maxlength = Math.max(maxlength, 2 * left);
			} else if (left >= right) {
				left = right = 0;
			}
		}
		return maxlength;
	}
}
