package modulo_datas;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class DatasEmJava {

	public static void main(String[] args) throws ParseException, InterruptedException {

	/*	Calendar calendar = Calendar.getInstance();
		
		Date date = new Date();

		System.out.println("Data em milisegundos: " + date.getTime());
		System.out.println("Calendar em milisegundos: " + calendar.getTimeInMillis());

		System.out.println("Dia do mês: " + date.getDate());
		System.out.println("Calendar do mes: " + calendar.get(Calendar.DAY_OF_MONTH));

		System.out.println("Dia da semana: " + date.getDay());
		System.out.println("Calendar da semana: " + calendar.get(Calendar.DAY_OF_WEEK));

		System.out.println("Hora do dia: " + date.getHours());
		System.out.println("Calendar hora do dia: " + calendar.get(Calendar.HOUR_OF_DAY));

		System.out.println("Minuto da hora: " + date.getMinutes());
		System.out.println("Calendar minuto do dia: " + calendar.get(Calendar.MINUTE));

		System.out.println("Segundos: " + date.getSeconds());
		System.out.println("Calendar segundo: " + calendar.get(Calendar.SECOND));

		System.out.println("Ano: " + (date.getYear() + 1900));
		System.out.println("Calendar ano: " + calendar.get(Calendar.YEAR));


		/*--------------------Simple Date Format--------------------*/

		/*SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm.ss");

		System.out.println("Data atual em formato padão e String: " + simpleDateFormat.format(date));
		System.out.println("Calendar Data atual em formato padão e String: " + simpleDateFormat.format(calendar.getTime()));
		
		simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm.ss");
		System.out.println("Data em formato para banco de dados: " + simpleDateFormat.format(date));
		System.out.println("Calendar Data em formato para banco de dados: : " + simpleDateFormat.format(calendar.getTime()));
		
		simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("Objeto date: " + simpleDateFormat.parse("1987-10-18"));
		
		simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		System.out.println("Objeto date: " + simpleDateFormat.parse("1987/10/18"));
		
		
		
		/*--------------------comparando datas--------------------*/
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		Date dataVencimentoBoleto = simpleDateFormat.parse("10/04/2021");
		
		Date dataAtualHoje = simpleDateFormat.parse("07/04/2021");
		
		/*se a data 1 é maior que a data 2*/
		if (dataVencimentoBoleto.after(dataAtualHoje)) {
			System.out.println("O boleto não vencido");
		}else {
			System.out.println("Boleto vencido - Urgente");
		}
		
		
		
		/*----------------------manipulando datas----------------------*/
		
		
		Calendar calendar = Calendar.getInstance();/*pega a data atual*/
		
		/*simular que a data vem do banco de dados*/
		
		calendar.setTime(new SimpleDateFormat("dd-MM-yyyy").parse("10-03-2021"));/*definindo uma data qualquer*/
		
		
		calendar.add(Calendar.DAY_OF_MONTH, 5);
		
		System.out.println("Somando dia do mes: " +  new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime()));
		
		
		calendar.add(Calendar.MONTH, 1);
		
		System.out.println("Somando o mes: " +  new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime()));
		
		
		calendar.add(Calendar.YEAR, 1);
		
		System.out.println("Somando o ano: " + new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime()));
		
		
		
		/*-------------------Faixa de tempo com ChronoUnit------------------------*/
		
		
		long dias = ChronoUnit.DAYS.between(LocalDate.parse("2021-06-01"), LocalDate.now());
		
		System.out.println("Possui " + dias + " dias entre a faixa de datas");
		
		
		/*-------------------gerando parcelas mensais e suas datas-----------------------------*/
		
			Date dataInicial = new SimpleDateFormat("dd/MM/yyyy").parse("10/04/2021");
			
			
			Calendar calendar2 = Calendar.getInstance();
			calendar2.setTime(dataInicial);
			
			for (int parcela = 1 ; parcela <= 12 ; parcela ++) {
				calendar2.add(Calendar.MONTH, 1);
				
				System.out.println("Parcela numero: " + parcela + " vencimento é em: "
				+ new SimpleDateFormat("dd/MM/yyyy").format(calendar2.getTime()));
			}
			
		
		/*-------------nova API de data a partir do Java 8 -----------------------*/
			
			LocalDate dataAtual = LocalDate.now(); /*Data Atual*/
			
			LocalTime horaAtual = LocalTime.now(); /*Hora Atual*/
			
			LocalDateTime dataAtualHoraAtual = LocalDateTime.now(); /*Data e Hora atual junto*/
			
		
			
		/*-------------exemplos de formatação------------------------------------*/
			
			System.out.println("Data e hora atual: " + dataAtualHoraAtual.format(DateTimeFormatter.BASIC_ISO_DATE));
			System.out.println("Data e hora atual: " + dataAtualHoraAtual.format(DateTimeFormatter.ISO_DATE));
			System.out.println("Data e hora atual: " + dataAtualHoraAtual.format(DateTimeFormatter.ISO_DATE_TIME));
			System.out.println("Data e hora atual: " + dataAtualHoraAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
			
			
		/*------------------------------dias, anos, meses e semanas-----------------------------*/
			
		LocalDate localDate = LocalDate.now();
		System.out.println("Data atual: " + localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

		System.out.println("Dia da semana: " + localDate.getDayOfWeek().name());
		
		System.out.println("Dia da semana: " + localDate.getDayOfMonth());
		
		System.out.println("Dia da semana: " + localDate.getDayOfYear());
		
		System.out.println("Mês: " + localDate.getMonthValue());
		
		System.out.println("Mês: " + localDate.getMonth());
			
		
		/*-----------------------------trabalhar com Instant------------------------------*/
		
		Instant inicio = Instant.now();
		
		Thread.sleep(2000);
		
		Instant ifinal = Instant.now();
		
		Duration duracao = Duration.between(inicio, ifinal);
		
		System.out.println("Duração em nanos segundos: " + duracao.toNanos());
		
		System.out.println("Duração em minutos: " + duracao.toMinutes());
		
		System.out.println("Duração em horas: " + duracao.toHours());
		
		System.out.println("Duração em milisegundos: " + duracao.toMillis());
		
		System.out.println("Duração em dias: " + duracao.toDays());




		
		
		
		
		
		
		
		
		
		

	}

}
