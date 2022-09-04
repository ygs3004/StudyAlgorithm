package chap13.extendsclass;

public interface Storage<T> {
	public void add(T item, int index);
	public T get(int index);
}