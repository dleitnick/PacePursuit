package com.leitnick.PacePursuit.view;

import java.util.*;

public class Menu {

    public static final String RUN_DATA = "run data";
        public static final String BY_ID = "run by ID";
        public static final String BY_DATE = "run by date";
        public static final String TOTAL_STATS = "cumulative running statistics";
        public static final String TOTAL_STATS_BY_DATE = "cumulative running statistics during range of time";
        public static final String PERSONAL_BEST = "personal bests";
    public static final String GOALS = "goals";
        public static final String VIEW_GOALS = "track goal progress";
        public static final String CREATE_GOAL = "create new goal";
    public static final String AI = "RunAI's opinion on the data";
        public static final String RECENT_PROGRESS = "how RunAI thinks the most recent run compares to the last 5 runs";
        public static final String TIPS = "what RunAI thinks I can do to improve";
        public static final String MOTIVATION = "motivation from RunAI";
    public static final String WEATHER = "weather for future runs";
        public static final String WEATHER_ON_DATE = "weather on a certain date in the future";

    public void getMainMenu() {

    }

    public Map<String, List<String>> menuMap() {
        Map<String, List<String>> menu = new LinkedHashMap<>();
        menu.put(RUN_DATA, List.of(BY_ID, BY_DATE, TOTAL_STATS, TOTAL_STATS_BY_DATE, PERSONAL_BEST));
        menu.put(GOALS, new ArrayList<>(List.of(VIEW_GOALS, CREATE_GOAL)));
        menu.get(GOALS).add("GOALLIE");
        return menu;
    }
}
