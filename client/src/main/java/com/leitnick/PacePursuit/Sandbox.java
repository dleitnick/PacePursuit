package com.leitnick.PacePursuit;

import java.sql.Time;
import java.time.Instant;

public class Sandbox {
    public static void main(String[] args) {
        Sandbox sandbox = new Sandbox();
        sandbox.run();
    }

    public void run() {
//        Instant instant = Instant.now().getEpochSecond();
        System.out.println(Instant.now().getEpochSecond());
        System.out.println(1688150270);
    }
}
