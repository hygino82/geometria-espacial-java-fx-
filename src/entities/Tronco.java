package entities;

public class Tronco extends Poliedro implements GerarValores, Area {
	private double arrestaSegundaBase;

	public Tronco(Poligono poligono, Double altura, Double arrestaBase, Double arrestaSegundaBase) {
		super(poligono, altura, arrestaBase);
		this.arrestaSegundaBase = arrestaSegundaBase;
	}

	public double getArrestaSegundaBase() {
		return arrestaSegundaBase;
	}

	public void setArrestaSegundaBase(double arrestaSegundaBase) {
		this.arrestaSegundaBase = arrestaSegundaBase;
	}

	@Override
	public Double volume() {
		return getAltura() * (areaBase() + areaBase2() + Math.sqrt(areaBase() * areaBase2())) / 3.0;
		
	}

	@Override
	public Double areaLateral() {
		double l1 = getArrestaBase();
		double l2 = getArrestaSegundaBase();
		double h = getAltura();
		int n = 1;// inicializar
		double m1 = 0, m2 = 0;//inicializando
		double g;
		double area = 0;// inicializar

		switch (getPoligono()) {
		case CIRCULO:
			double dif = Math.abs(l1 - l2);
			g = Math.sqrt(Math.pow(dif, 2.0) + Math.pow(h, 2.0));
			area = Math.PI * g * (l1 + l2);
			break;
		case QUADRADO:
			m1 = l1 / 2.0;
			m2 = l2 / 2.0;
			n = 4;// 4 lados
			break;
		case HEXAGONO_REGULAR:
			m1 = l1 * Math.sqrt(3) / 2.0;
			m2 = l2 * Math.sqrt(3) / 2.0;
			n = 6;
			break;
		default://triangulo equilátero
			m1 = l1 * Math.sqrt(3) / 6.0;
			m2 = l2 * Math.sqrt(3) / 6.0;
			n = 3;
			break;
		}
		
		if (getPoligono() != Poligono.CIRCULO) {
			double dif = Math.abs(m1 - m2);
			g = Math.sqrt(Math.pow(dif, 2.0) + Math.pow(h, 2.0));
			//System.out.println("g = "+ g);
			
			area = n * (l1 + l2) * g / 2.0; 
		}
		return area;
	}

	@Override
	public Double areaBase() {
		double areas = area(super.getPoligono(), super.getArrestaBase());
		return areas;
	}

	public Double areaBase2() {
		double areas = area(super.getPoligono(), getArrestaSegundaBase());
		return areas;
	}

	@Override
	public Double areaTotal() {
		return areaBase() + areaBase2() + areaLateral();

	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("O tronco de pirâmide possui como base um "+ getPoligono());
		sb.append("\nArresta da primeira base: " + String.format("%.4f", getArrestaBase()));
		sb.append("\nArresta da segunda base: " + String.format("%.4f", getArrestaSegundaBase()));
		sb.append("\nAltura: " + String.format("%.4f", getAltura()));
		sb.append("\nÁrea da primeira base: " + String.format("%.4f", areaBase()));
		sb.append("\nÁrea da segunda base: " + String.format("%.4f", areaBase2()));
		sb.append("\nÁrea lateral: " + String.format("%.4f", areaLateral()));
		sb.append("\nÁrea total: " + String.format("%.4f", areaTotal()));
		sb.append("\nVolume: " + String.format("%.4f", volume()));
		return sb.toString();
	}

}
