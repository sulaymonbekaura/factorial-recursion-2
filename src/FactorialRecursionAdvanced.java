public class FactorialRecursionAdvanced {

    // Tower of Hanoi
    static int hanoiMoves = 0;
    static void hanoi(int n, char from, char to, char aux) {
        if (n == 1) { System.out.printf("  Move disk 1 from %c → %c%n", from, to); hanoiMoves++; return; }
        hanoi(n-1, from, aux, to);
        System.out.printf("  Move disk %d from %c → %c%n", n, from, to); hanoiMoves++;
        hanoi(n-1, aux, to, from);
    }

    // Power set (all subsets) using recursion
    static void printSubsets(int[] set, int idx, java.util.List<Integer> current) {
        System.out.println(current);
        for (int i = idx; i < set.length; i++) {
            current.add(set[i]);
            printSubsets(set, i+1, current);
            current.remove(current.size()-1);
        }
    }

    // GCD recursively
    static int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
    static int lcm(int a, int b) { return a / gcd(a,b) * b; }

    // Recursive binary search
    static int binarySearch(int[] arr, int target, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = (lo+hi)/2;
        if (arr[mid] == target) return mid;
        return arr[mid] > target
            ? binarySearch(arr, target, lo, mid-1)
            : binarySearch(arr, target, mid+1, hi);
    }

    public static void main(String[] args) {
        System.out.println("=== Tower of Hanoi (3 disks) ===");
        hanoi(3, 'A', 'C', 'B');
        System.out.println("Moves: " + hanoiMoves);

        System.out.println("\n=== Power Set of {1,2,3} ===");
        printSubsets(new int[]{1,2,3}, 0, new java.util.ArrayList<>());

        System.out.println("\n=== GCD & LCM ===");
        int[][] pairs = {{48,18},{100,75},{7,13},{252,105}};
        for (int[] p : pairs)
            System.out.printf("GCD(%d,%d)=%d  LCM=%d%n", p[0],p[1], gcd(p[0],p[1]), lcm(p[0],p[1]));

        System.out.println("\n=== Recursive Binary Search ===");
        int[] sorted = {3,7,12,18,25,33,47,58,64,72};
        for (int t : new int[]{25,64,1,72})
            System.out.printf("Search %d → index %d%n", t, binarySearch(sorted,t,0,sorted.length-1));
    }
}
