package collection.list;

import java.util.Arrays;

/**
 * This is a simple list data structure based on java.util.List interface,
 * but borrowing and implementing only the very fundamental methods.
 * 
 * Properties:
 * 	- keeps the order of insertion
 * 	- elements are indexed
 * 	- can contain duplicates
 * 	- can contain nulls
 */
public class CustomArrayList<E> {

	private final int DEFAULT_SIZE = 10;
	private Object[] container;
	private int size = 0;
	
	public CustomArrayList() {
		container = new Object[DEFAULT_SIZE];
	}
	
	public CustomArrayList(int size) {
		container = new Object[size];
	}

	public int size() {
		return size;
	}

	public E get(int index){
		rangeCheck(index);
		@SuppressWarnings("unchecked")
		E result = (E) container[index];
		return result;
	}
	
	public void add(E item){
		ensureContainerCapacity(size + 1);
		container[size] = item;
		size++;
	}
	
	public void insert(E item, int index){
		rangeCheck(index);
		ensureContainerCapacity(size + 1);
		Object[] newContainer = new Object[size + 1];
		System.arraycopy(container, 0, newContainer, 0, index);
		System.arraycopy(container, index, newContainer, index + 1, size - index);
		newContainer[index] = item;
		container = newContainer;
		size++;
	}
	
	public void remove(int index){
		rangeCheck(index);
		Object[] newElements = new Object[size - 1];
		System.arraycopy(container, 0, newElements, 0, index);
		System.arraycopy(container, index + 1, newElements, index, size - index - 1);
		container = newElements;
		size--;
	}
	
	public int indexOf(Object item){
		if (item == null){
			for (int i = 0; i < container.length; i++) {
				if (container[i] == null) return i;
			}
			
		}
		else {
			for (int i = 0; i < container.length; i++) {
				if (container[i].equals(item)) return i;
			}
		}
		return -1;
	}
	
	@Override
	public String toString() {
		if(size == 0) return "[ ]";
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for (int i = 0; i < size; i++) {
			Arrays.toString(container);
			sb.append(container[i].toString());
			sb.append((i == size - 1) ? "]" : ", ");
		}
		return sb.toString();
	}
	
	public void clear(){
		for (int i = 0; i < container.length; i++) {
			container[i] = null;
		}
		size = 0;
	}
	
	public boolean contains(Object o){
		return indexOf(o) >= 0;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	private void ensureContainerCapacity(int minLength){
		if(size < minLength){
			Object[] newContainer = new Object[size + DEFAULT_SIZE];
			System.arraycopy(container, 0, newContainer, 0, size);
			container = newContainer;
		}
	}
	
	private void rangeCheck(int index){
		if(index < 0 && index >= container.length){
			throw new IndexOutOfBoundsException(index + " is not a valid index.");
		}
	}
}
