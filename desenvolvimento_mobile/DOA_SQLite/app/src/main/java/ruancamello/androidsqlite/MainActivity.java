package ruancamello.androidsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        mButtonConsultar.setOnClickListener(v -> atualizarResultado());
        Button mButtonExcluir = findViewById(R.id.excluir);
        mButtonExcluir.setOnClickListener(v -> eliminar());
        atualizarResultado();
    }
    public void inserir(){
        String nome = mEditTextNome.getText().toString();
        String telefone = mEditTextTelefone.getText().toString();
        if ((!nome.isEmpty()) && (!telefone.isEmpty())) {
            if (DOA.existeCliente(MainActivity.this, nome)) {
                Toast.makeText(this, "Cliente já está cadastrada!", Toast.LENGTH_LONG).show();
            } else {
                Cliente cliente = new Cliente(nome, telefone);
                DOA.inserirCliente(MainActivity.this, cliente);
                Toast.makeText(this, "Cliente inserido com sucesso!", Toast.LENGTH_LONG).show();
                atualizarResultado();
            }

        }
    }
    public void atualizarResultado(){
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
        mTextResultado.setText(mensagem);
        Toast.makeText(this, "Atualizado!", Toast.LENGTH_LONG).show();
    }
    public void eliminar(){
        String nome = mEditTextNome.getText().toString();
        if (nome.isEmpty()) {
            String mensagem = String.format("Foram excluídos %d contatos!", DOA.eliminarCliente(MainActivity.this));
            Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
        } else {
            if (DOA.existeCliente(MainActivity.this, nome)) {
                Cliente cliente = DOA.pesquisarCliente(MainActivity.this, nome);
                String mensagem = String.format("Foram excluídos %d contatos!", DOA.eliminarCliente(MainActivity.this, cliente));
                Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Cliente informado não existe!", Toast.LENGTH_LONG).show();
            }
        }
        atualizarResultado();
    }
}