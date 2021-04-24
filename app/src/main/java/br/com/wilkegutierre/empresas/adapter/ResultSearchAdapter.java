package br.com.wilkegutierre.empresas.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import br.com.wilkegutierre.empresas.R;
import br.com.wilkegutierre.empresas.data.network.ApiClient;
import br.com.wilkegutierre.empresas.data.network.CompanyResponse;
import br.com.wilkegutierre.empresas.ui.actCompanyDetail;

public class ResultSearchAdapter
        extends RecyclerView.Adapter<ResultSearchAdapter.ViewHolder> {

    private List<CompanyResponse> companies;
    private Context context;

    public ResultSearchAdapter(List<CompanyResponse> companies) {
        this.companies = companies;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgLogoCompany;
        private TextView tvName, tvBusiness, tvCountry;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgLogoCompany = itemView.findViewById(R.id.imgCompanyResult);
            tvName = itemView.findViewById(R.id.tvCompanyName);
            tvBusiness = itemView.findViewById(R.id.tvCompanyBusiness);
            tvCountry = itemView.findViewById(R.id.tvCompanyCountry);
        }
    }

    @NonNull
    @Override
    public ResultSearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_result_search, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultSearchAdapter.ViewHolder holder, int position) {
        holder.tvName.setText(companies.get(position).getName());
        holder.tvBusiness.setText(companies.get(position).getEnterprise_type().getType_name());
        holder.tvCountry.setText(companies.get(position).getCity());

        Glide.with(context)
                .load(ApiClient.SERVER_ADDRESS + companies.get(position).getPhoto_url())
                .centerCrop()
                .placeholder(R.drawable.image_launcher)
                .into(holder.imgLogoCompany);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), actCompanyDetail.class);
                intent.putExtra("company", companies.get(position).getId());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (companies != null && companies.size() > 0) ? companies.size() : 0;
    }


}
