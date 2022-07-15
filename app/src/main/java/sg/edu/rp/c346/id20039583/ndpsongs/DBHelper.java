package sg.edu.rp.c346.id20039583.ndpsongs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {


        private static final String DATABASE_NAME = "song.db";
        private static final int DATABASE_VERSION = 2;
        private static final String TABLE_SONG = "song";
        private static final String COLUMN_ID = "_id";
        private static final String COLUMN_TITLE = "title";
        private static final String COLUMN_SINGERS = "singers";
        private static final String COLUMN_YEARS = "years";
       private static final String COLUMN_STARS = "stars";


    public DBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String createNoteTableSql = "CREATE TABLE " + TABLE_SONG + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_TITLE + " TEXT," + COLUMN_SINGERS + " TEXT,"  + COLUMN_YEARS + "INTEGER," + COLUMN_STARS
                    + "INTEGER)";

            db.execSQL(createNoteTableSql);
            Log.i("info", "created table");

            for (int i = 0; i< 4; i++) {
                ContentValues values = new ContentValues();
                values.put(COLUMN_TITLE, "Data number " + i);
                db.insert(TABLE_SONG, null, values);
            }
            Log.i("info", "dummy records inserted");

        }

    public long insertSong(String Song) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, Song);
        long result = db.insert(TABLE_SONG, null, values); //get a number which is the record id
        db.close();
        Log.d("SQL Insert","ID:"+ result); //id returned, shouldn’t be -1
        return result;
    }





    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("ALTER TABLE " + TABLE_SONG + " ADD COLUMN module_name TEXT");


    }

    public ArrayList<Note> getAllNotes() { //this method retrieves the records and construct every record to String
        ArrayList<Note> notes = new ArrayList<Note>();

        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns= {COLUMN_ID, COLUMN_TITLE};
        Cursor cursor = db.query(TABLE_SONG, columns, null, null,
                null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String Song = cursor.getString(1);
                Note i = new Note(id, Song);
                notes.add(i);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return notes;
    }


}