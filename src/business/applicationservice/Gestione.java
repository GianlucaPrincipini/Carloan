package business.applicationservice;

import java.util.List;

import business.exception.CarloanException;


public interface Gestione<Data> {

	public void create(Data entity) throws Exception;
	public void update(Data entity) throws Exception;
	public void delete(Data entity) throws Exception;
	public List<Data> readAll();
	public Data read(String pk);
	
}
