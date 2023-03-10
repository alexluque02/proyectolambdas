package com.ecodeup.lambda;

@FunctionalInterface
public interface ICalculadora {

	//Un solo método abstracto
	//void mensaje(String a);
	//void mensaje1(); --Me da error porque solo se puede un método abstracto
	
	void operacion(double a, double b);
	
	//Pueden tener otros métodos
	
}
