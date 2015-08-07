package business.entity;

public class Optional implements Entity {
	private String codice;
	private String tipo;
	private float costo;

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}
	
	public String toString() {
		return "'" + codice + "', '" + tipo + "', " + costo;
	}
}