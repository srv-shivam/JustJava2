/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match the package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.justjava;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    StringBuilder priceMessage = new StringBuilder("Thank You!");
//    String priceMessage = "Thank You!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when increment button is clicked.
     */
    public void increment(View view) {
        ++quantity;
        display(quantity);
    }


    /**
     * This method is called when decrement button is clicked.
     */
    public void decrement(View view) {
            --quantity;
            display(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        display(quantity);
        displayPrice(quantity * 5);
        priceMessage.replace(0, priceMessage.length(), "Thank You!");
        displayMessage(priceMessage);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView;
        quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method resets the quantity value to zero when clicked
     */
    public void resetQuantity(View view) {
        reset();
        resetMsg();
        display(quantity);
        displayPrice(quantity * 5);
        displayMessage(priceMessage);
    }

    /**
     * This method reset the value of quantity
     */
    private void reset() {
        quantity = 0;
    }

    /**
     * This method resets the message displayed
     */

    private void resetMsg() {
        priceMessage.replace(0, priceMessage.length(), " ");
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance(new Locale("en", "IN")).format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(StringBuilder message) {
        TextView priceTextView = (TextView) findViewById(R.id.thank_you_msg);
        priceTextView.setText(message);
    }
}