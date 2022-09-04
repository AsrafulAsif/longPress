package com.example.longpressaction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = (Button) findViewById(R.id.btn);

        PopupMenu supplier = new PopupMenu(this, button);
        supplier.inflate(R.menu.popupmenu);


        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                supplier.show();
                supplier.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.edit:
                                Toast.makeText(MainActivity.this, "Edit", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.delete:
                                Toast.makeText(MainActivity.this, "Delete", Toast.LENGTH_SHORT).show();
                                return true;
                        }


                        return false;
                    }
                });

                return true;
            }
        });


    }
}