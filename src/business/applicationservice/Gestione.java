package business.applicationservice;

import java.util.List;

public interface Gestione<Data> {

	public void create(Data entity);
	public void update(Data entity);
	public void delete(Data entity);
	public List<Data> readAll();
	public Data read(String pk);
	
}
