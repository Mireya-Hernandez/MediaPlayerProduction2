package sample;

public class Screen implements ScreenSpec {

  String resolution;
  int refreshrate;
  int responsetime;

  public Screen(String s, int i, int i1) {
  }

  @Override
  public String getResolution() {
    return null;
  }

  @Override
  public int getRefreshRate() {
    return 0;
  }

  @Override
  public int getResponseTime() {
    return 0;
  }

  public String toString() {
    return "Resolution: " + resolution + "\n" + "Refresh Rate: " + refreshrate +
        "Response Time: " + responsetime;
  }
}
