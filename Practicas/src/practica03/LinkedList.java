package practica03;
public class LinkedList<E> implements List<E> {
	private Node<E> header;
	private int size;
	
	public LinkedList() {
		header = new Node<E>();
		size = 0;
	}
	
	/**
	 * Gets the node at the specified index.
	 * @param index the index of the node to get
	 * @return the node at the specified position
	 * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
	 */
	private Node<E> node(int index) {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		if (index < (size >> 1)) {
            Node<E> x = header.next;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = header.prev;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
	}

	@Override
	public void addFirst(E e) {
		// TODO Auto-generated method stub
        Node<E> newElement = new Node<E>(e);

        Node<E> firstElement = header.next;

        newElement.next=firstElement;
        firstElement.prev = newElement;

        newElement.prev =header;
        header.next = newElement;
        size++;

	}

	@Override
	public void addLast(E e) {
		// TODO Auto-generated method stub
		Node<E> newElement = new Node<E>(e);
        Node<E> lastElement = header.prev;

        newElement.prev = lastElement;
        lastElement.next = newElement;

        newElement.next = header;
        header.prev = newElement;

        size++;
		
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
        if(index <0 || index >size()){
            throw new IndexOutOfBoundsException();
        }

        if(index == size()){
            addLast(element);
        }else {

            Node<E> newNode = new Node<E>(element);
            Node<E> current = node(index);
            Node<E> previuosNode = current.prev;

            newNode.prev = previuosNode;
            previuosNode.next = newNode;

            newNode.next = current;
            current.prev = newNode;
            size++;
        }

	}

	@Override
	public E removeFirst() {
		// TODO Auto-generated method stub
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        Node<E> nodeToRemove = header.next;
        Node<E> newFirstElement = nodeToRemove.next;

        header.next = newFirstElement;
        newFirstElement.prev = header;

        nodeToRemove.next = null;
        nodeToRemove.prev = null;

        size--;

		return nodeToRemove.value;
	}

	@Override
	public E removeLast() {
		// TODO Auto-generated method stub
		Node<E> nodeToRemove = header.prev;
        Node<E> newLastElement = nodeToRemove.prev;

        header.prev = newLastElement;
        newLastElement.next = header;

        nodeToRemove.prev =null;
        nodeToRemove.next = null;

        size--;
		return nodeToRemove.value;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }

        if(index <= (size >> 1)){

            Node<E> current = header;

            for(int i =0; i< index; i++){
                current = current.next;
            }

            Node<E> nodeToRemove = current.next;
            Node<E> x = nodeToRemove.next;

            current.next =x;
            x.prev = nodeToRemove.prev;

            nodeToRemove.prev =null;
            nodeToRemove.next =null;
            size --;
            return nodeToRemove.value;
        }else{
            Node<E> current = header;

            for(int i = size - 1; i > index; i--){
                current = current.prev;
            }

            Node<E> nodeToRemove = current.prev;
            Node<E> x = nodeToRemove.prev;

            current.prev =x;
            x.next=current;

            nodeToRemove.prev =null;
            nodeToRemove.next =null;
            size--;
            return nodeToRemove.value;
        }
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
        if(indexOf(o)==0){
            return false;
        }else {
            int index = indexOf(o);
            Node<E> current = header;
            for (int i = 0; i <= index; i++) {
                current = current.next;
            }
            Node<E> nextNode = current.next;
            Node<E> prevNode = current.prev;

            nextNode.prev = prevNode;
            prevNode.next = nextNode;

            current.next = null;
            current.prev = null;

            size--;

            return true;
        }

	}

	@Override
	public E getFirst() {
		// TODO Auto-generated method stub
		if(isEmpty()){
            throw new NoSuchElementException();
        }

		return header.next.value;
	}

	@Override
	public E getLast() {
		// TODO Auto-generated method stub
		if(isEmpty()){
            throw new NoSuchElementException();
        }

		return header.prev.value;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
        if(index<0 || index>= size()){
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = header;
        for(int i=0; i<=index; i++){
            current =current.next;
        }


		return current.value;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
        Node<E> current = header;
        for(int i =0; i < index; i++){
            current = current.next;

        }

        Node<E> newElement = current.next;
        newElement.value = element;

		return newElement.value;
	}

	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		Node<E> current = header;
        Node<E> nodeToSearch = new Node<E>(e);
        for(int i =0; i <= size();i++){
            if(nodeToSearch.value == current.value){
                return true;
            }
            current = current.next;
        }
		return false;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
        int index = 0;
        Node<E> current = header.next;

        if(o == null){
            while (current.value != null){
                current = current.next;
                index++;

            }
            return index;

        }else{
            while (!(o.equals(current.value))){
                current = current.next;
                index++;

            }
            return index;
        }


		return -1;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		header.next = header;
        header.prev = header;
        size=0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		if(isEmpty()){
            return null;
        }else{
            Object [] array =new Object[size()];
            Node<E> current =header;
            for(int i =0; i<size(); i++){
                array[i] = current.next.value;
                current = current.next;
            }
            return array;
        }

	}
	
	@Override
	public String toString() {
	    if(header.next.value == null){
	        return "[]";
        }

        Node<E> current = header.next;
	    String returnValue = "[" + current.value;

	    while(current.next != header){
	        current = current.next;
	        returnValue += "," + current.value;
        }

        returnValue += "]";
	    return returnValue;
	}
}
