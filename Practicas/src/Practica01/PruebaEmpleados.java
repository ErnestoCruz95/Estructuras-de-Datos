package Practica01;

public class PruebaEmpleados {
	
	public static void main(String[] args) {
		
		boolean[] prestaciones = {true, true, false, false, true, false, true, false};
		Directivo iron = new Directivo("Tony", "Stark", 5, prestaciones, 12500.0, 5000.0, "Director general Stark Inc");
	
		boolean[] prestaciones2 = {false, true, true, false, true, true, false, false};
		Secretaria roz = new Secretaria("Roz", "Ronney", 10, prestaciones2, 6200.0, "Secretaria ejecutiva");
	
		System.out.println(iron.toString());
		System.out.println(roz.toString());
		
		System.out.println("\n\n** POLIMORFISMO CON PLANTA **");
		System.out.println("\n" + iron.getNombre() + " " + iron.getApellido() + " " + PruebaEmpleados.actividadParticular(iron));
		System.out.println("\n" +roz.getNombre() + " " + roz.getApellido() + " " + PruebaEmpleados.actividadParticular(roz));
		
		
		System.out.println("\n\n** POLIMORFISMO CON ADMINISTRATIVO **");
		System.out.println("\n" + iron.getNombre() + " " + iron.getApellido() + " " + PruebaEmpleados.queHace(iron));
		
		System.out.println("\n\n");
	}
	
	
	public static String actividadParticular(Planta a){	
		/*
		 * TODO:
		 * Regresa una cadena con las actividades particulares del objeto de Planta que se recibe de par�metro
		 */
		String str = new String ("");
		if( a instanceof Directivo) {
			Directivo d = (Directivo) a;
			str = d.administrar() +" " + d.reportarLogros() + " " +d.definirAumentos();
		} else if (a instanceof Secretaria) {
			Secretaria s = (Secretaria) a;
			str = s.llenaRegistros();
		}
		return str;
	}
	
	
	
	public static String queHace(Administrativo d){
		/*
		 * TODO:
		 * Regresa una cadena con las actividades que realiza el objeto con un rol de Administrativo que se recibe de par�metro
		 */
		String str = new String ("");
		str = d.administrar() +" " + d.definirAumentos() + " " + d.reportarLogros();
		return str;
	}
}