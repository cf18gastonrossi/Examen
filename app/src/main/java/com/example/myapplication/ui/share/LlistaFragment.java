package com.example.myapplication.ui.share;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.Event;
import com.example.myapplication.R;

import com.example.fichapp.data.RoomConnection;
import java.util.ArrayList;

public class LlistaFragment extends Fragment {

    private LlistaViewModel llistaViewModel;

    private RecyclerView miRecycler;
    private ArrayList<Event> llistaEvent;
    private EventsAdapter miAdapter;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        llistaViewModel =
                ViewModelProviders.of(this).get(LlistaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_llista, container, false);

        miRecycler = root.findViewById(R.id.llistatRecycler);
        miRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        miRecycler.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));

        miAdapter = new EventsAdapter();
        miRecycler.setAdapter(miAdapter);

        llistaViewModel.getLlistat().observe(getViewLifecycleOwner(), new Observer<ArrayList<Event>>() {
            @Override
            public void onChanged(ArrayList<Event> events) {
                llistaEvent = events;
                miAdapter.notifyDataSetChanged();

            }
        });


        return root;
    }

    private class UsuariViewHolder extends RecyclerView.ViewHolder{

        TextView eventName;
        TextView date;
        TextView site;

        public UsuariViewHolder(@NonNull View itemView) {
            super(itemView);

            eventName = itemView.findViewById(R.id.eventName);
            date = itemView.findViewById(R.id.date);
            site = itemView.findViewById(R.id.eventSite);

            //Aqui definim que fem en clickar un element
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Genero un bundle on afegiré l'usuari on han fet click
                    Bundle bundle = new Bundle();
                    bundle.putInt("POSICIO", getAdapterPosition());
                    //Utilitzo getAdapterPosition per coneixer quin element haig de mostrar
                    bundle.putSerializable("DETALL", llistaEvent.get(getAdapterPosition()));
                    //Utilitzo Navigation per canviar pantalla, encara que també serveir FragmentManager
                    Navigation.findNavController(view).navigate(R.id.nav_llistatdetall, bundle);
                }
            });


        }
    }

    private class EventsAdapter extends RecyclerView.Adapter<UsuariViewHolder> {

        public EventsAdapter(){};

        @NonNull
        @Override
        public UsuariViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new UsuariViewHolder(getLayoutInflater().inflate(R.layout.viewholder_event, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull UsuariViewHolder holder, int position) {

            holder.eventName.setText(llistaEvent.get(position).getEmail());
            holder.date.setText(llistaEvent.get(position).getFecha());
            holder.site.setText(llistaEvent.get(position).getPlace());
        }

        @Override
        public int getItemCount() {
            return llistaEvent.size();
        }
    }
}