package business.entity;

public class Fascia implements Entity {
	private String nome;
	private float tariffaBase;
	private double min;
	private double max;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getTariffaBase() {
		return tariffaBase;
	}

	public void setTariffaBase(float tariffaBase) {
		this.tariffaBase = tariffaBase;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}
}