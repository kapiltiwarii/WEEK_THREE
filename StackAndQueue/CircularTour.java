public class CircularTour {
    public static int findStartingPoint(int[] petrol, int[] distance) {
        int n = petrol.length;
        int totalSurplus = 0;  // Total petrol - total distance
        int currentSurplus = 0; // Surplus at the current start point
        int startIndex = 0;     // Potential start point

        for (int i = 0; i < n; i++) {
            totalSurplus += petrol[i] - distance[i];
            currentSurplus += petrol[i] - distance[i];

            // If surplus goes negative, reset the starting index
            if (currentSurplus < 0) {
                startIndex = i + 1; // Try the next station
                currentSurplus = 0; // Reset surplus
            }
        }

        // If total surplus is negative, no solution exists
        return (totalSurplus >= 0) ? startIndex : -1;
    }

    // Test the function
    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int start = findStartingPoint(petrol, distance);
        System.out.println(start); // Output: 1
    }
}
