package com.example.a15_sqlite_tutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public
class MainActivity extends AppCompatActivity {

    private List<User> list;
    private UserAdapter adapter;

    private SQLiteUserOpenHelper sqlite;

    private
    EditText edMSV, edName, edClass, edToan, edLy, edHoa;
    private
    RadioButton rdMale, rdFemale;
    private
    RecyclerView recyclerView;
    private
    Button btnAdd;
    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edMSV=findViewById(R.id.msv);
        edName=findViewById(R.id.name);
        edClass=findViewById(R.id.lop);
        edToan=findViewById(R.id.diemToan);
        edLy=findViewById(R.id.diemLy);
        edHoa=findViewById(R.id.diemHoa);
        rdMale=findViewById(R.id.rdMale);
        rdFemale=findViewById(R.id.rdFemale);
        recyclerView=findViewById(R.id.recycleView);
        btnAdd=findViewById(R.id.btnAdd);

        list=new ArrayList<>();
        adapter = new UserAdapter();
        adapter.setData(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        sqlite = new SQLiteUserOpenHelper(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public
            void onClick(View v) {
                addUser();
            }
        });
    }

    private
    void addUser() {
        String msv = edMSV.getText().toString();
        String ten = edName.getText().toString();
        String gioitinh ="";
        if(rdMale.isChecked())
            gioitinh = "Nam";
        else if(rdFemale.isChecked())
            gioitinh = "Nu";
        String lop = edClass.getText().toString();
        String toan =edToan.getText().toString();
        String ly = edLy.getText().toString();
        String hoa = edHoa.getText().toString();

        User user = new User(msv, ten, lop, gioitinh, toan, ly, hoa);
        sqlite.addUser(user);
        Toast.makeText(this, "add user successfull", Toast.LENGTH_LONG).show();

        edMSV.setText("");
        edName.setText("");
        edClass.setText("");
        edToan.setText("");
        edLy.setText("");
        edHoa.setText("");
        rdMale.setChecked(false);
        rdFemale.setChecked(false);

        list = sqlite.getAllUser();
        adapter.setData(list);

    }

}