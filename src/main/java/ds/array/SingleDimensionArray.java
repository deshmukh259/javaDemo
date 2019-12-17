package ds.array;

public class SingleDimensionArray {
    int arr[] = null;

    //Constructor
    public SingleDimensionArray(int sizeOfArray) {
        arr = new int[sizeOfArray]; // O(1)

    }

    // Print the array
    public void traverseArray() {

        try {
            for (int i = 0; arr.length > i; i++)
                System.out.println(arr[i]);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    //Insert value in the Array
    public void insert(int location, int valueToBeInserted) {
        arr[location] = valueToBeInserted; //N(1)

    }

    // Access a particular element of an array
    public void accessingCell(int cellNumber) {
        System.out.println(arr[cellNumber]); // N(1)
    }

    //Search for an element in the given Array
    public void searchInAnArray(int valueToSearch) {
        for (int i = 0; arr.length > i; i++) { //o(n)
            if (valueToSearch == arr[i]) {
                System.out.println("found at index :" + i);
                return;
            }
        }
		System.out.println("not found");
	}

    //Delete value from given Array
    public void deleteValueFromArray(int deleteValueFromThisCell) {
        arr[deleteValueFromThisCell] = -1;
    }

    //Delete the entire Array
    public void deleteThisArray() {
        arr = null;
    }

    public static void main(String[] args) {
        SingleDimensionArray s = new SingleDimensionArray(10);
        s.traverseArray();
        s.insert(5, 55);
        s.insert(6, 55);
        s.insert(7, 55);
        s.insert(8, 55);
        s.traverseArray();
        s.deleteValueFromArray(5);
        s.deleteValueFromArray(7);
        s.deleteValueFromArray(8);
        s.traverseArray();
        s.accessingCell(5);
        s.searchInAnArray(55);
        s.deleteThisArray();
        s.traverseArray();

    }
}//end of class
