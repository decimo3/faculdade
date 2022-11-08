package ruancamello.androidsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mEditTextNome, mEditTextTelefone;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditTextNome = findViewById(R.id.nome);
        mEditTextTelefone = findViewById(R.id.telefone);
        Button mButtonInserir = findViewById(R.id.inserir);
        mButtonInserir.setOnClickListener(v -> inserir());
    }
    public void inserir(){
        String nome = mEditTextNome.getText().toString();
        String telefone = mEditTextTelefone.getText().toString();
        if ((!nome.isEmpty()) && (!telefone.isEmpty())) {
            Cliente cliente = new Cliente(nome, telefone);
            DOA.inserirCliente(MainActivity.this, cliente);
        }
    }

}