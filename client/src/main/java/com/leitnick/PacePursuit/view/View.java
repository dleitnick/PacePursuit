package com.leitnick.PacePursuit.view;


public class View {

    private final BasicConsole console;
    private final Menu menu = new Menu();

    public View(BasicConsole console) {
        this.console = console;
    }

    public void run() {
        console.printBanner("Pace Pursuit: Run tracker\nTracking pace progress\nGathering statistics");
        menu.getMainMenu();
        console.printHeader("Pull runs from Strava");
        console.printSubHeader("ChatGPT Opinion");
    }
}
