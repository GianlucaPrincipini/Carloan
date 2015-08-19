package business.checker;

public interface Checker<Data> {
	public boolean check(Data entity);
	public boolean isModifiable(Data entity);
}
