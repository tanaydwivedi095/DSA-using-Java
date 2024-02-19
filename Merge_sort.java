public class Merge_sort {
    public static void main(String args[]){
        int[] arr = new int[]{6, 3, 9, 5, 2, 8, -2};
        mergeSort(arr, 0, arr.length-1);
        printArr(arr);
    }
    public static void printArr(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void mergeSort(int[] arr, int si, int ei){
        if (si>=ei){return;}
        int mid = (si+ei)/2;
        mergeSort(arr, si, mid); // left part of array
        mergeSort(arr, mid+1, ei); // right part of array
        merge(arr, si, mid, ei);
    }
    public static void merge(int[] arr, int si, int mid, int ei){
        int[] temp = new int[ei-si+1];
        int i=si; // iterator for left part
        int j=mid+1; // iterator for right part
        int k=0; // iterator for temp arr
        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k] = arr[i];
                i++;
                k++;
            }
            else{
                temp[k] = arr[j];
                j++;
                k++;
            }
        }
        while(i<=mid){
            temp[k] = arr[i];
            i++;
            k++;
        }
        while(j<=ei){
            temp[k] = arr[j];
            j++;
            k++;
        }
        for(k=0, i=si; k<temp.length; k++, i++){
            arr[i] = temp[k];
        }
    }
}
