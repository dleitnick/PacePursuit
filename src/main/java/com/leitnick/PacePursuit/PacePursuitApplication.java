package com.leitnick.PacePursuit;

import com.leitnick.PacePursuit.controller.PacePursuitController;
import com.leitnick.PacePursuit.controller.ViewController;
import com.leitnick.PacePursuit.dao.ApiDao;
import com.leitnick.PacePursuit.dao.JdbcApiDao;
import com.leitnick.PacePursuit.service.StravaService;
import com.leitnick.PacePursuit.view.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PacePursuitApplication {

	public static void main(String[] args) {
		SpringApplication.run(PacePursuitApplication.class, args);
		ViewController controller = new ViewController(new Console());
		controller.run();

	}

}
