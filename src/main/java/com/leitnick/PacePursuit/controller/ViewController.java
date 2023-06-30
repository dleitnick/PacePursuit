package com.leitnick.PacePursuit.controller;

import com.leitnick.PacePursuit.view.BasicConsole;
import com.leitnick.PacePursuit.view.View;

public class ViewController {
    private final BasicConsole console;
    private final View view;

    public ViewController(BasicConsole console) {
        this.console = console;
        view = new View(console);
    }

    public void run() {
        console.printBanner("Pace Pursuit: Run tracker\nTracking pace progress\nGathering statistics");
        console.printHeader("Pull runs from Strava");
        console.printSubHeader("ChatGPT Opinion");
    }
}
