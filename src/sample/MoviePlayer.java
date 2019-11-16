package sample;

public class MoviePlayer extends Product implements MultimediaControl {
  private Screen screen;
  private MonitorType monitor; //Mismatch pattern

  /**
   * MoviePlayer class focus on movie player products.
   * @param name is a String and indicates the name of the product.
   * @param manufacturer is given in a String it indicates the manufacturer the product is from.
   * @param screen is a screen type it indicates the size and other specification of the screen.
   * @param Monitor is a enum MonitorType data type and focus on the monitor specs.
   */
  public MoviePlayer(String name, String manufacturer, Screen screen, MonitorType Monitor) {
    super(name, manufacturer, ItemType.VISUAL);
    this.screen = screen;
    this.monitor = Monitor;
  }

  public void play() {
    System.out.println("Playing movie");
  }


  public void stop() {
    System.out.println("Stopping movie");

  }


  public void previous() {
    System.out.println("Previous movie");
  }


  public void next() {
    System.out.println("Next movie");
  }

  @Override
  public String toString() {

    return super.toString() + "\n" + " Screen:  " + screen + "\n" + " Monitor Type: " + monitor;
  }
}