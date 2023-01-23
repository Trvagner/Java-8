package br.com.vagner.jj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

//usando recursos java 8...default methods
public class OrdenaStringsJava {

	public static void main(String[] args) {

		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");

		//Comparator<String> comparador = new ComparadorDeStringPorTamanho();
		// Collections.sort(palavras, comparador); **antes java 8
		//**precisamos criar classe externa
		
//		palavras.sort(comparador);// **com java 8
//		System.out.println(palavras);
		//usando o lambda abaixo
		
//		palavras.sort((s1, s2)-> {
//			if (s1.length() < s2.length())
//				return -1;
//			if (s1.length() > s2.length())
//				return 1;
//			return 0;
//		});
		//**reduzindo mais lambda**
		//palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		//**por ultimo fugindo método compare, subtrai-se os 2 elementos**
		palavras.sort((s1,s2) -> s1.length()-s2.length());
		//**indo além**
		//palavras.sort(Comparator.comparing(s -> s.length()));
		//**Usando Method reference
		palavras.sort(Comparator.comparing(String::length));
		System.out.println(palavras);
		//**usando ooutro comparador**
		System.out.println("*****************************");
		palavras.sort(String.CASE_INSENSITIVE_ORDER);
		System.out.println(palavras);
		
//		for (String p : palavras) {  //**antes do java 8**
//			System.out.println(p);
//		}

		// Consumer<String> consumidor = new ImprimeNaLinha();
		
		// **usado implementar Consumer fora, poucas linhas sem reuso implementar
		// **Interface dentro da propria classe melhor pratica

		// **Classe anonima**

		// Consumer<String> consumidor = new Consumer<String>() {

//			@Override
//			public void accept(String s) {
//				System.out.println(s);
//			}
//		};
		// **colocamos a classe anonima direto no argumento do forEach**
		
//		
//		palavras.forEach(new Consumer<String>() {
//
//			@Override
//			public void accept(String s) {
//				System.out.println(s);
//			}
//		});
		// **melhor ainda, sabemos que a interface Consumer tem um só metodo
		// podemos retirar a parte inicial e declarar o que desejamos fazer
		// usando a lambda ->...como está abaixo**

//		palavras.forEach((String s)-> {
//				System.out.println(s);
//			
//		});
		// **em ultima redução teremos
		//nosso primeiro lambda
		//Lambda funciona quando tem um método só
		//também chamado Interface Funcional**

		//palavras.forEach(s -> System.out.println(s));
		//**Usando Merhod reference
		palavras.forEach( System.out::println);
	}
}


//**implementado para usar forEach default**
//class ImprimeNaLinha implements Consumer<String>{
//
//	@Override
//	public void accept(String s) {
//		System.out.println(s);
//		
//	}
//	
//}

//**implementado para usar comparador--método .sort default**
//class ComparadorDeStringPorTamanho implements Comparator<String> {
//
//	public int compare(String s1, String s2) {
//		if (s1.length() < s2.length())
//			return -1;
//		if (s1.length() > s2.length())
//			return 1;
//		return 0;
	

