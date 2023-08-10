/**
 * \@author José Luis Montañana Llopis*/

package pac;

//IMPORTACIONES
import java.util.Set;

public class Alumno {
	//public class Alumno implements java.io.Serializable {
	
	private long id;
	private String nombre;
	private String nacionalidad;
	private int edad;
	private String sexo;
	Set<Modulo> modulos;	//NECESARIO IMPORTAR java.util.Set; - USAMOS SET PARA CREAR LISTA SIN REPETICIONES
	
	public Alumno(String nombre, String nacionalidad, int edad, String sexo, Set<Modulo> modulos) {	
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.edad = edad;
		this.sexo = sexo;
		this.modulos = modulos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Set<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(Set<Modulo> modulos) {
		this.modulos = modulos;
	}
	
    @Override
    public String toString() {
    	return "\nInsert into alumno, nombre: " + nombre + ", nacionalidad: " + nacionalidad	
        		+ ", edad: " + edad + ", sexo: " + sexo + ", modulos: " + modulos.size() + "\n";
    }

}
