package com.leitnick.PacePursuit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.TimeZone;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Run {
    private long id;
    private String name;
    private double distance;
    @JsonProperty("moving_time")
    private int movingTime;
    @JsonProperty("elapsed_time")
    private int elapsedTime;
    @JsonProperty("total_elevation_gain")
    private double totalElevationGain;
    @JsonProperty("start_date")
    private Timestamp startDate;
    @JsonProperty("start_latlng")
    private BigDecimal[] startLatLng;
    @JsonProperty("end_latlng")
    private BigDecimal[] endLatLng;
    @JsonProperty("average_speed")
    private double averageSpeed;
    @JsonProperty("max_speed")
    private double maxSpeed;
    @JsonProperty("average_cadence")
    private double averageCadence;
    @JsonProperty("average_heartrate")
    private double averageHeartRate;
    @JsonProperty("max_heartrate")
    private double maxHeartRate;
    @JsonProperty("average_watts")
    private double averageWatts;
    @JsonProperty("max_watts")
    private double maxWatts;
    @JsonProperty("weighted_average_watts")
    private double weightedAverageWatts;
    private double kilojoules;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getMovingTime() {
        return movingTime;
    }

    public void setMovingTime(int movingTime) {
        this.movingTime = movingTime;
    }

    public int getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(int elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public double getTotalElevationGain() {
        return totalElevationGain;
    }

    public void setTotalElevationGain(double totalElevationGain) {
        this.totalElevationGain = totalElevationGain;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public BigDecimal[] getStartLatLng() {
        if (startLatLng.length == 0) {
            startLatLng = new BigDecimal[]{BigDecimal.valueOf(0), BigDecimal.valueOf(0)};
        }
        return startLatLng;
    }

    public void setStartLatLng(BigDecimal[] startLatLng) {
        this.startLatLng = startLatLng;
    }

    public BigDecimal[] getEndLatLng() {
        if (endLatLng.length == 0) {
            endLatLng = new BigDecimal[]{BigDecimal.valueOf(0), BigDecimal.valueOf(0)};
        }
        return endLatLng;
    }

    public void setEndLatLng(BigDecimal[] endLatLng) {
        this.endLatLng = endLatLng;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getAverageCadence() {
        return averageCadence;
    }

    public void setAverageCadence(double averageCadence) {
        this.averageCadence = averageCadence;
    }

    public double getAverageHeartRate() {
        return averageHeartRate;
    }

    public void setAverageHeartRate(double averageHeartRate) {
        this.averageHeartRate = averageHeartRate;
    }

    public double getMaxHeartRate() {
        return maxHeartRate;
    }

    public void setMaxHeartRate(double maxHeartRate) {
        this.maxHeartRate = maxHeartRate;
    }

    public double getAverageWatts() {
        return averageWatts;
    }

    public void setAverageWatts(double averageWatts) {
        this.averageWatts = averageWatts;
    }

    public double getMaxWatts() {
        return maxWatts;
    }

    public void setMaxWatts(double maxWatts) {
        this.maxWatts = maxWatts;
    }

    public double getWeightedAverageWatts() {
        return weightedAverageWatts;
    }

    public void setWeightedAverageWatts(double weightedAverageWatts) {
        this.weightedAverageWatts = weightedAverageWatts;
    }

    public double getKilojoules() {
        return kilojoules;
    }

    public void setKilojoules(double kilojoules) {
        this.kilojoules = kilojoules;
    }

    @Override
    public String toString() {
        return "Run{" +
                "\nid=" + id +
                ", \nname='" + name + '\'' +
                ", \ndistance=" + distance +
                ", \nmovingTime=" + movingTime +
                ", \nelapsedTime=" + elapsedTime +
                ", \ntotalElevationGain=" + totalElevationGain +
                ", \nstartDate=" + startDate +
                ", \nstartLatLng=" + Arrays.toString(startLatLng) +
                ", \nendLatLng=" + Arrays.toString(endLatLng) +
                ", \naverageSpeed=" + averageSpeed +
                ", \nmaxSpeed=" + maxSpeed +
                ", \naverageCadence=" + averageCadence +
                ", \naverageHeartRate=" + averageHeartRate +
                ", \nmaxHeartRate=" + maxHeartRate +
                ", \naverageWatts=" + averageWatts +
                ", \nmaxWatts=" + maxWatts +
                ", \nweightedAverageWatts=" + weightedAverageWatts +
                ", \nkilojoules=" + kilojoules +
                '}';
    }
}
