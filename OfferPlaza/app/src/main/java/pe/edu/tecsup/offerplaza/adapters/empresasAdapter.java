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
import pe.edu.tecsup.offerplaza.models.EmpresaResponse;

public class empresasAdapter extends RecyclerView.Adapter<empresasAdapter.empresasViewHolder> {
    private List<EmpresaResponse> dataList;
    private Context context;

    public empresasAdapter(Context context, List<EmpresaResponse> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public empresasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.empresa_lista, parent, false);

        return new empresasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull empresasViewHolder holder, int position) {
        holder.razon_social.setText(dataList.get(position).getRazon_social());
        holder.nombre_comercial.setText(dataList.get(position).getNombre_comercial());
        holder.domicilio_fiscal.setText(dataList.get(position).getDomicilio_fiscal());

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(dataList.get(position).getPhoto())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(holder.imgEmpresa);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class empresasViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView razon_social;
        TextView nombre_comercial;
        TextView domicilio_fiscal;
        private ImageView imgEmpresa;


        public empresasViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            razon_social = mView.findViewById(R.id.tveRazon);
            nombre_comercial = mView.findViewById(R.id.tveNombre);
            domicilio_fiscal = mView.findViewById(R.id.tveSede);
            imgEmpresa = mView.findViewById(R.id.imgEmpresa);
        }
    }
}