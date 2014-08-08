package com.example.mycalculator;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	private int[] myDigitID = { R.id.zero, R.id.one, R.id.two, R.id.three, R.id.four, R.id.five, R.id.six, R.id.seven, R.id.eight, R.id.nine, R.id.dot, R.id.clear };
	// private int[] myOperatorID = { R.id.add, R.id.sub, R.id.mul, R.id.div,
	// R.id.equal, R.id.sign };
	private ArrayList<Button> myButtons = new ArrayList<Button>();
	TextView resultView;
	Caculator myCaculator;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		myCaculator = new Caculator();
		initDigitButtonListener();
		initOperatorButtonListener();
		resultView = (TextView) findViewById(R.id.result);
	}

	private void initOperatorButtonListener() {
		// add
		findViewById(R.id.add).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				myCaculator.add(resultView.getText().toString());
				resultView.setText("0");
			}
		});

		// sub
		findViewById(R.id.sub).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				myCaculator.sub(resultView.getText().toString());
				resultView.setText("0");
			}
		});

		// mul
		findViewById(R.id.mul).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				myCaculator.mul(resultView.getText().toString());
				resultView.setText("0");
			}
		});

		// div
		findViewById(R.id.div).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				myCaculator.div(resultView.getText().toString());
				resultView.setText("0");
			}
		});

		// equal
		findViewById(R.id.equal).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				resultView.setText(myCaculator.Caculate(resultView.getText().toString()));
			}
		});

		// sign
		findViewById(R.id.sign).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if (Float.valueOf(resultView.getText().toString()) != 0) {
					resultView.setText(String.valueOf(-Float.valueOf(resultView.getText().toString())));
				}
			}
		});
	}

	private void initDigitButtonListener() {
		for (int i : myDigitID) {
			Button button = (Button) findViewById(i);
			button.setOnClickListener(this);
			myButtons.add(button);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View view) {
		handleDigit(view);

	}

	private void handleDigit(View view) {
		Button button = (Button) view;

		// protect its may have dots
		if (resultView.getText().toString().equals("0")) {
			resultView.setText("");
		}

		// clear
		if (view.getId() == R.id.clear) {
			resultView.setText("0");
			return;
		}
		// protect its may have dots
		if (view.getId() == R.id.dot && resultView.getText().toString().contains(button.getText())) {
			return;
		}

		resultView.append(button.getText());
	}

}
