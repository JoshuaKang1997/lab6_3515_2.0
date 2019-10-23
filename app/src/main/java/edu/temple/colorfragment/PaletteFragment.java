package edu.temple.colorfragment;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Spinner;

public class PaletteFragment extends Fragment {
    private OnFragmentInteractionListener listener;
    public PaletteFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_palette, container, false);
        Spinner spinner = view.findViewById(R.id.spinner);

        String[] colors = getResources().getStringArray(R.array.color);
        ColorAdapter adapter = new ColorAdapter(this.getActivity(), colors);
        spinner.setAdapter(adapter);
        spinner.setSelection(0, false);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                view.setBackgroundColor(Color.parseColor("White"));
                listener.displayNewColor(adapterView.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

        });
        return view;

    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
    //Interface allow interaction in this fragment to be communicated
    // to the activity and other fragments using the activity
    interface OnFragmentInteractionListener {
        void displayNewColor(String colorValue);
    }
}