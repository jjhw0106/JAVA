package day5.inner.example;

public class GameRepo implements Repo {
	Game[] games = new Game[5];

	GameRepo() {
		games[0] = new Game("월요일게임", 1);
		games[1] = new Game("화요일게임", 0);
		games[2] = new Game("수요일게임", 1);
		games[3] = new Game("목요일게임", 0);
		games[4] = new Game("금요일게임", 1);
	}

	public Stats getStats() {
		return new GameStats();
	}

	private class GameStats implements Stats {

		@Override
		public int total() {
			int win = 0;
			for (Game game : games) {
				win += game.win;
			}
			return win;
		}

		@Override
		public int average() {
			return (total() * 100) / games.length;
		}

	}


}
