package ruancamello.androidsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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
    public static int excluirCliente(Context context, Cliente cliente) {
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
    public static Cursor pesquisarTodosClientes(Context context) {
        // Criamos uma instância da classe do banco de dados
        BancoDeDadosSQLite bancoDeDadosSQLite = new BancoDeDadosSQLite(context);
        // Recuperamos um objeto para ler do banco de dados
        SQLiteDatabase sqLiteDatabase = bancoDeDadosSQLite.getReadableDatabase();
        return sqLiteDatabase.query("Cliente", null, null, null, null, null, null);
    }
}
