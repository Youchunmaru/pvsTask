package Blatt03;

import java.util.HashMap;
/** 1.1 HashMapArray:
 * is a HashMap but can be used as an Array
 * @author Samuel Gröner
 * Blatt 03
 * Tut 03
 *
 * referncesheet -> {@link Blatt03}
 * */
public class HashMapArray<T> {

    /** 1.1 Field:
     * #hashMapArray creates a {@link HashMap},
     *                     K is the index and V the Object in the Array
     * */
    HashMap<Integer,T> hashMapArray = new HashMap<>();
    /** 1.1 Field:
     * #size size of the array
     * */
    int size;

    /** 1.1 Constructor:
     * does what a constructor does
     * @param size defines the size of the array
     * */
    HashMapArray(int size){
    this.size = size;
    }
    /** 1.1 add:
     * adds an element to the array
     * @param pos is the position of the add
     * @param element is the element to add
     * @throws IndexOutOfBoundsException if pos is < 0 or > size
     * */
    public void add(int pos,T element){

        if (pos < size && pos <= 0) {
            hashMapArray.put(pos, element);
        }else{
            throw new IndexOutOfBoundsException("Index" + pos + " out of bounds for length " + size);
        }
    }
    /** 1.1 get:
     * returns the value of a special position in the array
     * @param pos the position of the element
     * @throws IndexOutOfBoundsException if pos is < 0 or > size
     * @return the value of the array at the position pos
     * */
    public T get(int pos){
        if (pos < size && pos >= 0) {
            return hashMapArray.get(pos);
        }else{
            throw new IndexOutOfBoundsException("Index" + pos + " out of bounds for length " + size);
        }
    }
    /** 1.1 length:
     * returns the length of the array
     * @return the size of the array
     * */
    public int length(){
        return size;
    }

}
