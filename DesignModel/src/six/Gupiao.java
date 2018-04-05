package six;

import java.util.ArrayList;
import java.util.List;

public class Gupiao {

	private double price;
	private double oldPrice;
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	/**********创建股票时候设置价格**/
	protected Gupiao(double price) {
		super();
		this.price = price;
		this.oldPrice=price;
	}



	List<User> list=new ArrayList<User>();
	public void buy(User user){
		list.add(user);
	}

	public void change(double bianhua) {
		this.setPrice(this.price + bianhua);
		System.out.println("改变后价格:" + this.getPrice());
		System.out.println(this.oldPrice + " " + this.getPrice());
		double bianhuafudu = this.getPrice()-this.oldPrice ;
		System.out.println("变化幅度" + bianhuafudu);
		if (Math.abs(bianhuafudu) > 0.05) {
			if (this.oldPrice < this.getPrice()) {
				for (User user : list) {
					user.getPrice(this, bianhuafudu);
				}
			} else {
				for (User user : list) {
					user.getPrice(this, bianhuafudu);
				}
			}
			this.oldPrice =this.getPrice();
		}

	}
		
		
	
		
	}

	
	

