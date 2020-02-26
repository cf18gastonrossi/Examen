package com.example.myapplication.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.Model.Event;
import com.example.myapplication.R;
import com.example.myapplication.database.Repository;

public class EsdevenimentFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_event_edit, container, false);
        EditText nombre= root.findViewById(R.id.nombreDetailEditText);
        EditText fecha= root.findViewById(R.id.fechaDetailEditText);
        EditText lugar = root.findViewById(R.id.lugarDetailEditText);
        EditText organizador= root.findViewById(R.id.organizadorEditText);
        EditText sala= root.findViewById(R.id.salaEditText);
        EditText precio = root.findViewById(R.id.precioEditText);
        EditText descripcion= root.findViewById(R.id.descripcionEditText);
        EditText aforo = root.findViewById(R.id.aforoEditText);
        Button confirm = root.findViewById(R.id.confirmarButton);

        confirm.setOnClickListener(v -> Repository.registerNewEvent(new Event(nombre.getText().toString(),fecha.getText().toString(),lugar.getText().toString(),organizador.getText().toString(),sala.getText().toString(),Integer.parseInt(precio.getText().toString()),Integer.parseInt(aforo.getText().toString()),descripcion.getText().toString())));
        return root;
    }
}