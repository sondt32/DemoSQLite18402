package net.spx.demosqlite18402;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import net.spx.demosqlite18402.DAO.CatDAO;
import net.spx.demosqlite18402.DTO.CatDTO;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    CatDAO catDAO;
    ArrayList<CatDTO> listCat;
    String TAG = "zzzzzzzzzzz";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo DAO
        catDAO = new CatDAO(this);



        //Lấy ds
        listCat = catDAO.getList();

        Log.d(TAG, "onCreate: Số lượng bản ghi thể loại = " + listCat.size());
        // dùng vòng lặp in ra tên các thể loại
        for(int i = 0; i< listCat.size(); i++){

            CatDTO tmp = listCat.get(i );

            Log.d(TAG, "onCreate: id =  " + tmp.getId() + "----> name = " + tmp.getName() );

        }
        // chạy ứng dụng và xem log

    }
}