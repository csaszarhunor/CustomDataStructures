package collection.queue;

/*
 * This is an example of Queue, which is a collection that keeps the order of insertion 
 * and the elements can be reached in a controlled manner.
 * 
 * Properties:
 * 	- keeps the order of insertion
 * 	- the item stored first gets out first (FIFO)
 * 	- can contain duplicates
 * 	- can contain nulls
 */
public class CustomQueue<E> {

	private int size = 0;
	private Node<E> first;
	private Node<E> last;
	
	public void add(E element){
		Node<E> newNode = new Node<>(last, element, null);
		if(last == null){
			first = newNode;
		}
		else{
			last.next = newNode;
		}
		last = newNode;
		size++;
	}
	
	public E poll(){
		if(first == null) return null;
		E element = first.element;
		first.next.prev = null;
		first = first.next;
		size--;
		return element;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	@Override
	public String toString() {
		if (first == null) return null;
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node<E> node = first;
		while(node.next != null){
			sb.append(node.element + ", ");
			node = node.next;
		}
		sb.append(last.element + "]");
		return sb.toString();
	}
	
	private class Node<T>{
		private T element;
		private Node<T> next;
		private Node<T> prev;
		
		public Node(Node<T> prev, T element, Node<T> next) {
			this.prev = prev;
			this.element = element;
			this.next = next;
		}
	}
	
	
}