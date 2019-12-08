package sample;

public enum MonitorType {
  LCD("LCD"), LED("LED");

  private String label;

  MonitorType(String c) {
    label = c;
  }
}