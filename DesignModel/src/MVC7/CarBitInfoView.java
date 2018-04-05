package MVC7;


public class CarBitInfoView implements Observer{

    private CarModel model;
    private CarAuctionGUI cg;

	public CarBitInfoView(CarModel cmodel,CarAuctionGUI cg) {
       model = cmodel;
       this.cg=cg;
    }
    public void update(Observable subject){
       if ( (subject == model) && (model.isBitBtnClicked())){
          String sCar= model.getSelectedCar();
		  String pr = model.getBitPrice();
		  String prc="";
		  if(pr.equals("illegal data!")){
			 prc="\n 您的报价错误,不能低于该车的最低报价！";
		  }
		  else
			  prc="\n Bit price for "+ sCar + " : "+ pr;
          
          cg.showBitPrice(prc);
       }
     }
}// end of class


