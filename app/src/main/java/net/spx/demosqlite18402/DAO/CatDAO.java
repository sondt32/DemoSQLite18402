package net.spx.demosqlite18402.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import net.spx.demosqlite18402.DTO.CatDTO;
import net.spx.demosqlite18402.DbHelper.MyDbHelper;

import java.util.ArrayList;

public class CatDAO {
    MyDbHelper dbHelper;
    SQLiteDatabase db;

    public CatDAO(Context context){
        dbHelper = new MyDbHelper(context );
        db = dbHelper.getWritableDatabase();
    }
    // Viết hàm lấy danh sách
    public ArrayList<CatDTO> getList (){
        ArrayList<CatDTO> listCat = new ArrayList<>();
        // tạo con trỏ đọc
        Cursor c = db.rawQuery("SELECT * FROM tb_cat ORDER BY id ASC",
                            null);
        if(c.getCount()> 0){
            // đọc dữ liệu ở đây để cho vào list
            c.moveToFirst();// đưa trỏ soạn thảo về dòng đầu
            do {
                CatDTO objCat = new CatDTO();
                objCat.setId(  c.getInt(0 )  );
                objCat.setName(  c.getString(0 )  );
                listCat.add( objCat ); //đưa đối tượng vào danh sách

            }while (c.moveToNext());

        }else{
            Log.d("zzzzz", "getList: Không có dữ liệu");
        }

        return  listCat;
    }


    // hàm thêm mới


    // hàm sửa

    // hàm xóa
}
