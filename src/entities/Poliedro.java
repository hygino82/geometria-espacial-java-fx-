package entities;

public abstract class Poliedro {
	private Poligono poligono;
	private double altura;
	private double arrestaBase;

	public Poliedro(Poligono poligono, Double altura, Double arrestaBase) {
		this.poligono = poligono;
		this.altura = altura;
		this.arrestaBase = arrestaBase;
	}

	public Poligono getPoligono() {
		return poligono;
	}

	public void setPoligono(Poligono poligono) {
		this.poligono = poligono;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getArrestaBase() {
		return arrestaBase;
	}

	public void setArrestaBase(double arrestaBase) {
		this.arrestaBase = arrestaBase;
	}
}
