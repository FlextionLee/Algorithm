package sorted;

import java.util.ArrayList;
import java.util.Date;

public class Sort {
    private int[] arr;
    public Sort(int[] arr){
        this.arr = arr;
    }

    public void print(){
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]+" ");
        }
        System.out.println();
    }
    public void swap(int cur, int next){
        int tmp = arr[cur];
        arr[cur] = arr[next];
        arr[next] = tmp;
    }

    /**
     * 선택 정렬
     */
    public void selecttionSort(){
        for(int i=0; i<arr.length; i++){
            int min = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[min] > arr[j]){
                    min = j;
                }
            }
            swap(i,min);
        }
    }
    /**
     * 삽입 정렬
     */
    public void insertionSort(){
        for(int i=1; i<arr.length; i++){
            int tmp = arr[i];
            int j = i - 1;
            while(j>=0 && arr[j] > tmp){
               arr[j+1] = arr[j];
               j--;
            }
            arr[j+1] = tmp;
        }
    }
    /**
     * 버블 정렬
     */
    public void bubbleSort(){
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i] > arr[j]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
    public void MergeSort(){}
    public void quickSort(){}

    public static void main(String[] args) {
        Sort sort = new Sort(new int[] {9,2,3,4,61,3,4,5,8});
        sort.bubbleSort();
        sort.print();
    }
}
