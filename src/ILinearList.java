
public interface ILinearList 
{
	boolean isEmpty();
	int size();
	Object get(int index);
	int indexOf(Object object);
	void add(int index, Object object);
	Object remove(int index);
	String outputlist();
}
