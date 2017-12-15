package edu.cnm.deepdive.temperature;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class TemperatureFragment extends Fragment implements OnClickListener {

  private Button fButton;
  private Button cButton;
  private EditText fahrenheitTemp;
  private EditText celciusTemp;


  public TemperatureFragment() {
    // Required empty public constructor
  }

//  // TODO: Rename and change types and number of parameters
//  public static TemperatureFragment newInstance(String param1, String param2) {
//    TemperatureFragment fragment = new TemperatureFragment();
//    Bundle args = new Bundle();
//    return fragment;
//  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);


  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    // Inflate the layout for this fragment
    View inflate = inflater.inflate(R.layout.fragment_temperature, container, false);
    fButton = inflate.findViewById(R.id.fahrenheit_to_celcius);
    fButton.setOnClickListener(this);
    cButton = inflate.findViewById(R.id.celcius_to_fahrenheit);
    cButton.setOnClickListener(this);
    fahrenheitTemp = inflate.findViewById(R.id.fahrenheit);
    //fahrenheitTemp.setText();
    celciusTemp = inflate.findViewById(R.id.celcius);
    return inflate;
  }


  @Override
  public void onClick(View view) {
    switch (view.getId( )) {
      case R.id.celcius_to_fahrenheit:
        double fTemp = Double.parseDouble(String.valueOf(celciusTemp.getText( )));
        double fahrenheitResult = (fTemp * 9) / 5 + 32;
        fahrenheitTemp.setText(Double.toString(fahrenheitResult));
        break;
      case R.id.fahrenheit_to_celcius:
        double cTemp = Double.parseDouble(String.valueOf(fahrenheitTemp.getText( )));
        double celciusResult = (cTemp - 32) * 5 / 9;
        celciusTemp.setText(Double.toString(celciusResult));
        break;
    }

    fahrenheitTemp.addTextChangedListener(new TextWatcher( ) {
      @Override
      public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

      }

      @Override
      public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

      }

      @Override
      public void afterTextChanged(Editable editable) {

      }
    });


  }

}