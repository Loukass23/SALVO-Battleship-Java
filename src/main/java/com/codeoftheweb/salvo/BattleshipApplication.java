package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class BattleshipApplication {

	public static void main(String[] args) {
		System.out.println("hello");
		SpringApplication.run(BattleshipApplication.class, args);
	}
	@Bean
	public CommandLineRunner initData(GamePlayerRepository repositoryGamePlayer, GameRepository repositoryGame, PlayerRepository repositoryPlayer) {

		return (args) -> {
		//create Game
			Date firstDate = new Date();
			Game game1= new Game(firstDate);
			repositoryGame.save(game1);
			Date newDate = Date.from(firstDate.toInstant().plusSeconds(3600));
			Game game2= new Game( newDate);
			repositoryGame.save(game2);

			// save a couple of players
			Player player1 = new Player("Jack", "12345");
			Player player2 = new Player("Chloe", "qwert");
			Player player3 = new Player("Hans", "qwert");
			repositoryPlayer.save(player1);
			repositoryPlayer.save(player2);
			repositoryPlayer.save(player3);

			//create GamePlayer
			GamePlayer gameplayer1 = new GamePlayer(game1, player1, firstDate);
			GamePlayer gameplayer2 = new GamePlayer(game1, player2, firstDate);
			GamePlayer gameplayer3 = new GamePlayer(game2, player3, firstDate);
			repositoryGamePlayer.save(gameplayer1);
			repositoryGamePlayer.save(gameplayer2);
			repositoryGamePlayer.save(gameplayer3);

			game1.addGamePlayer(gameplayer1);
			game1.addGamePlayer(gameplayer2);
			repositoryGame.save(game1);
			System.out.println("hello2");
			//System.out.println(player1.getGames());

			player1.addGamePlayer(gameplayer1);
			player2.addGamePlayer(gameplayer2);
			repositoryPlayer.save(player1);
			repositoryPlayer.save(player2);

		};
	}
}
