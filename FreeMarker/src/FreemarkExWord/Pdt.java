package FreemarkExWord;

public class Pdt {

	private String pdth;
	private String pdtg;
	private String img;
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getPdth() {
		return pdth;
	}
	public void setPdth(String pdth) {
		this.pdth = pdth;
	}
	public String getPdtg() {
		return pdtg;
	}
	public void setPdtg(String pdtg) {
		this.pdtg = pdtg;
	}
	public Pdt(String pdth, String pdtg) {
		super();
		this.pdth = pdth;
		this.pdtg = pdtg;
	}
	public Pdt(String pdth, String pdtg, String img) {
		super();
		this.pdth = pdth;
		this.pdtg = pdtg;
		this.img = img;
	}
	
}
