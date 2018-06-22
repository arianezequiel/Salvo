package com.accenture.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class SalvoApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(SalvoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(PlayerRepository playerRepository, GameRepository gameRepository)
	{
		return (args) ->
		{
			Player player1=new Player("J.Bauer");
			Player player2=new Player("C. Obrian");
			Player player3=new Player("T. Almeida");
			Player player4=new Player("Kim. Bauer");

			playerRepository.save(player1);
			playerRepository.save(player2);
			playerRepository.save(player3);
			playerRepository.save(player4);

			Date date = new Date();
			Date date1= Date.from(date.toInstant().plusSeconds(3600));
			Date date2= Date.from(date.toInstant().plusSeconds(7200));
			Game game1= new Game(date);
			Game game2= new Game(date1);
			Game game3= new Game(date2);

			gameRepository.save(game1);
			gameRepository.save(game2);
			gameRepository.save(game3);

			GamePlayer gamePlayer1=new GamePlayer(game1, player1);
			GamePlayer gamePlayer2=new GamePlayer(game1, player2);
			GamePlayer gamePlayer3=new GamePlayer(game2, player2);
			GamePlayer gamePlayer4=new GamePlayer(game2, player3);
		};
	}

}