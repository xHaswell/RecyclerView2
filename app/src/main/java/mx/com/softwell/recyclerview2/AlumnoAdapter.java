package mx.com.softwell.recyclerview2;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AlumnoAdapter extends RecyclerView.Adapter<AlumnoAdapter.ViewHolder> {

    List<Alumno> alumnos;
    Context context;
    OnClickListener listener;

    public AlumnoAdapter(List<Alumno> alumnos, OnClickListener listener) {
        this.alumnos = alumnos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_alumno, viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Alumno alumno = alumnos.get(i);
        viewHolder.txtNombre.setText(alumno.getNombre());
        viewHolder.txtNoControl.setText(alumno.getNoControl());
        viewHolder.setOnClikListener(alumno, listener);
    }

    @Override
    public int getItemCount() {
        return alumnos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombre;
        TextView txtNoControl;
        View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombre=itemView.findViewById(R.id.txtNombre);
            txtNoControl = itemView.findViewById(R.id.txtNoControl);
            view = itemView;
        }

        void setOnClikListener(final Alumno alumno, final OnClickListener listener){
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClickListener(alumno);
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.onLongClickListener(alumno);
                    return true;
                }
            });
        }
    }

    public interface OnClickListener{
        void onClickListener(Alumno alumno);
        void onLongClickListener(Alumno alumno);
    }
}
