package com.example.kiguno.baseofdate;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLHelper db;
    LinearLayout data;
    LinearLayout row;
    LinearLayout data2 ;
    Button removeClassmate;
    Button removeCarShop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db  = new SQLHelper(this);
        data = (LinearLayout)findViewById(R.id.classmates);
        data2 = (LinearLayout)findViewById(R.id.cars);
        removeClassmate = (Button)findViewById(R.id.removeClassmates) ;
        removeCarShop = (Button) findViewById(R.id.removeCars);

   /*   showClassmates();*/
       showCars();
    }


    public void removeClassmate(View view)
    {
        db.removeClassmate();
        showClassmates();
    }


    public void removeCars(View view)
    {
        db.removeAllCars();
        showCars();
    }
   public void showClassmates(){
        ArrayList<Person> persons = getListOfClass();
        for(Person p: persons)
        {

            row = new LinearLayout(this);
            row.setOrientation(LinearLayout.HORIZONTAL);

            TextView id = new TextView(this);
            id.setText(Integer.toString(p._id));
            id.setWidth(120);

            TextView name = new TextView(this);
            name.setText(p.name);
            name.setWidth(120);

            TextView Age = new TextView(this);
            Age.setText(Integer.toString(p.age));
            Age.setWidth(120);

            row.addView(id);
            row.addView(name);
            row.addView(Age);

            data.addView(row);
        }
    }

    public ArrayList<Person> getListOfClass(){
        ArrayList<Person> persons = new ArrayList<>();
        Cursor cursor = db.getFullTable();
        if(cursor !=  null)
        {
            while (cursor.moveToNext()){
                persons.add(new Person(cursor.getInt(0), cursor.getString(1),cursor.getInt(2)));
            }
        }
        return persons;
        }




        public SQLHelper fillTable(SQLHelper db)
        {
            ContentValues cv = new ContentValues();
            cv.put("name", "Vld");
            cv.put("age", "23");
            db.getWritableDatabase().insert("table1", null, cv);
            return db;
        }

       public void showCars(){
        ArrayList<Car> cars = getListOfCars();
        for(Car p: cars)
        {

            row = new LinearLayout(this);
            row.setOrientation(LinearLayout.HORIZONTAL);

            TextView m_id = new TextView(this);
            m_id.setText(Integer.toString(p.id));
            m_id.setWidth(120);

            TextView m_year = new TextView(this);
            m_year.setText(Integer.toString(p.year));
            m_year.setWidth(120);

            TextView m_mileage = new TextView(this);
            m_mileage.setText(Integer.toString(p.mileage));
            m_mileage.setWidth(120);

            TextView m_color = new TextView(this);
            m_color.setText(p.i_color);
            m_color.setWidth(120);


            TextView m_helm = new TextView(this);
            m_helm.setText(p.helm );
            m_helm.setWidth(120);

            row.addView(m_id);
            row.addView(m_year);
            row.addView(m_mileage);
            row.addView(m_color);
            row.addView(m_helm);

            data2.addView(row);
        }
    }

    public ArrayList<Car> getListOfCars(){
        ArrayList<Car> cars = new ArrayList<>();
        Cursor cursor = db.getFullShop();
        if(cursor !=  null)
        {
            while (cursor.moveToNext()){
                cars.add(new Car(cursor.getInt(cursor.getColumnIndex("id")), cursor.getInt(cursor.getColumnIndex("year")),cursor.getInt(cursor.getColumnIndex("mileage")), cursor.getString(cursor.getColumnIndex("color")),cursor.getString(cursor.getColumnIndex("helm"))));
            }
        }
        return cars;
    }


    public SQLHelper fillTableCars(SQLHelper db, String y,String m, String c, String h)
    {
        ContentValues cv = new ContentValues();
        cv.put("year", y);
        cv.put("mileage", m);
        cv.put("color", c);
        cv.put("helm", h);
        db.getWritableDatabase().insert("autoShop", null, cv);
        return db;
    }


    public void addCars(View view)
    {
        EditText editYear = (EditText) findViewById(R.id.editYear);
        EditText editMileAge =(EditText) findViewById(R.id.editMileage);
        EditText editColor = (EditText) findViewById(R.id.editAge);
        EditText editHelm = (EditText) findViewById(R.id.editHelm);
        if(String.valueOf(editYear.getText()).equals(" ") || String.valueOf(editMileAge.getText()).equals(" ") || String.valueOf(editColor.getText()).equals(" ") ||  String.valueOf(editHelm.getText()).equals(" ")) {
            Toast.makeText(this, "Необходимо заполнить все поля", Toast.LENGTH_LONG).show();
            return;
        }
        fillTableCars(db, editYear.getText().toString(), editMileAge.getText().toString(),editColor.getText().toString(),editHelm.getText().toString());
        Toast.makeText(this, "Добавлено", Toast.LENGTH_SHORT).show();
        showCars();

     }

}
