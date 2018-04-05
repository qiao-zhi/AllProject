package bean;

public class Question {

	private String timu; //题干
	private String leixing;  //类型
	private String axuanxiang;  //A选项
	private String bxuanxiang;   //B选项
	private String cxuanxiang;   //C选项
	private String dxuanxiang;   //D选项
	private String daan;  		//答案
	private String jiexi;		//解析
	public String getTimu() {
		return timu;
	}
	public void setTimu(String timu) {
		this.timu = timu;
	}
	public String getLeixing() {
		return leixing;
	}
	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}

	public String getAxuanxiang() {
		return axuanxiang;
	}
	public void setAxuanxiang(String axuanxiang) {
		this.axuanxiang = axuanxiang;
	}
	public String getBxuanxiang() {
		return bxuanxiang;
	}
	public void setBxuanxiang(String bxuanxiang) {
		this.bxuanxiang = bxuanxiang;
	}
	public String getCxuanxiang() {
		return cxuanxiang;
	}
	public void setCxuanxiang(String cxuanxiang) {
		this.cxuanxiang = cxuanxiang;
	}
	public String getDxuanxiang() {
		return dxuanxiang;
	}
	public void setDxuanxiang(String dxuanxiang) {
		this.dxuanxiang = dxuanxiang;
	}
	public String getDaan() {
		return daan;
	}
	public void setDaan(String daan) {
		this.daan = daan;
	}
	public String getJiexi() {
		return jiexi;
	}
	public void setJiexi(String jiexi) {
		this.jiexi = jiexi;
	}
	@Override
	public String toString() {
		return "Question [timu=" + timu + ", leixing=" + leixing + ", axuanxiang=" + axuanxiang + ", bxuanxiang="
				+ bxuanxiang + ", cxuanxiang=" + cxuanxiang + ", dxuanxiang=" + dxuanxiang + ", daan=" + daan
				+ ", jiexi=" + jiexi + "]";
	}
	public Question(String timu, String leixing, String axuanxiang, String bxuanxiang, String cxuanxiang,
			String dxuanxiang, String daan, String jiexi) {
		super();
		this.timu = timu;
		this.leixing = leixing;
		this.axuanxiang = axuanxiang;
		this.bxuanxiang = bxuanxiang;
		this.cxuanxiang = cxuanxiang;
		this.dxuanxiang = dxuanxiang;
		this.daan = daan;
		this.jiexi = jiexi;
	}
	public Question() {
		super();
	}
	

	
}
