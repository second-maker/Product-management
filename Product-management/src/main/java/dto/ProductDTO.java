package dto;

public class ProductDTO {
	
	private String productName;
	private String categoryName;
	private int price;
	
	public ProductDTO() {
		
	}
	
	public ProductDTO(String productName, String categoryName, int price) {
		
		this.productName = productName;
		this.categoryName = categoryName;
		this.price = price;
		
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
