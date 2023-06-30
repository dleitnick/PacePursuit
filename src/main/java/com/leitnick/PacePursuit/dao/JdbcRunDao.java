package com.leitnick.PacePursuit.dao;

import com.leitnick.PacePursuit.model.Run;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
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
//                "(run_id, name, distance, moving_time, elapsed_time, total_elevation_gain, start_date, start_latlng, end_latlng, " +
//                "average_speed, max_speed, average_cadence, average_heartrate, max_heartrate, average_watts, max_watts, weighted_average_watts) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, POINT(?, ?), POINT(?,?), ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        for (Run run : runList) {
            try {
                jdbcTemplate.update(sql, run.getId(), run.getName(), run.getDistance(), run.getMovingTime(), run.getElapsedTime(),
                        run.getTotalElevationGain(), run.getStartDate(), run.getStartLatLng()[0], run.getStartLatLng()[1], run.getEndLatLng()[0], run.getEndLatLng()[1], run.getAverageSpeed(),
                        run.getMaxSpeed(), run.getAverageCadence(), run.getAverageHeartRate(), run.getAverageHeartRate(), run.getMaxHeartRate(),
                        run.getAverageWatts(), run.getWeightedAverageWatts(), run.getKilojoules());
            } catch (DataAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
