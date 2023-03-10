package com.expresiones.lambda.ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestExpresionesLambda {

	public static void main(String[]args) {
		//forma tradicional
		/*for(Integer numero: Arrays.asList(1, 2, 3, 4, 5, 6,7 ,8 , 9, 10)) {//Me sirve para crear una lista con números
			System.out.println(numero);
		}*/
		
		//imprimir una lista utilizando expresiones lambda
		Arrays.asList(1, 2, 3, 4, 5, 6,7 ,8 , 9, 10).forEach(//forEach se encarga de recorrer una lista
				n -> System.out.println(n)); //Metemos dentro del forEach una expresión lambda
		
		Arrays.asList(1, 2, 3, 4, 5, 6,7 ,8 , 9, 10).forEach(System.out::println);
		
		/*
		//Forma Tradicional
		List <Integer> listaMenor = new ArrayList <Integer>();
		
		for (Integer i : Arrays.asList(1, 2, 3, 4, 5, 6,7 ,8 , 9, 10)) {
			if(i<5) {
				listaMenor.add(i);
			}
		}
		
		for (Integer integer : listaMenor) {
			System.out.println(integer);
		}*/
		
		ArrayList <Integer> mayores = /*Casteo*/ (ArrayList<Integer>) Arrays
				.asList(1, 2, 3, 4, 5, 6,7 ,8 , 9, 10)
				.stream()
				//Filtro para obtener los numeros mayores a 5
				.filter(x -> x>5/*Expresión lambda*/)
				.collect(Collectors.toList());
				//Pone los elementos que se filtraron dentro de la lista mayores,
				//dentro utilizamos una expresión lambda
		
		mayores.forEach(e -> System.out.println(e));
		
	}
}
