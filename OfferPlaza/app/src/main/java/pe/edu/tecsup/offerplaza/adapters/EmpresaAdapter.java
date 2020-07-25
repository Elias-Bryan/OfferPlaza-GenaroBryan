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

public class EmpresaAdapter extends RecyclerView.Adapter<EmpresaAdapter.EmpresaViewHolder> {
    private List<RetroEmpresa> dataList;
    private Context context;

    public EmpresaAdapter(Context context, List<RetroEmpresa> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public EmpresaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.empresas_lista, parent, false);

        return new EmpresaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmpresaViewHolder holder, int position) {
        holder.nombre.setText(dataList.get(position).getNombre());
        holder.likes.setText(dataList.get(position).getLikes());
        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(dataList.get(position).getLogo())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(holder.imgEmpresa);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class EmpresaViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView nombre,likes;
        private ImageView imgEmpresa;


        public EmpresaViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            nombre = mView.findViewById(R.id.tve_nombre);
            likes = mView.findViewById(R.id.tve_encorazona);
            imgEmpresa = mView.findViewById(R.id.imgTienda);
        }
    }
}

