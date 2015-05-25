package es.uniovi.imovil.user.product;

public class Product {
	
	private String mName;
	private String mType;
	private String mDescription;
	private String mQuantity;

	public Product(String name, String type, String description,String quantity) {
		
		if (name == null || type == null || name.isEmpty() || type.isEmpty()) {
			throw new IllegalArgumentException();
		}
		
		mName = name;
		mType = type;
        mDescription = description;
		mQuantity = quantity;
	}

	public String getName() {
		return mName;
	}

	public String getTeacher() {
		return mType;
	}

    public String getDescription(){
        return mDescription;
    }

	public String getQuantity(){return mQuantity;}
}
