package collection.stack;

import java.util.EmptyStackException;

/*
 * This is an example of Stack, which is a collection that keeps the order of insertion 
 * and the elements can be reached in a controlled manner.
 * 
 * Properties:
 * 	- keeps the order of insertion
 * 	- the item stored last gets out first (LIFO)
 * 	- can contain duplicates
 * 	- can contain nulls
 */
public class CustomStack<E> {

	private final int DEFAULT_SIZE = 10;
	private Object[] container;
	private int size = 0;
	private int cursor = 0;
	
	public CustomStack() {
		container = new Object[DEFAULT_SIZE];
	}
	
	public CustomStack(int size) {
		container = new Object[size];
	}

	public int size() {
		return size;
	}

	public E pop(){
		if(isEmpty()) throw new EmptyStackException();
		@SuppressWarnings("unchecked")
		E result = (E) container[cursor];
		container[cursor] = null;
		cursor--;
		size--;
		return result;
	}
	
	public void push(E item){
		ensureContainerCapacity(size + 1);
		container[cursor] = item;
		cursor++;
		size++;
	}
	
	public E peek(){
		@SuppressWarnings("unchecked")
		E item = (E) container[cursor];
		return item;
	}
	
	@Override
	public String toString() {
		if(size == 0) return "[ ]";
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for (int i = 0; i < size; i++) {
			String itemStr = (container[i] != null) ? container[i].toString() : null;
			sb.append(itemStr);
			sb.append((i == size - 1) ? "]" : ", ");
		}
		return sb.toString();
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	private void ensureContainerCapacity(int minLength){
		if(size >= minLength){
			Object[] newContainer = new Object[size + DEFAULT_SIZE];
			System.arraycopy(container, 0, newContainer, 0, size);
			container = newContainer;
		}
	}
}
