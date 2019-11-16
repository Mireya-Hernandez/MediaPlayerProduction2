package sample;

public class AudioPlayer  extends Product implements MultimediaControl {




  private String supportedAudioFormats;
  private String supportedPlaylistFormats;


  /**
   * The Audio Player class.
   * @param name A string for the name of the product.
   * @param manufacturer A string for manufacturer.
   * @param supportedAudioFormats A string for the type of audio format supported by the system.
   * @param supportedPlaylistFormats A string for play list format.
   */


  public AudioPlayer(String name, String manufacturer, String supportedAudioFormats,
      String supportedPlaylistFormats) {
    super(name, manufacturer,ItemType.AUDIO);
    this.supportedPlaylistFormats = supportedPlaylistFormats;
    this.supportedAudioFormats = supportedAudioFormats;
  }




  public void play() {
    System.out.println("Playing");
  }


  public void stop() {
    System.out.println("Stopping");

  }


  public void previous() {
    System.out.println("Previous");

  }


  public void next() {
    System.out.println("Next");

  }

  @Override
  public String toString() {

    return super.toString() + "\n" + " Supported Audio Formats:  " +  supportedAudioFormats + "\n"
        +  " Supported Playlist Formats: " + supportedPlaylistFormats;
  }
}
