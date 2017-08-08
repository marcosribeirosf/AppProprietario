package pooa20171.iff.br.appproprietario.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import pooa20171.iff.br.appproprietario.R;
import pooa20171.iff.br.appproprietario.model.Proprietario;

public class ProprietarioDetalheActivity extends AppCompatActivity {

    EditText nome, endereco, bairro, cidade, telefone, email, latitude, longitude;
    Button btsalvar,btalterar, btdeletar;
    int id;
    Proprietario proprietario;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proprietario_detalhe);

        nome = (EditText) findViewById(R.id.ed_nome_proprietario);
        endereco = (EditText) findViewById(R.id.ed_endereco_proprietario);
        bairro = (EditText) findViewById(R.id.ed_bairro_proprietario);
        cidade = (EditText) findViewById(R.id.ed_cidade_proprietario);
        telefone = (EditText) findViewById(R.id.ed_telefone_proprietario);
        email = (EditText) findViewById(R.id.ed_email_proprietario);
        longitude = (EditText) findViewById(R.id.ed_longitude_proprietario);
        latitude = (EditText) findViewById(R.id.ed_latitude_proprietario);

        btsalvar = (Button) findViewById(R.id.bt_salvar_proprietario);
        btalterar = (Button) findViewById(R.id.bt_alterar_proprietario);
        btdeletar = (Button) findViewById(R.id.bt_deletar_proprietario);

        Intent intent    = getIntent();
        id = (int) intent.getSerializableExtra("id");
        realm = Realm.getDefaultInstance();


        if (id !=0) {
            btsalvar.setEnabled(false);
            btsalvar.setClickable(false);
            btsalvar.setVisibility(View.INVISIBLE);
            proprietario = realm.where(Proprietario.class).equalTo("id",id).findFirst();

            nome.setText(proprietario.getNome());
            endereco.setText(proprietario.getEndereco());
            bairro.setText(proprietario.getBairro());
            cidade.setText(proprietario.getCidade());
            bairro.setText(proprietario.getBairro());
            telefone.setText(proprietario.getTelefone());
            email.setText(proprietario.getEmail());
            longitude.setText(proprietario.getLongitude());
            latitude.setText(proprietario.getLatitude());

        }else{
            btalterar.setEnabled(false);
            btalterar.setClickable(false);
            btalterar.setVisibility(View.INVISIBLE);
            btdeletar.setEnabled(false);
            btdeletar.setClickable(false);
            btdeletar.setVisibility(View.INVISIBLE);

        }



        btsalvar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                salvar();
            }
        });
        btalterar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                alterar();
            }
        });
        btdeletar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                deletar();
            }
        });


    }

    public void deletar(){
        realm.beginTransaction();
        proprietario.deleteFromRealm();
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Proprietario deletado",Toast.LENGTH_LONG).show();
        this.finish();

    }

    public void salvar() {


        int proximoID = 1;
        if(realm.where(Proprietario.class).max("id") !=null)
            proximoID = realm.where(Proprietario.class).max("id").intValue()+1;

        realm.beginTransaction();
        Proprietario proprietario = new Proprietario();
        proprietario.setId(proximoID);
        proprietario.setNome(nome.getText().toString());
        proprietario.setEndereco(endereco.getText().toString());
        proprietario.setBairro(bairro.getText().toString());
        proprietario.setCidade(cidade.getText().toString());
        proprietario.setTelefone(telefone.getText().toString());
        proprietario.setEmail(email.getText().toString());
        proprietario.setLongitude(longitude.getText().toString());
        proprietario.setLatitude(latitude.getText().toString());

        realm.copyToRealm(proprietario);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Proprietaro Cadastrado",Toast.LENGTH_LONG).show();
        this.finish();

    }
    public void alterar() {

        realm.beginTransaction();

        proprietario.setNome(nome.getText().toString());
        proprietario.setEndereco(endereco.getText().toString());
        proprietario.setBairro(bairro.getText().toString());
        proprietario.setCidade(cidade.getText().toString());
        proprietario.setTelefone(telefone.getText().toString());
        proprietario.setEmail(email.getText().toString());
        proprietario.setLongitude(longitude.getText().toString());
        proprietario.setLatitude(latitude.getText().toString());


        realm.copyToRealm(proprietario);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Proprietario Alterado",Toast.LENGTH_LONG).show();
        this.finish();

    }
}
