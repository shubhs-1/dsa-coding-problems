public class PrimeNos {
    public static void main(String[] args) {
        int number = 100;
        printPrimeNos(number);
    }

    public static boolean isPrime(int number) {
        if(number % 2 == 0) {
            return false;
        }

        for(int i = 2; i <= number/2 + 1; i++) {
            if(number % 2 == 0) {
                return false;
            }

            if(number % i == 0) {
                return false;
            }
        }

        return true;
    }


    public static void printPrimeNos(int num) {
        int count = 0;
        int i = 2;
        while (count != num) {
            if(i == 2) {
                System.out.println(i);
                count++;
            }
            if(isPrime(i)) {
                System.out.println(i);
                count++;
            }
            i++;
        }
    }
}