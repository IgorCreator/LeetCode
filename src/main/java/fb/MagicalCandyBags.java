package fb;

import java.util.*;

/*
Magical Candy Bags
You have N bags of candy. The ith bag contains arr[i] pieces of candy, and each of the bags is magical!
It takes you 1 minute to eat all of the pieces of candy in a bag (irrespective of how many pieces of candy are inside),
and as soon as you finish, the bag mysteriously refills. If there were x pieces of candy in the bag at the beginning
of the minute, then after you've finished you'll find that floor(x/2) pieces are now inside.
You have k minutes to eat as much candy as possible. How many pieces of candy can you eat?
* */

class MagicalCandyBags {

    int maxCandies(int[] arr, int k) { //O(n + k*log(n))
        // Write your code here
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i: arr){ ////nlog(n)
            queue.add(i);
        }

        int ateCandy = 0;
        for(int j = k; j > 0; j--){ // //klog(k);
            if(!queue.isEmpty()) {
                int biggestBag = queue.poll();
                ateCandy += biggestBag;
                queue.add((int) Math.floor(biggestBag / 2));
            } else
                break;
        }

        return ateCandy;
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;
    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }

    public void run() {
        int n_1 = 5, k_1 = 3;
        int[] arr_1 = {2, 1, 7, 4, 2};
        int expected_1 = 14;
        int output_1 = maxCandies(arr_1, k_1);
        check(expected_1, output_1);

        int n_2 = 9, k_2 = 3;
        int[] arr_2 = {19, 78, 76, 72, 48, 8, 24, 74, 29};
        int expected_2 = 228;
        int output_2 = maxCandies(arr_2, k_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new MagicalCandyBags().run();
    }
}
