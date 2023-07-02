package com.leitnick.PacePursuit.dao;

import com.leitnick.PacePursuit.model.Run;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Component
public class JdbcRunDao implements RunDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcRunDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addRunList(List<Run> runList) {
        String sql = "INSERT INTO run " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, POINT(?, ?), POINT(?,?), ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        for (Run run : runList) {
            try {
                jdbcTemplate.update(sql, run.getId(), run.getName(), run.getDistance(), run.getMovingTime(),
                        run.getElapsedTime(), run.getTotalElevationGain(), run.getStartDate(),
                        run.getStartLatLng()[0], run.getStartLatLng()[1], run.getEndLatLng()[0], run.getEndLatLng()[1],
                        run.getAverageSpeed(), run.getMaxSpeed(), run.getAverageCadence(), run.getAverageHeartRate(),
                        run.getAverageHeartRate(), run.getMaxHeartRate(), run.getAverageWatts(),
                        run.getWeightedAverageWatts(), run.getKilojoules());
            } catch (DataAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Run getLastRun() {
        Run lastRun = new Run();
        String sql = "SELECT start_date FROM run ORDER BY start_date DESC LIMIT 1;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        if (results.next()) {
            lastRun.setStartDate(results.getTimestamp("start_date"));
        } else lastRun = null;
        return lastRun;
    }


}
