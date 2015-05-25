package es.uniovi.imovil.user.product;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ProductAdapter extends BaseAdapter {
	
	static class ViewHolder {
		public TextView mProductName;
		public TextView mTypeName;
	}
	
	private final List<Product> mProducts;
	public LayoutInflater mInflater;

	
	public ProductAdapter(Context context, List<Product> products) {

		if (context == null || products == null ) {
			throw new IllegalArgumentException();
		}
			
		this.mProducts = products;
		this.mInflater = LayoutInflater.from(context);
	}
		
	@Override
	public int getCount() {

		return mProducts.size();
	}

	@Override
	public Object getItem(int position) {
		
		return mProducts.get(position);
	}

	@Override
	public long getItemId(int position) {

		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View rowView = convertView;
		ViewHolder viewHolder;
		if (rowView == null) {
			rowView = mInflater.inflate(R.layout.list_item_product2, parent, false);
			viewHolder = new ViewHolder();
			viewHolder.mProductName = (TextView) rowView.findViewById(R.id.nameTextView);
			viewHolder.mTypeName = (TextView) rowView.findViewById(R.id.typeTextView);
			rowView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) rowView.getTag();
		}
		
		Product product = (Product) getItem(position);
		viewHolder.mProductName.setText(product.getName());
		viewHolder.mTypeName.setText(product.getTeacher());
		
		return rowView;
	}
	
	public void addProduct(Product product) {
		
		if (product == null) {
			throw new IllegalArgumentException();			
		}
		
		mProducts.add(product);
		
		// Importante: notificar que ha cambiado el dataset
		notifyDataSetChanged();
	}
}
