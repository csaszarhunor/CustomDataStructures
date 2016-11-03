package collection.set;

import java.util.HashMap;
import java.util.Iterator;

/**
 * This is the simplified version of java.util.HashSet,
 * borrowing only the very fundamental methods from it.
 * 
 * Properties:
 * 	- can't contain duplicates
 * 	- can contain null
 * 	- elements aren't indexed
 * 	- elements can be reached through iterator
 */
public class CustomHashSet<E> {

	private HashMap<E, Object> map;
	// Dummy value to associate with an Object in the backing Map
    private static final Object PRESENT = new Object();
	
    public CustomHashSet() {
		map = new HashMap<>();
	}
    
	public int size() {
		return map.size();
	}
	
	public void add(E item){
		map.put(item, PRESENT);
	}
	
	public void remove(Object obj){
		map.remove(obj);
	}
	
	public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

	public void clear(){
		map.clear();
	}
	
	public boolean contains(Object o){
		return map.containsKey(o);
	}
	
	public boolean isEmpty(){
		return map.isEmpty();
	}
	
	@Override
	public String toString() {
		return map.keySet().toString();
	}
}
