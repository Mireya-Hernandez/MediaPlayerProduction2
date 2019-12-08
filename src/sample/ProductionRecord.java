package sample;

import java.util.Date;


public class ProductionRecord {

  int productionNum;
  int productID;
  String serialNum;
  Date prodDate;

  /**
   * @param productionNum Integer for the production number so that user can identify the production.
   * @param productID     Product identification number in integer to allow user to identify the product.
   * @param serialNum     The serial number of a product provide as a string.
   * @param prodDate      The date the product was produced.
   */

  public ProductionRecord(int productionNum, int productID, String serialNum, Date prodDate) {
    this.productionNum = productionNum;
    this.productID = productID;
    this.serialNum = serialNum;
    this.prodDate = prodDate;//Unfixed Bug
  }

  /**
   * @param productProduced The product produce.
   * @param count           The loop count.
   */
  public ProductionRecord(Product productProduced, int count) {
    serialNum = "%05d" + count;
    //Unfixed Bug
    String newNum = productProduced.getManufacturer().substring(0, 3) + productProduced.getType();


  }

  @Override
  public String toString() {
    return "Prod. Num: " + productionNum + " Product ID: " + productID + " Serial Num: AppAU"
        + serialNum + " Date: " + new Date();

  }

  public int getProductionNum() {
    return productionNum;
  }

  public int getProductID() {
    return productID;
  }

  public String getSerialNum() {
    return serialNum;
  }

  public Date getProdDate() {
    return prodDate; //Unfixed Bug
  }

  public void setProductionNum(int count) {
    productionNum = count;
  }

  public void setProductID(int Id) {
    productID = Id;
  }

  public void setSerialNum(String serialNum, ItemType type) {
    this.serialNum = serialNum;

  }

  public void setProdDate(Date date) {
    prodDate = date;//Unfixed Bug

  }

  /**
   * @param productID Product identification.
   */
  public ProductionRecord(int productID) {
    productionNum = 0;
    serialNum = "0";
    prodDate = new Date();

  }
}
