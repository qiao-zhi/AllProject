package six;

public class User {
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	protected User(String username) {
		super();
		this.username = username;
	}
	public void buyGuPiao(Gupiao gp){
		gp.buy(this);
		System.out.println(this.username+":您购买的股票价格为"+gp.getPrice());
	}
	public void getPrice(Gupiao gp,double bianhua){
		System.out.println(this.username+":您购买的股票价格发生了变化，原价为:"+(gp.getPrice()-bianhua)+",变化幅度是"+bianhua);
	}
}
