class Solution {
    public int minimumOperations(int[] nums) {
       List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        int operations = 0;

        while (hasDuplicates(list)) {
            // Remove the first 3 elements or however many are left
            int removeCount = Math.min(3, list.size());
            for (int i = 0; i < removeCount; i++) {
                list.remove(0);
            }
            operations++;
        }

        return operations;
    }

    // Helper method to check for duplicates
    private boolean hasDuplicates(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        return set.size() < list.size();
    }

    }
