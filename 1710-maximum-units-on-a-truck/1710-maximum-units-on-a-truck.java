class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int units = 0;
        for(int[] box : boxTypes){
            if (truckSize <= 0) break;
            int count = box[0];
            int val = box[1];
            int take = Math.min(truckSize, count);
            units += take * val;
            truckSize -= take;
        }
        return units;
    }
}