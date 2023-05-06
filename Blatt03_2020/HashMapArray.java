package Blatt03_2020;

import java.util.HashMap;

public class HashMapArray<T> {

    HashMap<Integer, T> likeArray = new HashMap<Integer, T>();
    int size;

    /** defines the bounds of the array
     * @param size
     *
     * */
    public HashMapArray(int size){
        this.size = size;
    }
    /** adds an Element at an specified Index
     * @param pos is the index
     * @param element is the element
     * */
    void addElementAt(int pos, T element){

        if (pos >= 0 && pos < size) {

            likeArray.put(pos, element);
        }else{
            throw new IndexOutOfBoundsException("Index " + pos + " is out of bounds for length " + size);
        }
    }
    /** gets the Element of an specified Index
     * @param pos is the index
     * @return value at the index
     *
     * */
    T getElement(int pos){

        if (pos >= 0 && pos < size) {

            return likeArray.get(pos);
        }else{
            throw new IndexOutOfBoundsException("Index " + pos + " is out of bounds for length " + size);
        }
    }
    /** gets the length of the array
     * @return int length of the array
     *
     * */
    int getLength(){
        return size;
    }
}
