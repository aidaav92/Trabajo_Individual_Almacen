package es.uniovi.imovil.user.product;

public class Product {
	
	private String mName;
	private String mType;
	private String mDescription;
    private String mColour;
	private String mQuantity;

	public Product(String name, String type, String description,String colour,String quantity) {
		
		if (name == null || type == null || name.isEmpty() || type.isEmpty()) {
			throw new IllegalArgumentException();
		}
		
		mName = name;
		mType = type;
        mDescription = description;
        mColour=colour;
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

    public String getColour(){return mColour;}

	public String getQuantity(){return mQuantity;}
}
