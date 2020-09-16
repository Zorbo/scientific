package com.example.scientific.games.demo;


public class DemoApplication {

	public static void main(String[] args) throws Exception {
		GameFactory gameFactory = new GameFactory();
		System.out.println(gameFactory.createGames(1, 1) + "\n");
		System.out.println(gameFactory.createGames(2, 2) + "\n");
		System.out.println(gameFactory.createGames(3, 3) + "\n");
	}

}
