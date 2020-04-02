package app.app.educationalquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.GenericArrayType;

public class GameLevels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels);// связь с окном игры

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); // Убрать строку состояния.
        Button buttonBack = (Button)findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // команда для кнопки назад
                //начало конструкции
                try {
                    Intent intent = new Intent(GameLevels.this, MainActivity.class);
                    startActivity(intent);finish();
                }catch (Exception e){}
                //конец конструкции
            }
        });

        //кнопка для перехода на 1 уровень начало
        TextView textView1 = (TextView)findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, Level1.class);
                    startActivity(intent);finish();
                }catch (Exception e){}
            }
        });
        //кнопка для перехода на 1 уровень конец


        //кнопка для перехода на 2 уровень начало
        TextView textView2 = (TextView)findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, Level2.class);
                    startActivity(intent);finish();
                }catch (Exception e){}
            }
        });
        //кнопка для перехода на 2 уровень конец

        //кнопка для перехода на 3 уровень начало
        TextView textView3 = (TextView)findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, Level3.class);
                    startActivity(intent);finish();
                }catch (Exception e){}
            }
        });
        //кнопка для перехода на 3 уровень конец

        //кнопка для перехода на 4 уровень начало
        TextView textView4 = (TextView)findViewById(R.id.textView4);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, Level4.class);
                    startActivity(intent);finish();
                }catch (Exception e){}
            }
        });
        //кнопка для перехода на 4 уровень конец

        //кнопка для перехода на 5 уровень начало
        TextView textView5 = (TextView)findViewById(R.id.textView5);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, Level5.class);
                    startActivity(intent);finish();
                }catch (Exception e){}
            }
        });
        //кнопка для перехода на 5 уровень конец
    }
    //системная кнопка назад начало
    @Override
   public void onBackPressed(){
        try {
            Intent intent = new Intent(GameLevels.this, MainActivity.class);
            startActivity(intent);finish();
        }catch (Exception e){}
    }

    //системная кнопка назад конец
}
