package br.com.vagner.jj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


//** testando stream**
public class Curso {
	
	private String nome;
    private int alunos;
	private static List<Curso> cursos;

    public Curso(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public int getAlunos() {
        return alunos;
    }
    
    public static void main(String[] args) {
    	
    	cursos = new ArrayList<Curso>();
    	cursos.add(new Curso("Python", 45));
    	cursos.add(new Curso("JavaScript", 150));
    	cursos.add(new Curso("Java 8", 113));
    	cursos.add(new Curso("C", 55));
    	
    	cursos.sort(Comparator.comparingInt(Curso::getAlunos));
    	//cursos.forEach(c -> System.out.println(c.getNome()));
    	
    	//método .filter
    	//Stream<Curso> streamDeCurso = cursos.stream().filter(c -> c.getAlunos() > 100);
    	
    	//método .forEach
    	//cursos.forEach(c -> System.out.println(c.getNome()));
    	
    	//cursos.stream().filter(c -> c.getAlunos() > 100)
    		//	.forEach(c -> System.out.println(c.getNome()))
    	 
    	//**map com lambda**
    	//.map(c -> c.getAlunos())
    	
    	//**map com reference
    	
    	//.map(Curso::getAlunos)
    	   //.forEach(System.out::println);
    	
    	int soma = cursos.stream()
    			   .filter(c -> c.getAlunos() > 100)
    			   .mapToInt(Curso::getAlunos)
    			   .sum(); //somar quantia de alunos
    	System.out.println(soma);
    	
    	Optional<Curso> optionalCurso = cursos.stream()
    	.filter(c -> c.getAlunos() >=100)
    	.findAny();// devolve um curso que tenha mais que 100 alunos
    	
    	 
    	Curso curso = optionalCurso.orElse(null);
    	
    	//System.out.println(curso.getNome());
    	//**linha abaixo, retorna mesmo resultado linha acima**
    	//**ifPresent imprimi se estiver presente**
    	
    	optionalCurso.ifPresent(c -> System.out.println(c.getNome()));
    	System.out.println("*************colector");
    	//**podemos concatenar juntamente com filter/findAny/ifPresent**
	
    	//**Gerando uma nova lista**
    	
//    	List<Curso> resultados = cursos.stream()
//    			   .filter(c -> c.getAlunos() > 100)
//    			   .collect(Collectors.toList());
    	
    	cursos = cursos.stream()
    			   .filter(c -> c.getAlunos() > 100)
    			   .collect(Collectors.toList());
    			   
    	cursos.stream()
    	.forEach(c -> System.out.println(c.getNome()));
    	
    	//**Trabalhando com mapa**
    	System.out.println("*************************mapa");
    	Map mapa = cursos 
    			.stream() 
    			.filter(c -> c.getAlunos() > 100) 
    			.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos())); 
    
    		System.out.println(mapa);
    }
    
}


	

 