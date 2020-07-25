package pe.edu.tecsup.offerplaza.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pe.edu.tecsup.offerplaza.R;
import pe.edu.tecsup.offerplaza.models.TiendaModelo;

public class RecyclerViewTiendaAdaptador extends RecyclerView.Adapter<RecyclerViewTiendaAdaptador.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre;
        private TextView n_producto;
        private TextView likes;
        ImageView imgTienda;

        public ViewHolder(View itemView) {
            super(itemView);
            nombre=(TextView)itemView.findViewById(R.id.tvt_Nombre);
            n_producto=(TextView)itemView.findViewById(R.id.tvt_nProducto);
            likes=(TextView)itemView.findViewById(R.id.tvt_encorazona);
            imgTienda=(ImageView)itemView.findViewById(R.id.imgTienda);
        }
    }
    public List<TiendaModelo> tiendaLista;

    public RecyclerViewTiendaAdaptador(List<TiendaModelo> tiendaLista) {
        this.tiendaLista = tiendaLista;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.tienda_lista,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nombre.setText(tiendaLista.get(position).getNombre());
        holder.likes.setText(tiendaLista.get(position).getLike());
        holder.n_producto.setText(tiendaLista.get(position).getN_producto());
        holder.imgTienda.setImageResource(tiendaLista.get(position).getImgTienda());
    }

    @Override
    public int getItemCount() { return tiendaLista.size();
    }
}
