package com.leitnick.PacePursuit;

import com.leitnick.PacePursuit.view.View;
import com.leitnick.PacePursuit.view.Console;

public class App {

	public static void main(String[] args) {
		App app = new App();
		app.run();

	}

	private void run() {
		View view = new View(new Console());
		view.run();
	}

}
