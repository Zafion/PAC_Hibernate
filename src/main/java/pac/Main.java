/**
 * \@author José Luis Montañana Llopis*/

package pac;

//IMPORTACIONES

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import java.util.*;



public class Main {

	public static void main(String[] args) {
				
		System.out.println("INICIO DE PROGRAMA............\n");
		System.out.println("INICIANDO CONFIGURACIÓN DE BASE DE DATOS............\n");
		
		//PARA INDICAR QUE QUEREMOS USAR HIBERNATE DEFINIMOS LAS INTERFACES
		
		Configuration cfg = new Configuration().configure();	//NECESARIO IMPORTAR org.hibernate.cfg.Configuration;
		
		//UNICA INSTANCIA DE sessionFactory EN NUESTRA SESION
		SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());		
		//NECESARIO IMPORTAR org.hibernate.SessionFactory;  ---  // NECESARIO IMPORTAR org.hibernate.boot.registry.StandardServiceRegistryBuilder;
		
		Session session = sessionFactory.openSession();	//NECESARIO IMPORTAR org.hibernate.Session;
		
		System.out.println("............");	
		System.out.println("CONFIGURACION DE BASE DE DATOS REALIZADA............\n");		
		System.out.println("INICIANDO INSERCIÓN DE DATOS EN LA BASE DE DATOS............\n");
		
		//PARA INSERTAR DATOS EN LA BD VAMOS A USAR transactions		
		
		//PREPARAMOS DATOS A INSERTAR EN LAS DISTINTAS TABLAS
		
		//DATOS PARA TABLA modulo:
		Set<Modulo>alumno_modulo = new HashSet<Modulo>();	// USAMOS SET PARA CREAR LISTA SIN REPETICIONES - //NECESARIO IMPORTAR java.util.*;+
		Modulo modulo = new Modulo ("Programacion B", "M03B");	//PONEMOS Programación SIN ACENTO SEGÚN INSTRUCCIONES DE EVITAR CARÁCTERES ESPECIALES COMO ( ` ´ ¨ ç ñ )
		Modulo modulo2 = new Modulo("Acceso a Datos", "M06");
		Modulo modulo3 = new Modulo("Desarrollo de aplicaciones moviles", "M08"); //PONEMOS moviles SIN ACENTO SEGÚN INSTRUCCIONES DE EVITAR CARÁCTERES ESPECIALES COMO ( ` ´ ¨ ç ñ )
		Modulo modulo4 = new Modulo("Servicios y procesos", "M09");
		
		//DATOS PARA TABLA profesor:		
		Profesor profesor = new Profesor("Alvaro", "Hombre");
		
		//DATOS PARA TABLA alumno:
		Alumno alumno1 = new Alumno("Juan", "Espaniola", 26, "Hombre", alumno_modulo);		
		Alumno alumno2 = new Alumno("Pedro", "Andorrana", 21, "Hombre", alumno_modulo);
		Alumno alumno3 = new Alumno("Marta", "Espaniola", 19, "Mujer", alumno_modulo);
		Alumno alumno4 = new Alumno("Carla", "Francesa", 35, "Mujer", alumno_modulo);
		
		//INSERTAMOS DATOS CORRESPONDIENTES DE TABLA Modulo EN LISTAS DE LA RELACIÓN ENTRE alumno Y modulo LLAMADA alumno_modulo:		
		alumno1.modulos.add(modulo);
		alumno1.modulos.add(modulo2);
		alumno1.modulos.add(modulo3);
		alumno1.modulos.add(modulo4);
		
		alumno2.modulos.add(modulo);
		alumno2.modulos.add(modulo2);
		alumno2.modulos.add(modulo4);
		
		alumno3.modulos.add(modulo3);
		alumno3.modulos.add(modulo4);
	
		alumno4.modulos.add(modulo2);
		alumno4.modulos.add(modulo3);
		alumno4.modulos.add(modulo4);
		
		//INICIAMOS TRANSACCIONES Y SU CORRESPONDIENTE COMMIT:
		
		System.out.println("............");	
		System.out.println("INICIANDO INSERCIÓN DE DATOS EN TABLA modulo............\n");
		
		Transaction tx = session.beginTransaction();	//NECESARIO IMPORTAR org.hibernate.Transaction;
		session.save(modulo);
		tx.commit();
		System.out.println(modulo.toString());		
		
		tx = session.beginTransaction();
		session.save(modulo2);
		tx.commit();
		System.out.println(modulo2.toString());
		
		tx = session.beginTransaction();
		session.save(modulo3);
		tx.commit();
		System.out.println(modulo3.toString());
		
		tx = session.beginTransaction();
		session.save(modulo4);
		tx.commit();
		System.out.println(modulo4.toString());
		
		System.out.println("............");	
		System.out.println("FIN DE INSERCIÓN DE DATOS EN TABLA modulo............\n");
		System.out.println("............");	
		System.out.println("INICIANDO INSERCIÓN DE DATOS EN TABLA profesor............\n");
		
		tx = session.beginTransaction();
		session.save(profesor);
		tx.commit();
		System.out.println(profesor.toString());		
		
		System.out.println("............");	
		System.out.println("FIN DE INSERCIÓN DE DATOS EN TABLA profesor............\n");
		System.out.println("............");	
		System.out.println("INICIANDO INSERCIÓN DE DATOS EN TABLA alumno............\n");
		
		tx = session.beginTransaction();
		session.save(alumno1);
		tx.commit();
		System.out.println(alumno1.toString());		
		
		tx = session.beginTransaction();
		session.save(alumno2);
		tx.commit();
		System.out.println(alumno2.toString());
		
		tx = session.beginTransaction();
		session.save(alumno3);
		tx.commit();
		System.out.println(alumno3.toString());
		
		tx = session.beginTransaction();
		session.save(alumno4);
		tx.commit();
		System.out.println(alumno4.toString());
		
		System.out.println("............");	
		System.out.println("FIN DE INSERCIÓN DE DATOS EN TABLA alumno............\n");
		System.out.println("............");	
		System.out.println("INSERCIÓN DE DATOS EN LA BASE DE DATOS FINALIZADA............\n");
		System.out.println("............");	
		System.out.println("FIN DE PROGRAMA............\n");

		//CIERRE DE RECURSOS
		session.close();	//CIERRE DE session
		sessionFactory.close();	//CIERRE DE sessionFactory
	}
}
