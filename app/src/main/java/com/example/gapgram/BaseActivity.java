package com.example.gapgram;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;
public abstract class BaseActivity<T extends ViewBinding> extends AppCompatActivity {

    protected T binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout using View Binding
        binding = inflateBindingLayout();
        setContentView(binding.getRoot()); }
    @Override
    public void onResume() {
        super.onResume(); }
    @Override
    public void onDestroy() {
        super.onDestroy(); }

    @Override
    public void onStart() {
        super.onStart();}

    @Override
    public void onStop() {
        super.onStop();
    }

    public abstract int setContentView();
    /**
     * Method to return the ViewBinding object for the activity's layout.
     * Subclasses must implement this method to provide the correct binding.
     */
    protected abstract T inflateBindingLayout();

    // The VerticalAdapter class remains unchanged as it doesn't interact with View Binding
    public static class VerticalAdapter {
    }


}
