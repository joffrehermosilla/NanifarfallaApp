package nanifarfalla.app.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public abstract class ListGroupBy<K, T> {
	public Map<K, List<T>> map(List<T> list) {
		Map<K, List<T>> map = new HashMap<K, List<T>>();
		for (T t : list) {
			K key = groupBy(t);
			List<T> innerList = map.containsKey(key) ? map.get(key) : new ArrayList<T>();
			innerList.add(t);
			map.put(key, innerList);
		}
		return map;
	}

	protected abstract K groupBy(T t);
}
