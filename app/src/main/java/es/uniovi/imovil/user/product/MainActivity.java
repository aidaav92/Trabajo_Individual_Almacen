package es.uniovi.imovil.user.product;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity implements ProductListFragment.Callbacks {
    private int mProductCount = 0;
    private boolean mTwoPanes = false;
    private SearchView mSearchView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        if (findViewById(R.id.product_details_container) != null) {
            mTwoPanes = true;
        }
    }

	private List<Product> createProductList(String[] names, String[] types,
                                            String[] descriptions,String[] quantity) {
		
		if (names.length != types.length) {
			throw new IllegalStateException();
		}
			
		ArrayList<Product> products = new ArrayList<Product>(names.length);
		for (int i = 0; i < names.length; i++) {
			products.add(new Product(names[i], types[i], descriptions[i],quantity[i]));
		}
		return products;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflar el men� y a�adir acciones al action bar si existe
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
@Override
	public boolean onOptionsItemSelected(MenuItem item) {

	    switch (item.getItemId()) {
            case R.id.action_cancel:
                Toast.makeText(this, getString(R.string.action_quit), Toast.LENGTH_SHORT).show();
                finish(); // close the activity
                return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

    @Override
    public void onProductSelected(Product product) {
        if ( !mTwoPanes ) {
            Intent intent = new Intent(this, ProductDetailsActivity.class);
            intent.putExtra(ProductDetailsActivity.QUANTITY,product.getQuantity());
            intent.putExtra(ProductDetailsActivity.DESCRIPTION, product.getDescription());
            startActivity(intent);
        } else {
            FragmentManager fragmentManager = getSupportFragmentManager();
            ProductDetailsFragment fragment = (ProductDetailsFragment)
                    fragmentManager.findFragmentById(R.id.product_details_frag);
            fragment.setQuantity(product.getQuantity());
            fragment.setDescription(product.getDescription());
        }

    }


}
