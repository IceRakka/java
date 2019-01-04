/** An ArrayDeque is a double-ended queue of Ts, 
 * which linked each other in both directions. */

public class ArrayDeque<T> {
	/** Initialize array, nextFirst, nextLast pointer and size. */
	private T[] items;
	public int nextFirst;
	private int nextLast;
	private int size;

	/** Initialize an empty ArrayDeque without param. */
	public ArrayDeque() {
		items = (T[]) new Object[8];
		nextFirst = 0;
		nextLast = 1;
		size = 0;
	}

	private void resize(int capacity) {
		T[] a = (T[]) new Object[capacity];
		// arraycopy(src, srcpos, dest, destpos, length)
		System.arraycopy(items, (nextFirst + 1) % size, a, 0, size - nextFirst - 1); 
		System.arraycopy(items, 0, a, size - nextFirst - 1, nextLast);
		nextFirst = capacity - 1;
		nextLast = size;
		items = a;
	}

	/** Adds x to the front of the list. */
	public void addFirst(T x) {
		if (size == items.length) {
			resize(size + 1);
		}
		items[nextFirst] = x;
		nextFirst = (nextFirst - 1 + items.length) % items.length;
		size += 1;
	}

	/** Adds x to the end of the list. */
	public void addLast(T x) {
		if (size == items.length) {
			resize(size + 1);
		}
		items[nextLast] = x;
		nextLast = (nextLast + 1) % items.length;
		size += 1;
	}

	/** Returns whether this deque is empty or not. */
	public boolean isEmpty() {
		return size == 0;
	}

	/** Returns the size of the list. */
	public int size() {
		return size;
	}

	/** Prints out every elements in list in order without changing it. */
	public void printDeque() {
		String s = "";
		if ((nextFirst + 1) % items.length > nextLast) {
			for (int i = (nextFirst + 1) % items.length; i < items.length; i++) {
				s += items[i].toString();
				s += " ";
			}
			for (int j = 0; j < nextLast; j++) {
				s += items[j].toString();
				s += " ";
			}
		}else {
			for (int p = (nextFirst + 1) % items.length; p < nextLast; p++) {
				s += items[p].toString();
				s += " ";
			}
		}
		System.out.println(s);
	}

	/** Removes the first T in the list. */
	public T removeFirst() {
		if (size == 0) {
			return null;
		}
		nextFirst = (nextFirst + 1) % items.length;
		T ret = items[nextFirst];
		items[nextFirst] = null;
		size -= 1;
		return ret;
	}

	/** Removes the last element in the list. */
	public T removeLast() {
		if (size == 0) {
			return null;
		}
		nextLast = (nextLast - 1 + items.length) % items.length;
		T ret = items[nextLast];
		items[nextLast] = null;
		size -= 1;
		return ret;
	}

	/** Returns the ith element of the list by iteration. */
	public T get(int index) {
		if (index < 0 || index >= size) {
			return null;
		}
		return items[(index - nextFirst + items.length) % items.length];
	}
}