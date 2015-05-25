package es.uniovi.imovil.user.product;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class ProductListFragment extends Fragment implements AdapterView.OnItemClickListener {
    private ProductAdapter mAdapter = null;
    private int mCourseCount = 0;
    private Callbacks mCallback;

    public static ProductListFragment newInstance() {
        ProductListFragment fragment = new ProductListFragment();
        return fragment;
    }

    public ProductListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView; rootView = inflater.inflate(R.layout.fragment_product_list, container, false);

        String [] products = getResources().getStringArray(R.array.products);
        String [] types = getResources().getStringArray(R.array.types);
        String [] descriptions = getResources().getStringArray(R.array.descriptions);
        String [] colours = getResources().getStringArray(R.array.colours);
        String [] quantity= getResources().getStringArray(R.array.quantity);

        ListView lvItems =
                (ListView) rootView.findViewById(R.id.list_view_product);

        mAdapter = new ProductAdapter(getActivity(), createProductList(products, types, descriptions,colours,quantity));
        lvItems.setAdapter(mAdapter);
        lvItems.setOnItemClickListener(this);

        return rootView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Product product = (Product) parent.getItemAtPosition(position);
        mCallback.onProductSelected(product);
    }

    private List<Product> createProductList(String[] names, String[] types,
                                            String[] descriptions,String[] colours, String [] quantity) {

        if (names.length != types.length|| names.length != colours.length ||names.length !=quantity.length || descriptions.length!=names.length) {
            throw new IllegalStateException();
        }

        ArrayList<Product> products = new ArrayList<Product>(names.length);
        for (int i = 0; i < names.length; i++) {
            products.add(new Product(names[i], types[i], descriptions[i],colours[i],quantity[i]));
        }
        return products;
    }

    public void addProduct(Product product) {
        mAdapter.addProduct(product);
    }

    public interface Callbacks {
        public void onProductSelected(Product product);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (Callbacks) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement Callbacks");
        }
    }
}
