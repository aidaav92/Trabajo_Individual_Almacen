package es.uniovi.imovil.user.product;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class ProductDetailsFragment extends Fragment implements
        View.OnClickListener {
    private static final String DESCRIPTION_ARG = "description";
    private static final String QUANTITY_ARG="quantity";

    private TextView textViewDescription, textViewQuantity;
    private EditText editTextQuantityAdd;
    private Button btninput, btnpoutput;
    private String[] mproductstring;
    private int valora, valorb, total, mCurrentQuestion;
    private String mString;

    public static ProductDetailsFragment newInstance(String desc,String quantity) {
        ProductDetailsFragment fragment = new ProductDetailsFragment();
        Bundle args = new Bundle();
        args.putString(DESCRIPTION_ARG, desc);
        args.putString(QUANTITY_ARG,quantity);
        fragment.setArguments(args);
        return fragment;
    }

    public ProductDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflamos el Layout
        View rootView;
        rootView = inflater.inflate(R.layout.fragment_product_details, container, false);
        Bundle args = getArguments();

        textViewDescription = (TextView) rootView.findViewById(R.id.tvDescription);
        textViewQuantity=(TextView)rootView.findViewById(R.id.textViewCantidad);

        if (args != null) {
            String desc = args.getString(DESCRIPTION_ARG);
            String quant =args.getString(QUANTITY_ARG);
            textViewDescription.setText(desc);
            textViewQuantity.setText(quant);
        }

        //Cargar array de productos
        mproductstring = getResources().getStringArray(R.array.products);

        // Botones y sus respectivos listeners
        btninput = (Button) rootView.findViewById(R.id.buttonInput);
        btnpoutput = (Button) rootView.findViewById(R.id.buttonOutput);
        btnpoutput.setOnClickListener(this);
        btninput.setOnClickListener(this);

        //Edit Text Cantidad add
        editTextQuantityAdd = (EditText) rootView.findViewById(R.id.ed_e_s);


        return rootView;
    }

    public void setDescription(String text) {
        if (textViewDescription != null) {
            textViewDescription.setText(text);
        }
    }

    public void setQuantity(String mtext){
        if(textViewQuantity!=null) {
         textViewQuantity.setText(mtext);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonInput:
                addInput();
                break;

            case R.id.buttonOutput:
                addOutput();
                break;
        }

    }

    private void addInput() {
        mString=textViewQuantity.getText().toString();
        valorb=Integer.parseInt(mString);
        valora = Integer.valueOf(editTextQuantityAdd.getText().toString());
        total = valora + valorb;
        String resultado = String.valueOf(total);
        textViewQuantity.setText(resultado);
    }

    private void addOutput() {
        mString=textViewQuantity.getText().toString();
        valora=Integer.parseInt(mString);
        valorb = Integer.valueOf(editTextQuantityAdd.getText().toString());
        total = valora - valorb;
        String resultado = String.valueOf(total);
        textViewQuantity.setText(resultado);
    }

}
