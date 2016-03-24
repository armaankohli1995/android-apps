package com.firstapp.myapplication;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Catalogue extends Fragment {


    public String product,subproduct;
    Spinner ProductSpinner,SubProductSpinner;
    Button GetListButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_catalogue, container, false);
        ProductSpinner = (Spinner)mView.findViewById(R.id.ProductSpinner);
        SubProductSpinner = (Spinner)mView.findViewById(R.id.SubProductSpinner);
        GetListButton = (Button)mView.findViewById(R.id.GetListButton);

        product = ProductSpinner.getSelectedItem().toString();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getContext(), R.array.Products, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ProductSpinner.setAdapter(adapter);
        String compareValue = "some value";
        if (!compareValue.equals(null)) {
            int spinnerPosition = adapter.getPosition(compareValue);
            ProductSpinner.setSelection(spinnerPosition);
        }

       ProductSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

           public void onItemSelected(AdapterView<?> parentView,
                                      View selectedItemView, int position, long id) {
               product = ProductSpinner.getSelectedItem().toString();
               //Object item = parentView.getItemAtPosition(position);

               // Depend on first spinner value set adapter to 2nd spinner
               if (position == 1) {
                   ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                           getContext(), R.array.CentreDrills, android.R.layout.simple_spinner_item);
                   adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                   SubProductSpinner.setAdapter(adapter);
                   subproduct = SubProductSpinner.getSelectedItem().toString();
               } else if (position == 2) {
                   ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                           getContext(), R.array.EndMills, android.R.layout.simple_spinner_item);
                   adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                   SubProductSpinner.setAdapter(adapter);
                   subproduct = SubProductSpinner.getSelectedItem().toString();
               } else if (position == 3) {
                   ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                           getContext(), R.array.GroundThreadTaps, android.R.layout.simple_spinner_item);
                   adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                   SubProductSpinner.setAdapter(adapter);
                   subproduct = SubProductSpinner.getSelectedItem().toString();
               } else if (position == 4) {
                   ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                           getContext(), R.array.MillingCutters, android.R.layout.simple_spinner_item);
                   adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                   SubProductSpinner.setAdapter(adapter);
                   subproduct = SubProductSpinner.getSelectedItem().toString();
               } else if (position == 5) {
                   ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                           getContext(), R.array.Reamers, android.R.layout.simple_spinner_item);
                   adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                   SubProductSpinner.setAdapter(adapter);
               } else if (position == 6) {
                   ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                           getContext(), R.array.TwistDrills, android.R.layout.simple_spinner_item);
                   adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                   SubProductSpinner.setAdapter(adapter);
               } else if (position == 7) {
                   ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                           getContext(), R.array.SolidCarbide, android.R.layout.simple_spinner_item);
                   adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                   SubProductSpinner.setAdapter(adapter);
               } else if (position == 8) {
                   ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                           getContext(), R.array.MachineTools, android.R.layout.simple_spinner_item);
                   adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                   SubProductSpinner.setAdapter(adapter);
               }

           }


           public void onNothingSelected(AdapterView<?> arg0) {// do nothing


           }


       });



        GetListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                subproduct = SubProductSpinner.getSelectedItem().toString();
                if (product.equals("Centre Drills")) {
                    if (subproduct.equals("Centre Drills")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Centre%20Drills/TD%20A2%20-%20Centre%20Drills.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Centre Drills", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Counter Sinks")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Centre%20Drills/TD%20A3%20-%20CounterSinks.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Counter Sinks", Toast.LENGTH_SHORT).show();
                    }
                }
                if (product.equals("End Mills")) {
                    Toast.makeText(getContext(), "End Mills", Toast.LENGTH_SHORT).show();
                    if (subproduct.equals("Nomenclature")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/End%20Mills/EM%201%20-%20Nomenclature.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Nomenclature", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Parallel Shank")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/End%20Mills/EM%202%20-%20Parallel%20Shank.pdf "); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Parallel Shank", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Taper Shank")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/End%20Mills/EM%203%20-%20Taper%20Shank.pdf "); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Taper Shank", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Slot Drills")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/End%20Mills/EM%204%20-%20Slot%20Drills.pdf "); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Slot Drills", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Woodruff Key Clutters")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/End%20Mills/EM%205%20-%20Woodruff%20Key%20Cutters.pdf "); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Woodruff Key Clutters", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("T Slot Cutters")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/End%20Mills/EM%206%20-%20T%20Slot%20Cutters.pdf "); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "T Slot Cutters", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Screwed Shank")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/End%20Mills/EM%207%20-%20Screwed%20Shank.pdf "); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Screwed Shank", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Hole Mills")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/End%20Mills/EM%208%20-%20Hole%20Mills.pdf "); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Hole Mills", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Roughing End Mills")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/End%20Mills/EM%209%20-%20Roughing%20End%20Mills.pdf "); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Roughing End Mills", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Roughing Shell End Mills")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/End%20Mills/EM%20A1%20-%20Roughing%20Shell%20End%20Mills.pdf "); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Roughing Shell End Mills", Toast.LENGTH_SHORT).show();
                    }

                } else if (product.equals("Ground Thread Taps")) {
                    if (subproduct.equals("Nomenclature")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Ground%20Thread%20Taps/GTT%201%20-%20Nomenclature.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Nomenclature", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Hand and Short Machine Taps")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Ground%20Thread%20Taps/GTT%202%20-%20Hand%20&%20Short%20Machine%20Taps.pdf "); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Hand and Short Machine Taps", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Long Shank Machine Taps")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Ground%20Thread%20Taps/GTT%203%20-%20Long%20Shank%20Machine%20Taps.pdf "); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Hand and Short Machine Taps", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Nut Taps")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Ground%20Thread%20Taps/GTT%204%20-%20Nut%20Taps.pdf "); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Nut Taps", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Hand Taps")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Ground%20Thread%20Taps/GTT%205%20-%20Hand%20Taps.pdf  "); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Hand Taps", Toast.LENGTH_SHORT).show();
                    }

                } else if (product.equals("Milling Cutters")) {
                    if (subproduct.equals("Nomenclature")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Milling%20Cutters/ML%201%20-%20Nomenclature.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Nomenclature", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("CylindricalCutters")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Milling%20Cutters/ML%202%20-%20Cylindrical%20Cutters.pdf "); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "CylindricalCutters", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Side and Face Cutters")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Milling%20Cutters/ML%203%20-%20Side%20and%20Face%20Cutters.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Side and Face Cutters", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Slotting Cutters")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Milling%20Cutters/ML%204%20-%20Slotting%20Cutters.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Slotting Cutters", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Metal Sitting Saws")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Milling%20Cutters/ML%205%20-%20Metal%20Slitting%20Saws.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Metal Sitting Saws", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Keyway Milling Cutters")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Milling%20Cutters/ML%206%20-%20Keyway%20Milling%20Cutters.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Keyway Milling Cutters", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Shell End Single Angle Milling")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Milling%20Cutters/ML%207%20-%20Shell%20End%20Single%20Angle%20Milling%20Cutters.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Shell End Single Angle Milling", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Single Angle Cutters")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Milling%20Cutters/ML%208%20-%20Single%20Angle%20Cutters.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Single Angle Cutters", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Double Angle Cutters")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Milling%20Cutters/ML%209%20-%20Double%20Angle%20Cutters.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Double Angle Cutters", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Equal Angle Cutters")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Milling%20Cutters/ML%20A1%20-%20Equal%20Angle%20Cutters.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Equal Angle Cutters", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Convex Milling Cutters")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Milling%20Cutters/ML%20A2%20-%20Convex%20Milling%20Cutters.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Convex Milling Cutters", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Concave Cutters")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Milling%20Cutters/ML%20A3%20-%20Concave%20Cutters.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Concave Cutters", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Single Corner Rounding Cutters")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Milling%20Cutters/ML%20A4%20-%20Single%20Corner%20Rounding%20Cutters.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Single Corner Rounding Cutters", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Gear Cutters")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Milling%20Cutters/ML%20A5%20-%20Gear%20Cutters.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Gear Cutters", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Rotary Form Cutters")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Milling%20Cutters/ML%20A6%20-%20Rotary%20Form%20Cutters.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Rotary Form Cutters", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Shell End Mills")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Milling%20Cutters/ML%20A7%20-%20Shell%20End%20Mills.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Shell End Mills", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Face Cutters")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Milling%20Cutters/ML%20A8%20-%20Face%20Cutters.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Face Cutters", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Hollow Mills")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Milling%20Cutters/ML%20A9%20-%20Hollow%20Mills.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Hollow Mills", Toast.LENGTH_SHORT).show();
                    }


                } else if (product.equals("Reamers")) {
                    if (subproduct.equals("Nomenclature")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Reamers/RM%201%20-%20Nomenclature.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Nomenclature", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Parallel Hand Reamers")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Reamers/RM%202%20-%20Parallel%20Hand%20Reamers.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Parallel Hand Reamers", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Long Flute Machine Reamers")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Reamers/RM%203%20-%20Long%20Flute%20Machine%20Reamers.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Long Flute Machine Reamers", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Machine Jig Reamers")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Reamers/RM%204%20-%20Machine%20Jig%20Reamers.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Machine Jig Reamers", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Chucking Reamers")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Reamers/RM%205%20-%20Chucking%20Reamers.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Chucking Reamers", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Shell Reamers")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Reamers/RM%206%20-%20Shell%20Reamers.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Shell Reamers", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Shell Core Drills")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Reamers/RM%207%20-%20Shell%20Core%20Drills.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Shell Core Drills", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Shell Drills")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Reamers/RM%208%20-%20Shell%20Drills.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Shell Drills", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Socket Reamers")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Reamers/RM%209%20-%20Socket%20Reamers.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Socket Reamers", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Pin Reamers")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Reamers/RM%20A1%20-%20Pin%20Reamers.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Pin Reamers", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Machine Bridge Reamers")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Reamers/RM%20A2%20-%20Machine%20Bridge%20Reamers.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Machine Bridge Reamers", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Centre Reamers")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Reamers/RM%20A3%20-%20Centre%20Reamers.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Centre Reamers", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Counter Bores")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Reamers/RM%20A4%20-%20Counter%20Bores.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Counter Bores", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Counter Sinks")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Reamers/RM%20A5%20-%20Counter%20Sinks.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Counter Sinks", Toast.LENGTH_SHORT).show();
                    }

                } else if (product.equals("Twist Drills")) {
                    if (subproduct.equals("Nomenclature")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Twist%20Drills/TD%201%20-%20Nomenclature.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Nomenclature", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("PSTD(ISS) Jobber Series")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Twist%20Drills/TD%202%20-%20PSTD(ISS)%20Jobber%20Series.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "PSTD(ISS) Jobber Series", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("PSTD(BSS) Jobbers Series")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Twist%20Drills/TD%203%20-%20PSTD%20(BSS)%20Jobbers%20Series.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "PSTD(BSS) Jobbers Series  ", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("HSS PSTD Stub Series")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Twist%20Drills/TD%204%20-%20HSS%20PSTD%20Stub%20Series.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "HSS PSTD Stub Series", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("HSS PSTD Long Series")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Twist%20Drills/TD%205%20-%20HSS%20PSTD%20Long%20Series.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "HSS PSTD Long Series", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("HSS PSTD Ex. Long Series")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Twist%20Drills/TD%206%20-%20HSS%20PSTD%20Ex.%20Long%20Series.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "HSS PSTD Ex. Long Series", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("PSTD Reduced Shank")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Twist%20Drills/TD%20B1%20-%20PSTD%20Reduced%20Shank.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "PSTD Reduced Shank", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Silver and Deming Drills")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Twist%20Drills/TD%206%20-%20Silver%20&%20Deming%20Drills.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Silver and Deming Drills", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("TSTD")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Twist%20Drills/TD%207%20-%20TSTD.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "TSTD", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("TSTD Long Series")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Twist%20Drills/TD%208%20-%20TSTD%20Long%20Series.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "TSTD Long Series", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("TSTD Ex. Long Series")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Twist%20Drills/TD%209%20-%20TSTD%20Ex.%20Long%20Series.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "TSTD Ex. Long Series", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("TS Core Drills")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Twist%20Drills/TD%20A1%20-%20TS%20Core%20Drills.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "TS Core Drills", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("SubLand Parallel Shank")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Twist%20Drills/TD%20A4%20-%20SubLand%20Parallel%20Shank.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "SubLand Parallel Shank", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Subland Taper Shank")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Twist%20Drills/TD%20A5%20-%20Subland%20Taper%20Shank.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Subland Taper Shank", Toast.LENGTH_SHORT).show();
                    }


                } else if (product.equals("Solid Carbide")) {
                    if (subproduct.equals("Stright Shank Drills")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Solid%20Carbide/SC%201%20-%20Stright%20Shank%20Drills.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Stright Shank Drills", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Stepped Shank Drills-internal collent holes")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Solid%20Carbide/SC%202%20-%20Stepped%20Shank%20Drills%20-%20internal%20coolent%20holes.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Stepped Shank Drills-internal collent holes", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Collant Burnishing Drills")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Solid%20Carbide/SC%203%20-%20Coolant%20Burnishning%20Drills.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Collant Burnishing Drills", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Central Drills")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Solid%20Carbide/SC%204%20-%20Central%20Drills%20.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Central Drills", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("Parallel Shank")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Solid%20Carbide/SC%205%20-%20Parallel%20Shank.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Parallel Shank", Toast.LENGTH_SHORT).show();
                    } else if (subproduct.equals("End Mill")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Solid%20Carbide/SC%206%20-%20End%20Mill.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "End Mill", Toast.LENGTH_SHORT).show();
                    }


                } else if (product.equals("Machine Tools")) {
                    if (subproduct.equals("Machine Tools")) {
                        Uri uri = Uri.parse("http://www.addison.co.in/Product%20Catalogue/Machine%20Tools/MT%201%20-%20Machine%20Tools.pdf"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        Toast.makeText(getContext(), "Machine Tools", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
        return mView;
    }


}
