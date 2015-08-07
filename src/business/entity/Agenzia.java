package business.entity;

public class Agenzia implements Entity {
	private int idAgenzia;
	private String indirizzo;
	private String citt�;
	private String numTelefono;

	public int getIdAgenzia() {
		return idAgenzia;
	}

	public void setIdAgenzia(int idAgenzia) {
		this.idAgenzia = idAgenzia;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCitt�() {
		return citt�;
	}

	public void setCitt�(String citt�) {
		this.citt� = citt�;
	}

	public String getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(String numTelefono) {
		this.numTelefono =numTelefono;
	}
	
	public String toString() {
		return idAgenzia + ", '" + indirizzo + "', '" + citt� + "', '" + numTelefono + "'";
	}

}