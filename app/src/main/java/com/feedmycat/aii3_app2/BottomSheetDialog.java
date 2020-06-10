package com.feedmycat.aii3_app2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetDialog extends BottomSheetDialogFragment {

  private TextView description;
  private TextView barometer;

  private static final String ARG_DESCRIPTION = "argDescription";
  private static final String ARG_BAROMETER = "argBarometer";

  //Factory method for the BottomSheetFragment
  public static BottomSheetDialog newInstance(String description, float barometer) {
    BottomSheetDialog fragment = new BottomSheetDialog();
    Bundle args = new Bundle();
    args.putString(ARG_DESCRIPTION, description);
    args.putFloat(ARG_BAROMETER, barometer);
    fragment.setArguments(args);
    return fragment;
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.bottom_sheet_layout, container, false);

    description = v.findViewById(R.id.tv_description);
    barometer = v.findViewById(R.id.tv_pressure);

    description.setText(getArguments().getString(ARG_DESCRIPTION));
    float pressure = getArguments().getFloat(ARG_BAROMETER);
    barometer.setText(String.format("%.3f nbar", pressure));

    return v;
  }
}
