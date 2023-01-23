package br.com.vagner.jj;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
//**Trabalhando Datas**
public class Data {

	public static void main(String[] args) {
		
		 LocalDate hoje = LocalDate.now();
		 System.out.println(hoje);
		 
		 LocalDate olimpiadasRio = LocalDate.of(2016,Month.JUNE, 5);
		 
		 int anos = olimpiadasRio.getYear() - hoje.getYear();
		 System.out.println(anos);
		 
		// Period periodo = Period.between(hoje, olimpiadasRio);
		// System.out.println(periodo);
	
		 Period periodo = Period.between(hoje, olimpiadasRio);
		 System.out.println(periodo.getYears());
		 System.out.println(periodo.getMonths());
		 System.out.println(periodo.getDays()); 
		 
		 //**Toda a API de datas é imutável, ao subtrair ou somar,
		 //**retorna-se nova LocalDate**
	
		 System.out.println(hoje.minusYears(1)); //subtrai
		 System.out.println(hoje.minusMonths(4));
		 System.out.println(hoje.minusDays(2));

		 System.out.println(hoje.plusYears(1));//soma
		 System.out.println(hoje.plusMonths(4));
		 System.out.println(hoje.plusDays(2));
		 
		 DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 
		 LocalDate proximasOlimpiadas = null;
		String valorFormatado = proximasOlimpiadas.format(formatador);
		 System.out.println(valorFormatado);
		 
		 LocalDateTime agora = LocalDateTime.now();
		 
		 DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
		 LocalDateTime agora1 = LocalDateTime.now();
		 System.out.println(agora.format(formatadorComHoras));
		 
		 YearMonth anoEMes = YearMonth.of(2015, Month.JANUARY);
		 
		 LocalTime intervalo = LocalTime.of(12, 30);
		 System.out.println(intervalo);
		 
		 
	}
}
