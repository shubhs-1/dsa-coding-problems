import java.util.Arrays;

public class SortNos {
    public static void main(String[] args) {
        int arr[] = {0,1,1,1,0,1,1,1,0,0,0,1,1,1,0};
        System.out.println(Arrays.toString(sort(arr)));
    }

    public static int[] sort(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while(i < j) {
            if(arr[i] == 0 && arr[j] == 0) {
                i++;
                continue;
            } else if (arr[i] == 1 && arr[j] == 0) {
                swap(arr, i, j);
                i++;
                j--;
                continue;
            }
            j--;
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

// 0 0 1 1 0