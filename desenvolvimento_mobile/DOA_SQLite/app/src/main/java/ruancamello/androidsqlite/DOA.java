package ruancamello.androidsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DOA {
    public static long inserirCliente(Context context, Cliente cliente) {
        // Criamos uma instância da classe do banco de dados
        BancoDeDadosSQLite bancoDeDadosSQLite = new BancoDeDadosSQLite(context);
        // Recuperamos um objeto para escrever no banco de dados
        SQLiteDatabase sqLiteDatabase = bancoDeDadosSQLite.getWritableDatabase();
        // Este objeto é responsável por enviar os dados para o banco de dados
        ContentValues values = new ContentValues();
        values.put("nome", cliente.getNome());
        values.put("telefone", cliente.getTelefone());
        // Chamamos pelo método responsável por inserir no banco de dados:
        // O primeiro parâmetro refere-se a tabela
        // O segundo parâmetro é nulo, pois estamos informando os dados através do objeto ContentValues
        // O terceiro parâmetro refere-se aos dados que serão adicionados
        return sqLiteDatabase.insert("Cliente", null, values);
    }
    public static int eliminarCliente(Context context, Cliente cliente) {
        // Criamos uma instância da classe do banco de dados
        BancoDeDadosSQLite bancoDeDadosSQLite = new BancoDeDadosSQLite(context);
        // Recuperamos um objeto para escrever no banco de dados
        SQLiteDatabase sqLiteDatabase = bancoDeDadosSQLite.getWritableDatabase();
        // Responsável por definir a cláusula WHERE
        String where = "id = ?";
        // Declara um vetor de Strings
        // Recebe como argumento o id do Cliente
        // Converte o id para String
        String[] argumentos = {String.valueOf(cliente.getId())};
        // Chamamos pelo método responsável por excluir no banco de dados
        // O primeiro parâmetro refere-se a tabela
        // O segundo parâmetro refere-se a cláusula WHERE
        // O terceiro parâmetro refere-se aos argumentos da cláusula WHERE
        return sqLiteDatabase.delete("Cliente", where, argumentos);
    }
    public static int eliminarCliente(Context context) {
        // Criamos uma instância da classe do banco de dados
        BancoDeDadosSQLite bancoDeDadosSQLite = new BancoDeDadosSQLite(context);
        // Recuperamos um objeto para escrever no banco de dados
        SQLiteDatabase sqLiteDatabase = bancoDeDadosSQLite.getWritableDatabase();
        // Chamamos pelo método responsável por excluir no banco de dados
        // O primeiro parâmetro refere-se a tabela
        // O segundo parâmetro refere-se a cláusula WHERE
        // O terceiro parâmetro refere-se aos argumentos da cláusula WHERE
        return sqLiteDatabase.delete("Cliente", null, null);
    }
    public static int atualizarCliente(Context context, Cliente cliente) {
        // Criamos uma instância da classe do banco de dados
        BancoDeDadosSQLite bancoDeDadosSQLite = new BancoDeDadosSQLite(context);
        // Recuperamos um objeto para escrever no banco de dados
        SQLiteDatabase sqLiteDatabase = bancoDeDadosSQLite.getWritableDatabase();
        // Este objeto é responsável por enviar os dados para o banco de dados
        ContentValues values = new ContentValues();
        values.put("nome", cliente.getNome());
        values.put("telefone", cliente.getTelefone());
        // Responsável por definir a cláusula WHERE
        String where = "id = ?";
        // Declara um vetor de Strings
        // Recebe como argumento o id do Cliente
        // Converte o id para String
        String[] argumentos = {String.valueOf(cliente.getId())};
        // Chamamos pelo método responsável por atualizar no banco de dados
        // O primeiro parâmetro refere-se a tabela
        // O segundo parâmetro refere-se aos dados do cliente que será atualizado
        // O terceiro parâmetro refere-se a cláusula WHERE
        // O quarto parâmetro refere-se aos argumentos da cláusula WHERE
        return sqLiteDatabase.update("Cliente", values, where, argumentos);
    }
    public static List<Cliente> pesquisarCliente(Context context) {
        // Criamos uma instância da classe do banco de dados
        BancoDeDadosSQLite bancoDeDadosSQLite = new BancoDeDadosSQLite(context);
        // Recuperamos um objeto para ler do banco de dados
        SQLiteDatabase sqLiteDatabase = bancoDeDadosSQLite.getReadableDatabase();
        List<Cliente> mClienteList;
        mClienteList = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query("Cliente", null, null, null, null, null, null);
        cursor.moveToFirst();
        int i = 0;
        while (i < cursor.getCount()) {
            String nome = cursor.getString(1);
            String phone = cursor.getString(2);
            Cliente cliente = new Cliente(nome, phone);
            cliente.setId(cursor.getInt(0));
            mClienteList.add(cliente);
            cursor.moveToNext();
            i++;
        }
        cursor.close();
        return mClienteList;
    }
    public static Cliente pesquisarCliente(Context context, String nome) {
        // Criamos uma instância da classe do banco de dados
        BancoDeDadosSQLite bancoDeDadosSQLite = new BancoDeDadosSQLite(context);
        // Recuperamos um objeto para ler do banco de dados
        SQLiteDatabase sqLiteDatabase = bancoDeDadosSQLite.getReadableDatabase();
        // Responsável por definir a cláusula WHERE
        String where = "nome = ?";
        // Declara um vetor de Strings
        String[] nomes = {nome};
        Cursor cursor = sqLiteDatabase.query("Cliente", null, where, nomes, null, null, null);
        cursor.moveToFirst();
        String clienteNome = cursor.getString(1);
        String clienteFone = cursor.getString(2);
        Cliente cliente = new Cliente(clienteNome, clienteFone);
        cliente.setId(cursor.getInt(0));
        cursor.close();
        return cliente;
    }
}
