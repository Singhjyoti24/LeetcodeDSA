class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] locations = new int[1001];

        for (int[] trip : trips) {
            int passengers = trip[0];
            int start = trip[1];
            int end = trip[2];
            
            locations[start] += passengers;
            locations[end] -= passengers;
        }

        int currPassengers = 0;
        for (int numPassengers : locations) {
            currPassengers += numPassengers;

            if (currPassengers > capacity) {
                return false;
            }
        }

        return true;
    }
}