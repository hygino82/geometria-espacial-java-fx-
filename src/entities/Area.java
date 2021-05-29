package entities;

public interface Area {
	Poligono getPoligono();
	double getArrestaBase();
	
	default double area(Poligono tipoBase, double arresta) {		
		
		double areaS = 1.0;
		switch (tipoBase) {
		case QUADRADO:
			areaS = Math.pow(arresta, 2.0);
			break;
		case TRIANGULO_EQUILATERO:
			areaS = Math.pow(arresta, 2.0) * Math.sqrt(3.0) / 4.0;
			break;
		case HEXAGONO_REGULAR:
			areaS = 3.0 * Math.pow(arresta, 2.0) * Math.sqrt(3.0) / 2.0;
			break;
		case CIRCULO:
			areaS = Math.pow(arresta, 2.0) * Math.PI;
			break;
		}
		return areaS;
	}
}
