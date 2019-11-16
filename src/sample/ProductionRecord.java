package sample;

import java.util.Date;


public class ProductionRecord {

  int productionNum;
  int productID;
  String serialNum;
  Date prodDate;

  /**
   *
   * @param productionNum
   * @param productID
   * @param serialNum
   * @param prodDate
   */
  public ProductionRecord ( int productionNum, int productID, String serialNum, Date prodDate) {
    this.productionNum = productionNum;
    this.productID = productID;
    this.serialNum = serialNum;
    this.prodDate = prodDate;
  }

  /**
   *
   * @param productProduced
   * @param count
   */
  public ProductionRecord(Product productProduced, int count) {
    serialNum =  "0000" + count;
    //productProduced.getManufacturer().substring(0,3) + Item.Type().code +



  }

  @Override
  public String toString() {
    return "Prod. Num: " + productionNum +  " Product ID: " + productID + " Serial Num: AppAU"
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
    return prodDate;
  }

  public void setProductionNum(int count) {
    productionNum = count;
  }

  public void setProductID(int Id) {
    productID = Id;
  }

  public void setSerialNum(String serialNum,  ItemType type) {
    this.serialNum = serialNum;

  }

  public void setProdDate(Date date) {
    prodDate = date;

  }

  /**
   *
   * @param productID
   */
  public ProductionRecord(int productID) {
    productionNum = 0;
    serialNum = "0";
    prodDate = new Date();

  }
}
