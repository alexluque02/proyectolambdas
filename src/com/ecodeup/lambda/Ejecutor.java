package com.ecodeup.lambda;

public class Ejecutor {

	public static void main(String[] args) {
		
		/*ICalculadora calculadora = 
				(parámetros n) -> método System.out.println(n+" Bienvenido a las expresiones lambda");*/
				
		//Hemos implementado a través de las expresiones lambda el método
		//que está en la interfaz funcional
				
		//calculadora.mensaje("Alex");
		
		ICalculadora calculadora = (a, b) -> {
			double resultado=a+b;
			System.out.println("La suma es: "+resultado);
		};
		
		
		calculadora.operacion(4, 3);
		
		ICalculadora calculadora1 = (a, b) -> {
			double resultado=a-b;
			System.out.println("La resta es: "+resultado);
		};
		
		
		calculadora1.operacion(8, 3);
		
		
		//Hemos implementado de diferentes maneras un mismo método definido en una interfaz funcional
	}

}
