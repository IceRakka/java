/** An DLList is a double-ended queue of Ts,
 * which linked each other in both directions. */
public class LinkedListDeque<T> {
	private class Node {
		public T val;
		public Node next;
		public Node prev;

		public Node(T i, Node m, Node n) {
			val = i;
			next = m;
			prev = n;
		}
	}

	/** Initialize sentinel node and size. */
	private Node sentinel;
	private int size;

	/** Intialize an empty DLList without param. */
	public LinkedListDeque() {
		sentinel = new Node(null, null, null);
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
		size = 0;
	}
	/** Adds x to the front of the list. */
	public void addFirst(T x) {
		Node tmp = sentinel.next;
		Node newNode = new Node(x, tmp, sentinel);
		tmp.prev = newNode;
		sentinel.next = newNode;
		size += 1;
	}

	/** Adds x to the end of the list. */
	public void addLast(T x) {
		Node tmp = sentinel.prev;
		Node newNode = new Node(x, sentinel, tmp);
		tmp.next = newNode;
		sentinel.prev = newNode;
		size += 1;
	}

	/** Returns whether this deque is empty or not. */
	public boolean isEmpty() {
		return sentinel.next == sentinel;
	}

	/** Returns the size of the list. */
	public int size() {
		return size;
	}

	/** Prints out every elements in list in order without changing it. */
	public void printDeque() {
		String s = "";
		Node curNode = sentinel.next;
		while (curNode != sentinel) {
			s += curNode.val.toString();
			s += " ";
			curNode = curNode.next;
		}
		System.out.println(s);
	}

	/** Removes the first T in the list. */
	public T removeFirst() {
		if (size == 0) {
			return null;
		}
		Node first = sentinel.next;
		Node tmp = first.next;
		sentinel.next = tmp;
		tmp.prev = sentinel;
		size -= 1;
		return first.val;
	}

	/** Removes the last element in the list. */
	public T removeLast() {
		if (size == 0) {
			return null;
		}
		Node last = sentinel.prev;
		Node tmp = last.prev;
		tmp.next = sentinel;
		sentinel.prev = tmp;
		size -= 1;
		return last.val;
	}

	/** Returns the ith element of the list by iteration. */
	public T get(int index) {
		if (index < 0 || index >= size) {
			return null;
		}

		Node curNode = sentinel;
		for (int i = -1; i < index; i++) {
			curNode = curNode.next;
		}
		return curNode.val;
	}

	/** Returns the ith elements of the list by recursion. */
	public T getRecursive(int index) {
		if (index < 0 || index >= size) {
			return null;
		}
		return this.helper(index, sentinel.next);
	}

	private T helper(int index, Node curNode) {
		if (index == 0) {
			return curNode.val;
		}
		return this.helper(index - 1, curNode.next);
	}
}