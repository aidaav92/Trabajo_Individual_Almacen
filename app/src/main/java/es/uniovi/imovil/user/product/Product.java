package es.uniovi.imovil.user.product;

public class Product {
	
	private String mName;
	private String mType;
	private String mDescription;

	public Product(String name, String type, String description) {
		
		if (name == null || type == null || name.isEmpty() || type.isEmpty()) {
			throw new IllegalArgumentException();
		}
		
		mName = name;
		mType = type;
        mDescription = description;
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
}
