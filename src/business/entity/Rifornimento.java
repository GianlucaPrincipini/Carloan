package business.entity;

import java.io.Serializable;

public enum Rifornimento {
	
	STANDARD(0), PIENO_ANTICIPO(1);
	
	private int index;
	
	
	
	private Rifornimento(int index) {
		this.index = index;
	}
	
	public int getIndex() {
		return index;
	}
	
	public static Rifornimento getRifornimento(int index) {
		for (Rifornimento t : Rifornimento.values()) {
			if (t.index == index) {
				return t;
			}
		} throw new IllegalArgumentException();
	}

	
}