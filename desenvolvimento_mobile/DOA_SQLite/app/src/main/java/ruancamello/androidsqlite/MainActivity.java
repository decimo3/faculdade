package ruancamello.androidsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText mEditTextNome, mEditTextTelefone;
    private TextView mTextResultado;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditTextNome = findViewById(R.id.nome);
        mEditTextTelefone = findViewById(R.id.telefone);
        mTextResultado = findViewById(R.id.resultado);
        Button mButtonInserir = findViewById(R.id.inserir);
        mButtonInserir.setOnClickListener(v -> inserir());
        Button mButtonConsultar = findViewById(R.id.exibir);
        mButtonConsultar.setOnClickListener(v -> consultar());
        Button mButtonExcluir = findViewById(R.id.excluir);
        mButtonExcluir.setOnClickListener(v -> eliminar());
    }
    public void inserir(){
        String nome = mEditTextNome.getText().toString();
        String telefone = mEditTextTelefone.getText().toString();
        if ((!nome.isEmpty()) && (!telefone.isEmpty())) {
            Cliente cliente = new Cliente(nome, telefone);
            DOA.inserirCliente(MainActivity.this, cliente);
            atualizarResultado("Cliente atualizado com sucesso!");
        }
    }
    public void consultar(){
        List<Cliente> mClienteList;
        mClienteList = DOA.pesquisarCliente(MainActivity.this);
        StringBuilder mensagem = new StringBuilder();
        for (Cliente cliente : mClienteList) {
            mensagem.append("Id: ");
            mensagem.append(cliente.getId());
            mensagem.append(" Nome: ");
            mensagem.append(cliente.getNome());
            mensagem.append("\n");
        }
        atualizarResultado(mensagem.toString());
    }
    public void eliminar(){
        String nome = mEditTextNome.getText().toString();
        if (nome.isEmpty()) {
            atualizarResultado(String.format("Foram excluídos %d contatos!", DOA.eliminarCliente(MainActivity.this)));
        } else {
            Cliente cliente = DOA.pesquisarCliente(MainActivity.this, nome);
            atualizarResultado(String.format("Foram excluídos %d contatos!", DOA.eliminarCliente(MainActivity.this, cliente)));
        }
    }
    private void atualizarResultado (String menssage) {
        Toast.makeText(this, menssage, Toast.LENGTH_LONG).show();
        if (!menssage.isEmpty()) {
            mTextResultado.setText(menssage);
            mTextResultado.setVisibility(View.VISIBLE);
        } else {
            mTextResultado.setText("");
            mTextResultado.setVisibility(View.INVISIBLE);
        }
    }
}