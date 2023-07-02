package com.leitnick.PacePursuit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PacePursuitApplication {

	public static void main(String[] args) {
		SpringApplication.run(PacePursuitApplication.class, args);
		PacePursuitApplication app = new PacePursuitApplication();
		System.out.println(app.statusMessage("Server Started"));
	}

	private String statusMessage(String message) {
		String esc = "\u001b";
		String greenBg = esc + "[42m";
		String blackBg = esc + "[40m";
		String bold = esc + "[1m";
		String reset = esc + "[0m";
		return String.format("%s   %s%s %s %s   %s", greenBg, blackBg, bold, message.toUpperCase(), greenBg, reset);
	}

}
