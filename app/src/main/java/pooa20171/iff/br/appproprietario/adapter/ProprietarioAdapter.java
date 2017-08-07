package pooa20171.iff.br.appproprietario.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pooa20171.iff.br.appproprietario.model.Proprietario;
import pooa20171.iff.br.appproprietario.R;



public class ProprietarioAdapter extends RecyclerView.Adapter {

    private List<Proprietario> proprietarios;
    private Context context;
    private static ClickRecyclerViewListener clickRecyclerViewListener;

    public ProprietarioAdapter(List<Proprietario> proprietarios, Context context, ClickRecyclerViewListener clickRecyclerViewListener) {

        this.proprietarios = proprietarios;
        this.context = context;
        this.clickRecyclerViewListener = clickRecyclerViewListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_proprietario, parent, false);
        ProprietarioViewHolder proprietarioViewHolder = new ProprietarioViewHolder(view);
        return proprietarioViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder,
                                 int position) {

        ProprietarioViewHolder holder = (ProprietarioViewHolder) viewHolder;

        Proprietario proprietario  = proprietarios.get(position) ;

        holder.nomeProprietario.setText(proprietario.getNome());
    }

    @Override
    public int getItemCount() {

        return proprietarios.size();
    }

    private void updateItem(int position) {

    }

    private void removerItem(int position) {

    }

    public class ProprietarioViewHolder extends RecyclerView.ViewHolder {

        private final TextView nomeProprietario;


        public ProprietarioViewHolder(View itemView) {
            super(itemView);
            nomeProprietario = (TextView) itemView.findViewById(R.id.nome);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickRecyclerViewListener.onClick(proprietarios.get(getLayoutPosition()));

                }
            });

        }
    }
}
