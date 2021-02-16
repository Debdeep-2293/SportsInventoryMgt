package net.sports.management.model;

/**
 * User.java
 * This is a model class represents a User entity
 * @author IIMD
 *
 */
public class Sports {
        protected String productid;
	protected String product;
	protected String model;
	protected String manufacturer;
	protected String typecode;
	protected Double msrp;
	protected Double unitcost;
	protected Double discountrate;
	protected int stockqty;
	
	public Sports() {
	}
	
	public Sports(String product, String model, String manufacturer, String typecode, Double msrp, Double unitcost, Double discountrate, int stockqty) {
		super();
		this.product = product;
		this.model = model;
		this.manufacturer = manufacturer;
		this.typecode = typecode;
		this.msrp = msrp;
		this.unitcost = unitcost;
		this.discountrate = discountrate;
		this.stockqty = stockqty;
	}

	public Sports(String productid, String product, String model, String manufacturer, String typecode, Double msrp, Double unitcost, Double discountrate, int stockqty) {
		super();
		this.productid = productid;
		this.product = product;
		this.model = model;
		this.manufacturer = manufacturer;
		this.typecode = typecode;
		this.msrp = msrp;
		this.unitcost = unitcost;
		this.discountrate = discountrate;
		this.stockqty = stockqty;
	}

	public String getproductid() {
		return productid;
	}
	public void setproductid(String productid) {
		this.productid = productid;
	}
	public String getproduct() {
		return product;
	}
	public void setproduct(String product) {
		this.product = product;
	}
	public String getmodel() {
		return model;
	}
	public void setmodel(String model) {
		this.model = model;
	}
	public String getmanufacturer() {
		return manufacturer;
	}
	public void setmanufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
        public String gettypecode() {
		return typecode;
	}
        public void settypecode(String typecode) {
		this.typecode = typecode;
	}
        public Double getmsrp() {
		return msrp;
	}
	public void setmsrp(Double msrp) {
		this.msrp = msrp;
	}
        public Double getunitcost() {
		return unitcost;
	}
	public void setunitcost(Double unitcost) {
		this.unitcost = unitcost;
	}
        public Double getdiscountrate() {
		return discountrate;
	}
	public void setdiscountrate(Double discountrate) {
		this.discountrate = discountrate;
	}
        public int getstockqty() {
		return stockqty;
	}
	public void setstockqty(int stockqty) {
		this.stockqty = stockqty;
	}

}
