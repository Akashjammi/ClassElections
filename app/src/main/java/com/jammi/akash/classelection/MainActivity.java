package com.jammi.akash.classelection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private RecyclerView mRecyclerView;
//    private List<Modelclass> modelclassList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.jammi.akash.classelection.R.layout.activity_main);
        mRecyclerView = findViewById(com.jammi.akash.classelection.R.id.recylerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(layoutManager);

        List<Modelclass> modelclassList = new ArrayList<>();
        modelclassList.add(new Modelclass(com.jammi.akash.classelection.R.drawable.svce,"IT -A","Mr.X,Mr.Y,Mr.XY,Ms.KK,Ms.kb are standing this time!") );
        modelclassList.add(new Modelclass(com.jammi.akash.classelection.R.drawable.svce,"IT -B","Mr.X,Mr.Y,Mr.XY,Ms.KK,Ms.kb are standing this time!") );
        modelclassList.add(new Modelclass(com.jammi.akash.classelection.R.drawable.svce,"IT -C","Mr.X,Mr.Y,Mr.XY,Ms.KK,Ms.kb are standing this time!") );
        modelclassList.add(new Modelclass(com.jammi.akash.classelection.R.drawable.svce,"IT -D","Mr.X,Mr.Y,Mr.XY,Ms.KK,Ms.kb are standing this time!") );
        modelclassList.add(new Modelclass(com.jammi.akash.classelection.R.drawable.svce,"IT -E","Mr.X,Mr.Y,Mr.XY,Ms.KK,Ms.kb are standing this time!") );
        modelclassList.add(new Modelclass(com.jammi.akash.classelection.R.drawable.svce,"IT -F","Mr.X,Mr.Y,Mr.XY,Ms.KK,Ms.kb are standing this time!") );
        modelclassList.add(new Modelclass(com.jammi.akash.classelection.R.drawable.svce,"IT -G","Mr.X,Mr.Y,Mr.XY,Ms.KK,Ms.kb are standing this time!") );
        modelclassList.add(new Modelclass(com.jammi.akash.classelection.R.drawable.svce,"IT -H","Mr.X,Mr.Y,Mr.XY,Ms.KK,Ms.kb are standing this time!") );
        modelclassList.add(new Modelclass(com.jammi.akash.classelection.R.drawable.svce,"IT -I","Mr.X,Mr.Y,Mr.XY,Ms.KK,Ms.kb are standing this time!") );
        modelclassList.add(new Modelclass(com.jammi.akash.classelection.R.drawable.svce,"IT -J","Mr.X,Mr.Y,Mr.XY,Ms.KK,Ms.kb are standing this time!") );
        modelclassList.add(new Modelclass(com.jammi.akash.classelection.R.drawable.svce,"IT -K","Mr.X,Mr.Y,Mr.XY,Ms.KK,Ms.kb are standing this time!") );
        modelclassList.add(new Modelclass(com.jammi.akash.classelection.R.drawable.svce,"IT -L","Mr.X,Mr.Y,Mr.XY,Ms.KK,Ms.kb are standing this time!") );
        modelclassList.add(new Modelclass(com.jammi.akash.classelection.R.drawable.svce,"IT -M","Mr.X,Mr.Y,Mr.XY,Ms.KK,Ms.kb are standing this time!") );
        modelclassList.add(new Modelclass(com.jammi.akash.classelection.R.drawable.svce,"IT -N","Mr.X,Mr.Y,Mr.XY,Ms.KK,Ms.kb are standing this time!") );

        Adapter adapter = new Adapter(modelclassList);
        mRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }
//    @override
    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
}
