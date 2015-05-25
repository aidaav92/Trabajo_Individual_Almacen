package es.uniovi.imovil.user.product;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class ProductDetailsActivity extends ActionBarActivity {
    public static final String DESCRIPTION = "es.uniovi.imovil.user.product.DESCRIPTION";
    public static final String QUANTITY = "es.uniovi.imovil.user.product.QUANTITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Intent intent = getIntent();
        String description = intent.getStringExtra(DESCRIPTION);
        String quantity = intent.getStringExtra(QUANTITY);

        if (findViewById(R.id.fragment_container) != null) {
            // Si estamos restaurando desde un estado previo no hacemos nada
            if (savedInstanceState != null) {
                return;
            }
            // Crear el fragmento pasándole el parámetro
            ProductDetailsFragment fragment = ProductDetailsFragment.newInstance(description,quantity);
            // Añadir el fragmento al contenedor 'fragment_container'
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_product_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            //noinspection SimplifiableIfStatement
            case R.id.action_about:
                Intent goToAbout = new Intent(this, AboutActivity.class);
                startActivity(goToAbout);
                return true;

            case R.id.action_quit:
                Toast.makeText(this, getString(R.string.action_quit),
                        Toast.LENGTH_SHORT).show();
                finish(); // close the activity
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}