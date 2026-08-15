class Solution {
    public int[] replaceElements(int[] arr) {
        int max=0;
        int n = arr.length;
        int arr1[] = new int[n];
        arr1[n-1] = -1;
        for(int i = 0; i<n-1; i++)
        {
            max = arr[i+1];
            for(int j = i+1; j<n; j++)
            {
                if(arr[j] > max)
                    max = arr[j];
            }
            arr1[i] = max;
        }
        return arr1;
    }
}