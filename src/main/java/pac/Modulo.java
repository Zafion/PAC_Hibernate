/**
 * \@author José Luis Montañana Llopis*/

package pac;

//PARA MODULO NO SON NECESARIAS IMPORTACIONES

public class Modulo {
	 private long id;
	 private String nombre;
	 private String codigo;
	 
	 public Modulo(){ 
		 super();
	 }
	 
	 public Modulo(String nombre, String codigo) {	    	
	    this.id = id;
	    this.nombre = nombre;
	    this.codigo = codigo;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	 
	@Override
    public String toString() {        
		return "\nInsert into modulo, nombre: " + nombre + ", codigo: " + codigo + "\n";
		//ponemos módulo sin acento según instrucciones de evitar caracteres especiales como ( ` ´ ¨ ç ñ )
    }
}


