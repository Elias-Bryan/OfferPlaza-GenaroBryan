package pe.edu.tecsup.offerplaza.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pe.edu.tecsup.offerplaza.R;
import pe.edu.tecsup.offerplaza.models.EmpresaModelo;

public class RecyclerViewEmpresaAdaptador extends RecyclerView.Adapter<RecyclerViewEmpresaAdaptador.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre,sede;
        RatingBar rating;
        ImageView imgEmpresa;

        public ViewHolder(View itemView) {
            super(itemView);
            nombre=(TextView)itemView.findViewById(R.id.tveNombre);
            sede=(TextView)itemView.findViewById(R.id.tveSede);
            rating=(RatingBar)itemView.findViewById(R.id.ratingBarEmpre);
            imgEmpresa=(ImageView)itemView.findViewById(R.id.imgEmpresa);
        }
    }
    public List<EmpresaModelo> empresaLista;

    public RecyclerViewEmpresaAdaptador(List<EmpresaModelo> empresaLista) {
        this.empresaLista = empresaLista;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.empresa_lista,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nombre.setText(empresaLista.get(position).getNombre());
        holder.sede.setText(empresaLista.get(position).getSede());
        holder.rating.setProgress(empresaLista.get(position).getRating());
        holder.imgEmpresa.setImageResource(empresaLista.get(position).getImgEmpresa());
    }

    @Override
    public int getItemCount() {
        return empresaLista.size();
    }
}
