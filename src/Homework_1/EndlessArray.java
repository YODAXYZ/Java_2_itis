package Homework_1;

public class EndlessArray<T> {

    private final int BASE_CAPACITY = 10;
    private final float ARRAY_EXPANSION = 1.5f; // The field sets the degree of array increase
    private T[] arr;
    private int elementCount; //Field control the count of array elements

    public EndlessArray() {
        arr = (T[]) new Object[BASE_CAPACITY];
        elementCount = 0;
    }

    /**Constructor - creating a new object with specific values
     * @param length the length of array*/
    public EndlessArray(int length) {
        arr = (T[]) new Object[length];
        elementCount = 0;
    }

    /**The function adds a new number to the end of the array
     * @param num specific element*/
    public void add(T num) {
        if (arr.length == elementCount) arr = positiveArrayResize();
        arr[elementCount] = num;
        elementCount++;
    }

    /**The function removes a number from an array at a specific index
     * @param index index of element*/
    public void remove(int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || index >= elementCount) throw new ArrayIndexOutOfBoundsException();
        arr = negativeArrayResize(index);
        elementCount--;
    }

    /**The function gets specific number from array
     * @return returns an element at a specific index*/
    public T get(int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || index >= elementCount) throw new ArrayIndexOutOfBoundsException();
        return arr[index];
    }

    /**The function gets the value of the field {@link EndlessArray#elementCount}
     * @return return the dummy size of the array that the user expects to see*/
    public int size() {
        return elementCount;
    }

    /**The function gets full size of array
     *  @return return the real size of the array*/
    public int capacity() {
        return arr.length;
    }

    /**The function gets index of specific number
     * @return return the first index of a specific element. If there is no such element, then returns -1*/
    public int indexOf(T num) {
        for (int i = 0; i < size(); i++) {
            if (num == arr[i]) return i;
        }
        return -1;
    }

    /**The function gets last index of specific number
     * @return return the last index of a specific element. If there is no such element, then returns -1*/
    public int lastIndexOf(T num){
        for (int i = size() - 1; i >= 0; i--) {
            if (num == arr[i]) return i;
        }
        return -1;
    }

    /**The function checks if specific number contains in array
     * @return return true if specific element contain in array, else return false */
    public boolean contains(T num) {
        return indexOf(num) >= 0;
    }

    /**The function gets the field {@link EndlessArray#arr}
     * @return return array*/
    public T[] getArray(){
        T[] returnArray = (T[]) new Object[size()];
        System.arraycopy(arr, 0, returnArray, 0, size());
        return returnArray;
    }

    /**The private function expands the array
     * @return new extended array*/
    private T[] positiveArrayResize() {
        T[] returnArray = (T[]) new Object[(int)(arr.length * ARRAY_EXPANSION)];
        System.arraycopy(arr, 0, returnArray, 0, size());
        return returnArray;
    }

    /**The private function deletes number at the specific index
     * @return new truncated array without specific element*/
    private T[] negativeArrayResize(int index) {
        T[] returnArray = (T[]) new Object[capacity() - 1];
        System.arraycopy(arr, 0, returnArray, 0, index);
        System.arraycopy(arr, size() - (index - 1), returnArray, size() - index, size() - (index - 1));
        return returnArray;
    }
}

