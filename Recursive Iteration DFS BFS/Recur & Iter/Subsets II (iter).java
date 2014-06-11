public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        if (num == null) return null;
     
        Arrays.sort(num);
     
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();
        //add empty set
        result.add(new ArrayList<Integer>());
          
        for (int i = 0; i < num.length; i++) {
            //get existing sets
            if (i == 0 || num[i] != num[i - 1]) {
                prev = new ArrayList<ArrayList<Integer>>();
                for (int j = 0; j < result.size(); j++) {
                    prev.add(new ArrayList<Integer>(result.get(j)));
                }
            }
     
            //add current number to each element of the set
            for (ArrayList<Integer> temp : prev) {
                temp.add(num[i]);
            }
     
            //add all set created in this iteration
            for (ArrayList<Integer> temp : prev) {
                result.add(new ArrayList<Integer>(temp));
            }
        }
     

        return result;
    }
}