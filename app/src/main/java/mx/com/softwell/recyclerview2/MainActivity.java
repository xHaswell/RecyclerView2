package mx.com.softwell.recyclerview2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AlumnoAdapter.OnClickListener {

    List<Alumno> alumnos = new ArrayList<Alumno>();
    private RecyclerView rclvAlumnos;
    AlumnoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configDataSource();
        configRecyclerView();
    }

    private void configDataSource() {

        alumnos.add(new Alumno("Robert", "RS14110009"));
        alumnos.add(new Alumno("Chio", "RS14110008"));
        alumnos.add(new Alumno("Lemus", "RS14110007"));
        alumnos.add(new Alumno("Marcos", "RS14110006"));
        alumnos.add(new Alumno("Ivon", "RS14110005"));
        alumnos.add(new Alumno("Robert", "RS14110009"));
        alumnos.add(new Alumno("Chio", "RS14110008"));
        alumnos.add(new Alumno("Lemus", "RS14110007"));
        alumnos.add(new Alumno("Marcos", "RS14110006"));
        alumnos.add(new Alumno("Ivon", "RS14110005"));
        alumnos.add(new Alumno("Robert", "RS14110009"));
        alumnos.add(new Alumno("Chio", "RS14110008"));
        alumnos.add(new Alumno("Lemus", "RS14110007"));
        alumnos.add(new Alumno("Marcos", "RS14110006"));
        alumnos.add(new Alumno("Ivon", "RS14110005"));
    }

    private void configRecyclerView() {
        rclvAlumnos = findViewById(R.id.rclvAlumnos);
        adapter = new AlumnoAdapter(alumnos, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        rclvAlumnos.setLayoutManager(linearLayoutManager);
        rclvAlumnos.setAdapter(adapter);
    }

    @Override
    public void onClickListener(Alumno alumno) {
        Misc.alumno = alumno;
        Misc.indexAlumno = alumnos.indexOf(alumno);
        Misc.modificado = false;
        Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
        startActivity(intent);
    }

    @Override
    public void onLongClickListener(Alumno alumno) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (Misc.modificado) {
            alumnos.set(Misc.indexAlumno, Misc.alumno);
            adapter.notifyDataSetChanged();
        }
    }
}
