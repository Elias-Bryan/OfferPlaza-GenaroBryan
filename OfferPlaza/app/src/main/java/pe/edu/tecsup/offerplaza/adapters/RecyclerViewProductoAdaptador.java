package pe.edu.tecsup.offerplaza.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pe.edu.tecsup.offerplaza.R;
import pe.edu.tecsup.offerplaza.models.ProductoModelo;

public class RecyclerViewProductoAdaptador extends RecyclerView.Adapter<RecyclerViewProductoAdaptador.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre,sede,stock,precio;
        ImageView imgProducto;

        public ViewHolder(View itemView) {
            super(itemView);
            nombre=(TextView)itemView.findViewById(R.id.tvpNombre);
            sede=(TextView)itemView.findViewById(R.id.tvpSede);
            stock=(TextView)itemView.findViewById(R.id.tvStock);
            precio=(TextView)itemView.findViewById(R.id.tvpPrecio);
            imgProducto=(ImageView)itemView.findViewById(R.id.imgProducto);
        }
    }
    public List<ProductoModelo> productoLista;

    public RecyclerViewProductoAdaptador(List<ProductoModelo> productoLista) {
        this.productoLista = productoLista;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.producto_lista,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nombre.setText(productoLista.get(position).getNombre());
        holder.sede.setText(productoLista.get(position).getSede());
        holder.stock.setText(productoLista.get(position).getStock());
        holder.precio.setText(productoLista.get(position).getPrecio());
        holder.imgProducto.setImageResource(productoLista.get(position).getImgProducto());
    }

    @Override
    public int getItemCount() {
        return productoLista.size();
    }
    public void filterList(ArrayList<ProductoModelo> filteredList){
        productoLista=filteredList;
        notifyDataSetChanged();
    }
}
