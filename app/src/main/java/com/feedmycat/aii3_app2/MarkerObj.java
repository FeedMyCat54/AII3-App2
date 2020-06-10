package com.feedmycat.aii3_app2;

public class MarkerObj {
  private String title;
  private double latitude;
  private double longitude;
  private String description;
  private String color;
  private float barometer;

  public MarkerObj() {

  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public float getBarometer() {
    return barometer;
  }

  public void setBarometer(float barometer) {
    this.barometer = barometer;
  }
}
