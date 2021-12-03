class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> l= nums1.length>nums2.length
                ? Arrays.stream(nums1).boxed().collect(Collectors.toList())
                :Arrays.stream(nums2).boxed().collect(Collectors.toList());

        List<Integer> result=new ArrayList<>();
        if(nums1.length<=nums2.length){
            for(int i=0;i<nums1.length;i++){
                if(l.contains(nums1[i])){
                    result.add(nums1[i]);
                    l.remove(l.indexOf(nums1[i]));
                }
            }
        }else{
            for(int i=0;i<nums2.length;i++){
                if(l.contains(nums2[i])) {
                    result.add(nums2[i]);
                    l.remove(l.indexOf(nums2[i]));
                }
            }
        }

        return result.stream().mapToInt(x->x).toArray();
    }
}