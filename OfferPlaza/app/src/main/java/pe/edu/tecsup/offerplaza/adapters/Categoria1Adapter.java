package pe.edu.tecsup.offerplaza.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

import pe.edu.tecsup.offerplaza.R;
import pe.edu.tecsup.offerplaza.models.RetroEmpresa;
import pe.edu.tecsup.offerplaza.models.RetroProducto;

public class Categoria1Adapter extends RecyclerView.Adapter<Categoria1Adapter.Categoria1ViewHolder> {
    private List<RetroProducto> dataList;
    private Context context;

    public Categoria1Adapter(Context context, List<RetroProducto> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public Categoria1ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.categoria_lista, parent, false);

        return new Categoria1ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Categoria1ViewHolder holder, int position) {
        holder.nombre.setText(dataList.get(position).getNombre());
        holder.descuento.setText(dataList.get(position).getDescuento());
        holder.precio.setText(dataList.get(position).getPrecio());
        holder.fechatermino.setText(dataList.get(position).getFechaTermino());

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(dataList.get(position).getImagen())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(holder.imgProducto);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class Categoria1ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView nombre,descuento,fechatermino,precio;
        private ImageView imgProducto;


        public Categoria1ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            nombre = mView.findViewById(R.id.tvpNombre);
            descuento = mView.findViewById(R.id.tvpDescuento);
            fechatermino = mView.findViewById(R.id.tvpFecha);
            precio = mView.findViewById(R.id.tvpPrecio);
            imgProducto = mView.findViewById(R.id.tvpImgProducto);
        }
    }
}

