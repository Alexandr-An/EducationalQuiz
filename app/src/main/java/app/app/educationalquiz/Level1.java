package app.app.educationalquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class Level1 extends AppCompatActivity {

    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        final ImageView img_Left = (ImageView)findViewById(R.id.img_left);
        img_Left.setClipToOutline(true);//скругление углов у левой картинки

        final ImageView img_right = (ImageView)findViewById(R.id.img_right);
        img_right.setClipToOutline(true);// скругление углов у правой картинки

        //развернуть игру на весь экран начало
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //развернуть игру на весь экран начало


        //Вызов диалогового окна в начале первого уровня
        dialog = new Dialog(this);// новое диалоговое окно
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрыть загооловок стандартный
        dialog.setContentView(R.layout.previewdialog);// путь к маекету диалогового окна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачныйыы фон диалогового окна
        dialog.setCancelable(false);//окно нельзя закрытть кнопкой назад
        //кнопка закрытия диалогового окна начало
        TextView btnclose = (TextView)dialog.findViewById(R.id.button_close);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //обработка нажатия кнопки начало
                try {
                    //вернуться назад к выбору уровня начало
                    Intent intent = new Intent(Level1.this, GameLevels.class);//намерение для перехода
                    startActivity(intent);//старт намерения
                    finish();//закрыть класс
                    //вернуться назад к выбору уровня конец
                }catch (Exception e){}
                dialog.dismiss();//закрываем диалоговое окно
                //обработка нажатия кнопки конец
            }
        });
        //кнопка закрытия диалогового окна конец

        //кнопка продожить начло
        Button btncontinue = (Button)dialog.findViewById(R.id.buttoncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();// закрываем диалоговое окно/
            }
        });

        //кнопка продожить конец

        dialog.show();//показать диалоговое окно
    }
}
