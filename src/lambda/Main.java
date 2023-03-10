package lambda;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

	public static void main(String[] args) {

		Persona p=new Persona() {
			@Override
			public void mensaje() {
				System.out.println("Soy el anónimo");
			}
		};
		Persona p2=new Persona();
		
		p.mensaje();
		p2.mensaje();
		
		IMiInterfaz i=new IMiInterfaz() {

			@Override
			public void m() {
				System.out.println("HOLA");
			}
			
		};//Por instrucción
		
		i.m();
		
		IMiInterfaz i2 = () -> System.out.println("Adíos");
		//Sintaxis simplificada para describir un método
		i2.m();
		
		IOperacionEntera suma=(a, b)->a+b, 
				resta=(a,b)->a-b;
		
		suma.operacion(2, 3);
		resta.operacion(3, 2); 
		
		BiFunction<Integer, Integer, Integer> suma2=(a, b)-> a+b;
		
		
		BiFunction<Integer, Integer, Double> division=(a, b)->(double)a/b;
		
		System.out.println(suma2.apply(2, 3));
		System.out.println(division.apply(10, 3));
		
		Predicate<String> masque5 = (s)-> {
			System.out.println(s.length()>5);
			return s.length()>5;
		};
		
		masque5.test("Hsddfola");
		
		//Referencias a métodos
		
		/*Formato --> referencia :: nombre del método
		 * Tipos-->{
		 * 			nombre de la clase :: método static
		 * 			nombre de la clase :: método 
		 * 			nombre de la clase :: new
		 * 			objeto existente :: método
		 * 			} */
		
		var string="esternocleidomastoideo";
		var instance=new Main();
		
		//tipo objeto existente -> método
		Supplier<String> instanceMethod=string::toUpperCase;
		Supplier<String> instanceMethod2=instance::get;
		Supplier<String> instanceMethod3=instance::getReferencedMethod;
		//nombre de la clase ->new
		Supplier<Main> constructorReference=Main::new;
		Predicate <String> staticMetod=Objects::isNull;
		
		System.out.println(instanceMethod.get());
		System.out.println(instanceMethod2.get());
		System.out.println(instanceMethod3.get());
		System.out.println(constructorReference.get());
		System.out.println(staticMetod.test(null));
	}

	public String getReferencedMethod() {
		Supplier<String> supplier = this::get;
		return supplier.get().concat("-->llamado con this");
	}
	public String get() {
		return "Cualquier cosa";
	}

	@Override
	public String toString() {
		return "Main [getReferencedMethod()=" + getReferencedMethod() + ", get()=" + get() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
