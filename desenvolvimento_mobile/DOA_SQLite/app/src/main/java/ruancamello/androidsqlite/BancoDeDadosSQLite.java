package ruancamello.androidsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class BancoDeDadosSQLite extends SQLiteOpenHelper {
    // Construtor da classe responsável por criar o banco de dados
    // O nome e a versão do banco de dados são definidos neste construtor
    public BancoDeDadosSQLite(Context context) {
        super(context, "SQLiteBancoDeDados", null, 1);
    }
    @Override public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CRIAR_BD = "CREATE TABLE Cliente (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, telefone TEXT)";
        sqLiteDatabase.execSQL(CRIAR_BD);
    }

    @Override public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
