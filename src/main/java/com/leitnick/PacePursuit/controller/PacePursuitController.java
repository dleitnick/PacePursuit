package com.leitnick.PacePursuit.controller;

import com.leitnick.PacePursuit.dao.ApiDao;
import com.leitnick.PacePursuit.dao.RunDao;
import com.leitnick.PacePursuit.model.ApiKey;
import com.leitnick.PacePursuit.model.Run;
import com.leitnick.PacePursuit.service.StravaService;
import com.leitnick.PacePursuit.view.BasicConsole;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;

@RestController
public class PacePursuitController {

    private ApiDao apiDao;
    private RunDao runDao;

    public PacePursuitController(ApiDao apiDao, RunDao runDao) {
        this.apiDao = apiDao;
        this.runDao = runDao;
        run();
    }

    public void run() {
        ApiKey apiKey = apiDao.getApiKeyByName("Strava");
        StravaService strava = new StravaService(apiKey);
        if(!strava.isApiTokenActive(apiKey)) {
            apiDao.updateApiKeyByName(strava.refreshApiToken());
        }
        List<Run> newRuns = strava.listOfRuns(runDao.getLastRun());
//        List<Run> runs = strava.listOfRuns();
        runDao.addRunList(newRuns);
        if (newRuns.size() > 0) System.out.println(newRuns.get(0));
        else System.out.println("Empty list");
    }

}
