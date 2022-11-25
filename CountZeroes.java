/*
Write a program which gives all permutation of acharacters of a given string.
For example String passed is ab

Sol2 :-2

ab
Ba


String is abc.

Sol :-  6

abc
Bac
cab  acb cba bca
 */


public class CountZeroes {
    static int count = 0;

    public static void main(String[] args) {
        System.out.println(countFn(3021004));
        System.out.println(countFn(321004));
    }

    // approach 1
    static int countFn(int num) {
        int rem = num%10;
        if(rem == num) {
            return count;
        }
        if(rem == 0) {
            return count + countFn(num/10) + 1;
        }
        return countFn(num/10);
    }

    // approach 2
    static int countFn(int num, int count) {
        if(num == 0) {
            return count;
        }
        int rem = num%10;
        if(rem == 0) {
            return countFn(num/10, count+1);
        }
        return countFn(num/10, count);
    }
}
