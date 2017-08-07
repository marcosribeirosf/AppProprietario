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
                .inflate(R.layout.item_livro, parent, false);
        ProprietarioViewHolder proprietarioViewHolder = new ProprietarioViewHolder(view);
        return proprietarioViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder,
                                 int position) {

        ProprietarioViewHolder holder = (ProprietarioViewHolder) viewHolder;

        Proprietario proprietario  = proprietarios.get(position) ;

        holder.nome.setText(proprietario.getNome());
        holder.endereco.setText(proprietario.getEndereco());
        holder.bairro.setText(proprietario.getBairro());
        holder.cidade.setText(proprietario.getCidade());
        holder.cnh.setText(proprietario.getCnh());
        holder.telefone.setText(proprietario.getTelefone());
        holder.email.setText(proprietario.getEmail());
        holder.latitude.setText(proprietario.getLatitude());
        holder.longitude.setText(proprietario.getLatitude());

        Log.i("------XXXXXXXXX--", proprietario.getDescricao());


    }

    @Override
    public int getItemCount() {

        return proprietarios.size();
    }

    private void updateItem(int position) {

    }

    // Método responsável por remover um usuário da lista.
    private void removerItem(int position) {

    }

    public class LivroViewHolder extends RecyclerView.ViewHolder {

        private final TextView nome;
        private final TextView endereco;
        private final TextView bairro;
        private final TextView cidade;
        private final TextView cnh;
        private final TextView telefone;
        private final TextView email;
        private final TextView latitude;
        private final TextView longitude;


        public ProprietarioViewHolder(View itemView) {
            super(itemView);
            nome = (TextView) itemView.findViewById(R.id.nome);
            endereco = (TextView) itemView.findViewById(R.id.endereco);
            bairro = (TextView) itemView.findViewById(R.id.bairro);
            cidade = (TextView) itemView.findViewById(R.id.cidade);
            cnh = (TextView) itemView.findViewById(R.id.cnh);
            telefone = (TextView) itemView.findViewById(R.id.telefone);
            email = (TextView) itemView.findViewById(R.id.email);
            latitude = (TextView) itemView.findViewById(R.id.latitude);
            longitude = (TextView) itemView.findViewById(R.id.longitude);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickRecyclerViewListener.onClick(proprietarios.get(getLayoutPosition()));

                }
            });


        }
    }
}
