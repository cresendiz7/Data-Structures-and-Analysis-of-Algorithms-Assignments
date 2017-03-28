public class Map<KeyType,ValueType>{
	private QuadraticProbingHashTable<Entry<KeyType,ValueType>> items;
	
	public Map( )
	{
		items = new QuadraticProbingHashTable<Entry<KeyType,ValueType>>();
	}
	
	public int size( )
    {
		return items.size();
    }
	
	public void put( KeyType key, ValueType val )
	{
		Entry<KeyType, ValueType> e = new Entry<KeyType, ValueType>(key, val);
		items.insert(e);
	}
	
	public ValueType get( KeyType key )
	{
		ValueType v = (ValueType) new Object();
		Entry<KeyType, ValueType> e = new Entry<KeyType, ValueType>(key, v);
		if(items.contains(e))
				return e.value;
		return null;
	}
	
	public boolean isEmpty( ){
		if (size() == 0)
			return true;
		else
			return false;
	}
	
	public void makeEmpty( )
	{
		items.makeEmpty();
	}
	
	private static class Entry<KeyType,ValueType>
	{
		KeyType key;
		ValueType value;
		private Entry(KeyType k, ValueType v)
		{
			key = k;
			value = v;
		}
	}
}
