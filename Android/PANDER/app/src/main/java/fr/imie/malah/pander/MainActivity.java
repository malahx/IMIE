package fr.imie.malah.pander;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import fr.imie.malah.pander.utils.Constant;

public class MainActivity extends Activity {
    private Button btnLogin;
    private Button btnLostPassword;
    private ImageButton imgRegisterCandidate;
    private ImageButton imgRegisterCompany;
    private EditText txtLogin;
    private EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnLogin = this.findViewById(R.id.btnLogin);
        this.btnLostPassword = this.findViewById(R.id.btnLostPwd);
        this.imgRegisterCandidate = this.findViewById(R.id.imgRegisterCandidate);
        this.imgRegisterCompany = this.findViewById(R.id.imgRegisterCompany);
        this.txtLogin = this.findViewById(R.id.txtLogin);
        this.txtPassword = this.findViewById(R.id.txtPassword);
        this.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_LONG).show();

                // Ex aller sur un lien
                //Intent intent = new Intent(Intent.ACTION_VIEW);
                //intent.setData(Uri.parse("https://www.google.fr"));

                // Ex aller sur une autre app
                //Intent intent = new Intent(Intent.ACTION_INSERT_OR_EDIT);
                //intent.setType(ContactsContract.Contacts.CONTENT_ITEM_TYPE);

//                if (!txtLogin.getText().toString().equals("glh") || !txtPassword.getText().toString().equals("glh")) {
//                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                    builder.setTitle("Wrong login / password")
//                            .setMessage("You entered a wrong login / password")
//                            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int which) {
//                                }
//                            })
//                            .create()
//                            .show();
//                    return;
//                }

                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                intent.putExtra(Constant.LOGIN, txtLogin.getText().toString());
                intent.putExtra(Constant.PASSWORD, txtPassword.getText().toString());
                MainActivity.this.startActivity(intent);
                MainActivity.this.finish();

            }
        });

//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("The good title")
//                //.setMessage("A good message")
//                .setItems(R.array.colors, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MainActivity.this, which, Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MainActivity.this, "CANCEL", Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .create()
//                .show();

//        SharedPreferences sharedPreferences = this.getSharedPreferences("settings", Context.MODE_PRIVATE);
//        String value = sharedPreferences.getString("pander", null);
//
//        if (value == null) {
//            SharedPreferences.Editor editor = sharedPreferences.edit();
//            editor.putString("pander", "the value");
//            editor.commit();
//        }

//        PanderSQLiteOpenHelper helper = new PanderSQLiteOpenHelper(this);
//        SQLiteDatabase db = helper.getWritableDatabase();

        // INSERT
//        db.execSQL("INSERT INTO " + PanderSQLiteOpenHelper.TABLE + " VALUES ('test1')");
//
//        db.beginTransaction();
//        try {
//            db.execSQL("INSERT INTO " + PanderSQLiteOpenHelper.TABLE + " VALUES ('test2')");
//            db.setTransactionSuccessful();
//        } catch (SQLException e) {
//
//        } finally {
//            db.endTransaction();
//        }

//        ContentValues contentValues = new ContentValues();
//        contentValues.put("name", "test3");
//        db.insert(PanderSQLiteOpenHelper.TABLE, null, contentValues);
//
//
//        // READ
//        String[] columns = {"_id", "name"};
//        String selection = "name LIKE ?";
//        String[] selectionArgs = {"test3"};
//
//        Cursor cursor = db.query(PanderSQLiteOpenHelper.TABLE, columns, selection, selectionArgs, null, null, null);
//
//        cursor.moveToFirst();
//        int index = cursor.getColumnIndex("name");
//        do {
//            String value = cursor.getString(index);
//            Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
//        } while (cursor.moveToNext());
//
//        cursor.close();
//
//        // UPDATE
//
//        ContentValues contentValues1 = new ContentValues();
//        contentValues1.put("name", "test4");
//        db.update(PanderSQLiteOpenHelper.TABLE, contentValues1, selection, selectionArgs);
//
//        // DELETE
//
//        int row = db.delete(PanderSQLiteOpenHelper.TABLE, selection, new String[]{"test4"});

    }
}
