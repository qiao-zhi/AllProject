package MVC7;

import java.awt.event.*;
import javax.swing.*;
import java.net.URL;

class Controller implements ActionListener {
   private CarAuctionGUI objCarGui;
   private CarModel cm;
   private String carPrice;
   private String[] carList;

   public Controller(CarAuctionGUI objCarGui, CarModel cm) {
      this.objCarGui = objCarGui;
	  this.cm = cm;

	  carList = objCarGui.getCarList();
	  cm.setCarList(carList);
   }
   public void actionPerformed(ActionEvent e){
//      String searchResult = null;

      if (e.getActionCommand().equals(CarAuctionGUI.EXIT)){
         System.exit(1);
      }
      if (e.getActionCommand().equals(CarAuctionGUI.SEARCH)){
         String selectedCar = objCarGui.getSelectedCar();
		 cm.setSelectedCar(selectedCar);
		 cm.setFileUrl();
         cm.setupImageIcon();

         cm.setSearchBtnClickInfo(true);

         cm.notifyObservers();
         cm.setSearchBtnClickInfo(false);
      }
      if (e.getActionCommand().equals(CarAuctionGUI.BIT)){
	     carPrice = objCarGui.getBitPrice();
	     
	     //获取选择的汽车类型
	      String sCar= cm.getSelectedCar();
	      System.out.println(sCar);
	     //根据汽车类型对输入的值验证数据的有效性
	     if(cm.validateAuctionPrice(sCar,Double.valueOf(carPrice))) 
	    	 cm.setBitPrice(carPrice); 
	    	 //大于的话设置价格为新输入的价格
	     else cm.setBitPrice("illegal data!"); //小于的话设置输出为非法的数据

	     
		 cm.setBitBtnClickInfo(true);

		 cm.notifyObservers();
		 cm.setBitBtnClickInfo(false);
	  }
   }
} // End of class Controller

