package business.entity;

public class Optional implements Entity {
	private int id;
	private String tipo;
	private double costo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	public String toString() {
		return "'" + id + "', '" + tipo + "', " + costo;
	}
}