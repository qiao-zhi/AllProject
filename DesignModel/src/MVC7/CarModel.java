package MVC7;
import java.io.*;
import java.net.URL;
import java.net.URI;
import javax.swing.*;
import java.util.*;

public class CarModel implements Observable{
    private Vector<Observer> observersList;
    private ImageIcon imgIcon;
    private URL url;
    private String[] carNameList;
	private String carSelected;
    private String bitPrice;
    
	
	public String getBitPrice() {
		return bitPrice;
	}

	public void setBitPrice(String bitPrice) {
		this.bitPrice = bitPrice;
	}


	private double[ ] currentBitPrices={1,1,1,1};
	private double[ ] preBitPrices={0,0,0,0};
    public double[] getCurrentBitPrices() {
		return currentBitPrices;
	}

	public void setCurrentBitPrices(double[] currentBitPrices) {
		this.currentBitPrices = currentBitPrices;
	}

	public double[] getPreBitPrices() {
		return preBitPrices;
	}

	public void setPreBitPrices(double[] preBitPrices) {
		this.preBitPrices = preBitPrices;
	}
	
	
	private boolean isBitBtnClicked = false;
    private boolean isSearchBtnClicked = false;
    static final String CARFILES = "CarFiles/";
    static final String CARIMAGES = "CarImages/";
    
    
    //验证竞拍价的有效性
    public boolean validateAuctionPrice(String car,double d){
    	boolean validate = true;
    	if(car.equals("HondaAccord-2005")){
    		currentBitPrices[0]=d;
    		if(this.currentBitPrices[0]<this.preBitPrices[0]) validate=false;
    		else 
    			{
    			this.preBitPrices[0]=this.currentBitPrices[0];
    			}
    	}    	
    	if(car.equals("Honda Civic-2006")){
    		currentBitPrices[1]=d;
    		if(this.currentBitPrices[1]<this.preBitPrices[1]) validate=false;
    		else
    			{
    			this.preBitPrices[1]=this.currentBitPrices[1];
    			}
    	}
    	if(car.equals("Toyota Camry-2003")){
    		currentBitPrices[2]=d;
    		if(this.currentBitPrices[2]<=this.preBitPrices[2]) validate=false;
    		else 
			{
			this.preBitPrices[2]=this.currentBitPrices[2];
			}
    	}
    	
    	
    	if(car.equals("Toyota Corolla-2002")){
    		currentBitPrices[3]=d;
    		if(this.currentBitPrices[3]<this.preBitPrices[3]) validate=false;
    		else 
			{
			this.preBitPrices[3]=this.currentBitPrices[3];
			}
    	}
    	   	
        return validate;
    }
    
    public CarModel(){
          observersList = new Vector<Observer>();
          carNameList=new String[200];
  	}
    public void setCarList(String[] cars){
		  carNameList = cars;
	}
    public String[] getCarList(){
	      return  carNameList;
    }
    public void setSelectedCar(String sCar){
          carSelected = sCar;
  	}
  	public String getSelectedCar(){
	      return carSelected;
  	}
/*  	public void setBitPrice(String bPrice){
		  bitPrice = "";
		  bitPrice = bitPrice + bPrice;
	}
	public String getBitPrice(){
		  return bitPrice;
	}*/
	public void setFileUrl(){
	      try{
		        String fileURLStr = CARFILES + carSelected+ ".html";
		        URI uri = (new File(fileURLStr)).toURI();
		        url = uri.toURL();
		  }
		  catch (IOException e){
		        e.printStackTrace();
		 }
	}
	public URL getCarFileURL(){
		 return url;
	}
    public void setupImageIcon(){
	     String iconStr = CARIMAGES + carSelected+".jpg";
         imgIcon = createImageIcon(iconStr);
	}
    public ImageIcon getImageIcon(){
	     return imgIcon;
	}
    public void setBitBtnClickInfo(boolean opt){
	     isBitBtnClicked = opt;
	}
	public boolean isBitBtnClicked(){
	     return isBitBtnClicked;
	}
    public void setSearchBtnClickInfo(boolean opt){
	     isSearchBtnClicked = opt;
	}
	public boolean isSearchBtnClicked(){
	     return isSearchBtnClicked;
	}
    public void register(Observer obs){
	     observersList.addElement(obs);
    }
    public void notifyObservers() {
         for (int i = 0; i < observersList.size(); i++) {
              Observer observer = (Observer) observersList.get(i);
			  observer.update(this);
         }
    }
    protected ImageIcon createImageIcon(String path){
        java.net.URL imgURL = getClass().getResource(path);
//        this.getClass().getResource(path)
        System.out.println(path);
        if (imgURL != null) {
              return new ImageIcon(imgURL);
        }
        else {
             System.err.println("Couldn't find file: " + path);
             return null;
        }
  }

/*	public String getBitPrice(String car) {
		String value="";
		if(car.equals("camery")){
			value =  String.valueOf(this.currentBitPrices[2]);
		}
		return value;
	}*/

/*	public void setBitPrice(String car,String carPrice) {
		// TODO Auto-generated method stub
		if(car.equals("camery")){
			this.currentBitPrices[2] =  Double.valueOf(carPrice);
		}
	}
    */
    
    
}