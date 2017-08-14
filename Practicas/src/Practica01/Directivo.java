package Practica01;

public class Directivo extends Planta implements Administrativo{

	private double bonoExtra; 

	public Directivo( String nombre, String apellido, int antiguedad, boolean[] prestaciones, double pagoSemanal, double bono, String nombrePuesto) {
		super( nombre, apellido, antiguedad, pagoSemanal, prestaciones);  
		setBono(bono);
		setNombrePuesto(nombrePuesto);
	}
   
   
	public void setBono( double bono ) { 
		/*
		 * TODO: 
		 * Método que actualiza el atributo de instancia bonoExtra.
		 * Validar que el bono que se recibe de parámetro esté en el rango de 0 y BONO_MAXIMO (que se encuentra en la interfaz).
		 * De lo contrario se le asigna 0.
		 */
	}
   
   
	public double sueldo() { 
		/*
		 * TODO:
		 * Calcula el sueldo de un Directivo de la siguiente manera:
		 * Invocar al método sueldo del padre y sumarle el bonoExtra.
		 */
		return 0.0;
	}
   
   public String administrar() {
	   return "Administra los recursos de su departamento";
   }
   
   public String definirAumentos() {
	   return "Define los aumentos de sueldo de sus empleados";
   }
   
   public String reportarLogros() {
	   return "Reporta los logros de su departamento";
   }
   
   	public void setNombrePuesto(String nombre){
		this.nombrePuesto = nombre;
	}
	
   
    public String toString() {
		return "\n\n***  Directivo  ***\n" + super.toString() + "\nCon bono extra de: " + this.bonoExtra;
	}
}