package com.aplicacao;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.widget.Toast;

import pub.devrel.easypermissions.EasyPermissions;
import pub.devrel.easypermissions.AfterPermissionGranted;

public class MainActivity extends AppCompatActivity {
    // definindo uma constante com um valor aleatório entre 1 e 255
    // é um valor único a ser usado para identificar a solicitação
    private static final int RC_CAMERA = 123;
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button_camera).setOnClickListener(v -> funcaoParaSolicitarPermissao());
    }
    @AfterPermissionGranted(RC_CAMERA)
    private void funcaoParaSolicitarPermissao() {
        // declara uma lista de permissões que deseja verificar se tem acesso, nesse caso, temos somente para câmera
        String[] permissoes = {Manifest.permission.CAMERA};
        // Verifica se você já tem a permissão necessária, se tiver mostra uma notificação Toast, caso contrário, solicita a permissão
        if (EasyPermissions.hasPermissions(this, permissoes)) {
            Toast.makeText(this, "Seu aplicativo já tem as permissões necessárias!", Toast.LENGTH_LONG).show();
        } else {
            EasyPermissions.requestPermissions(this, "É necessária a permissão para acessar a câmera", RC_CAMERA, permissoes);
        }
    }
}