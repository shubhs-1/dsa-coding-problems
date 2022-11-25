public class FibonacciNos {
    public static void main(String[] args) {
        int number = 9;
        System.out.println(fibonacciSeries(number));
    }

    public static int fibonacciSeries(int number) {
        if(number == 1) {
            return 0;
        }

        if(number == 2) {
            return 1;
        }

        return fibonacciSeries(number - 1) + fibonacciSeries(number - 2);
    }
}

// 0 1 1 2 3 5 8 13 21

// arr - [1,0,0,2,3,7,5]
// [1,1,1,3,3,4,3,2,4,2]

// [0,2]
