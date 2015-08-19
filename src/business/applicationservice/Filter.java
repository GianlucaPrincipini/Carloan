package business.applicationservice;

import java.util.HashMap;
import java.util.Map;

public class Filter {
	private Map<String, Object> filter = new HashMap<String, Object>();
	
	public void setValue(String attribute, Object value) {
		filter.put(attribute, value);
	}
	
	public Object getValue(String attribute) {
		return filter.get(attribute);
	}
}
