package entities;

public class Piramide extends Poliedro implements GerarValores,Area
{

	public Piramide(Poligono poligono, Double altura, Double arrestaBase) {
		super(poligono, altura, arrestaBase);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double volume() {

		return areaBase() * getAltura() / 3.0;
	}

	@Override
	public Double areaLateral() {
		double m, g;
		double area = 0;
		double l = getArrestaBase();
		double h = getAltura();
		
		switch (getPoligono()) {
		case CIRCULO:
			g = Math.sqrt(Math.pow(l, 2.0) + Math.pow(h, 2.0));
			//System.out.println("g = " + g);
			area = Math.PI * l * g;
			break;
		case QUADRADO:
			m = l / 2.0;
			g = Math.sqrt(Math.pow(h, 2.0) + Math.pow(m, 2.0));
			//System.out.println("g = " + g);
			area = 4 * l * g / 2.0;
			break;
		case HEXAGONO_REGULAR://erro  corrigir
			m = l * Math.sqrt(3) / 2.0;
			//m = getArrestaBase();
			g = Math.sqrt(Math.pow(h, 2.0) + Math.pow(m, 2.0));

			area = 6 * l * g / 2.0;
			break;
		default:// triangulo equilatero
			m = getArrestaBase() * Math.sqrt(3) / 6.0;
			g = Math.sqrt(Math.pow(getAltura(), 2.0) + Math.pow(m, 2.0));
			area = 3 * l * g / 2.0;
			break;
		}
		//System.out.println("g = " + g);
		return area;
	}

	@Override
	public Double areaBase() {
		double areas = area(super.getPoligono(), super.getArrestaBase());
		return areas;
	}

	@Override
	public Double areaTotal() {
		return areaBase() + areaLateral();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("A pirâmide possui como base um "+ getPoligono());
		sb.append("\nArresta da base: " + String.format("%.4f", getArrestaBase()));
		sb.append("\nAltura: " + String.format("%.4f", getAltura()));
		sb.append("\nÁrea da base: " + String.format("%.4f", areaBase()));
		sb.append("\nÁrea lateral: " + String.format("%.4f", areaLateral()));
		sb.append("\nÁrea total: " + String.format("%.4f", areaTotal()));
		sb.append("\nVolume: " + String.format("%.4f", volume()));
		return sb.toString();
	}

}
