package po;


public class Rfid {

  private int id;
  private String card_id;
  private String type;


  public long getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCard_id() {
    return card_id;
  }

  public void setCard_id(String card_id) {
    this.card_id = card_id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "Rfid{" +
            "id=" + id +
            ", card_Id=" + card_id +
            ", type='" + type + '\'' +
            '}';
  }
}
