package sample;

public enum MonitorType {
  LCD("LCD"), LED("LED");

  public String label;
  MonitorType(String c ){
    label = c ;
  }
}