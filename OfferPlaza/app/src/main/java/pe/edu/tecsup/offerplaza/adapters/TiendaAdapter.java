package pe.edu.tecsup.offerplaza.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pe.edu.tecsup.offerplaza.R;
import pe.edu.tecsup.offerplaza.models.RetroEmpresa;

public class TiendaAdapter extends RecyclerView.Adapter<TiendaAdapter.EmpresaViewHolder> {
    private List<RetroEmpresa> dataList;
    private Context context;

    public TiendaAdapter(Context context, List<RetroEmpresa> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public EmpresaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.tienda_lista, parent, false);
        return new EmpresaViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull EmpresaViewHolder holder, int position) {
        holder.txtTitle.setText(dataList.get(position).getNombre());
        holder.txtproducto.setText(dataList.get(position).getProductos());
        holder.txtlikes.setText(dataList.get(position).getLikes());
        /*Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(dataList.get(position).getLogo())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(holder.coverImage);*/
    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }
    public class EmpresaViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        TextView txtTitle,txtproducto,txtlikes;
        private ImageView coverImage;
        public EmpresaViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            txtTitle = mView.findViewById(R.id.tvt_Nombre);
            txtproducto = mView.findViewById(R.id.tvt_nProducto);
            txtlikes = mView.findViewById(R.id.tvt_encorazona);
            //txtProducto = mView.findViewById(R.id.producto);
            //coverImage = mView.findViewById(R.id.coverImage);
        }
    }
}

