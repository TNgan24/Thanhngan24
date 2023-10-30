package lab6;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;

	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}

	public void growSize() {
		int newCapacity = elements.length * 2;
		E[] element = (E[]) new Object[newCapacity];
		System.arraycopy(elements, 0, element, 0, size);
		elements = element;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E get(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		}
		return elements[i];
	}

	public E set(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		}
		E newElement = elements[i];
		elements[i] = e;
		return newElement;
	}

	public boolean add(E e) {
		if (size == elements.length) {
			growSize();
		}
		elements[size] = e;
		size++;
		return true;
	}

	public void add(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		}
		if (size == elements.length) {
			growSize();
		}
		System.arraycopy(elements, i, elements, i + 1, size - i);

		elements[i] = e;
		size++;
	}

	public E remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		}
		E removeException = elements[i];
		System.arraycopy(elements, i + 1, elements, i, size - i - 1);

		elements[size - 1] = null;
		size--;
		return removeException;
	}

	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	public int lastIndexOf(Object o) {
		for (int i = size - 1; i >= 0; i--) {

			if (o.equals(elements[i])) {
				return i;
			}
		}

		return -1;
	}

	public E[] toArray() {
		E[] newArray = (E[]) new Object[size];
		System.arraycopy(elements, 0, newArray, 0, size);

		return newArray;
	}

	public MyArrayList<E> clone() {
		MyArrayList<E> cloneList = new MyArrayList<>();
		cloneList.size = this.size;
		cloneList.elements = Arrays.copyOf(this.elements, this.size);
		System.arraycopy(elements, 0, cloneList.elements, 0, size);
		return cloneList;
	}

	public boolean contains(E o) {
		return indexOf(o) != -1;
	}

	public int indexOf(E o) {
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}

	public boolean remove(E e) {
		int index = indexOf(e);
		if (index != -1) {
			remove(index);
		}
		return false;
	}

	public void sort(Comparator<E> c) {
		Arrays.sort(elements, 0, size, c);
	}

	public static void main(String[] args) {
		MyArrayList<Integer> list = new MyArrayList<>();

		list.add(10);
		list.add(20);
		list.add(30);

		System.out.println("Size: " + list.size());

		System.out.println("Phần tử: " + Arrays.toString(list.toArray()));

		int element = list.get(1);
		System.out.println("Phần tử ở vị trí 1: " + element);

		int replacedElement = list.set(2, 40);
		System.out.println("Phần tử đc thay thế: " + replacedElement);
		System.out.println("Phần tử sau khi thay thế: " + Arrays.toString(list.toArray()));

		list.add(1, 15);
		System.out.println("Phần tử sau khi chèn: " + Arrays.toString(list.toArray()));

		int removedElement = list.remove(0);
		System.out.println("Phần tử đã xóa: " + removedElement);
		System.out.println("Phần tử sau khi xóa: " + Arrays.toString(list.toArray()));

		boolean containsElement = list.contains(20);
		System.out.println("Danh sách chứa phần tử 20: " + containsElement);

		list.clear();
		System.out.println("Size sau khi xóa: " + list.size());
		System.out.println("Các phần tử sau khi xóa: " + Arrays.toString(list.toArray()));

		list.add(30);
		list.add(10);
		list.add(20);
		list.sort(Comparator.naturalOrder());
		System.out.println("Phần tử sau khi sắp xếp: " + Arrays.toString(list.toArray()));
	}

}
