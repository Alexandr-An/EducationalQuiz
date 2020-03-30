package app.app.educationalquiz;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Level2 extends AppCompatActivity {

    Dialog dialog;
    Dialog dialogEnd;

    public int numLeft;// переменная для левой картинки + текст
    public int numRight;// переменная для правой картинки + текст
    Array array = new Array();
    Random random = new Random();
    public int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        //создать переменную textlevels
        TextView text_levels = findViewById(R.id.textLevels);
        text_levels.setText(R.string.level_2);

        final ImageView img_Left = (ImageView) findViewById(R.id.img_left);
        img_Left.setClipToOutline(true);//скругление углов у левой картинки

        final ImageView img_right = (ImageView) findViewById(R.id.img_right);
        img_right.setClipToOutline(true);// скругление углов у правой картинки

        //путь к левой textView
        final TextView text_left = findViewById(R.id.text_left);
        //путь к правой textView
        final TextView text_right = findViewById(R.id.text_right);

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
        //устанавливаем картинку в диалоговое окно начало
        ImageView previewimg = (ImageView)dialog.findViewById(R.id.previewimg);
        previewimg.setImageResource(R.drawable.previewdialog2);
        //устанавливаем картинку в диалоговое окно конец
        //установка описаниязадания начало
        TextView textdescription = (TextView)dialog.findViewById(R.id.textdescription);
        textdescription.setText(R.string.level2);
        //установка описаниязадания конец

        //кнопка закрытия диалогового окна начало
        TextView btnclose = (TextView) dialog.findViewById(R.id.button_close);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //обработка нажатия кнопки начало
                try {
                    //вернуться назад к выбору уровня начало
                    Intent intent = new Intent(Level2.this, GameLevels.class);//намерение для перехода
                    startActivity(intent);//старт намерения
                    finish();//закрыть класс
                    //вернуться назад к выбору уровня конец
                } catch (Exception e) {
                }
                dialog.dismiss();//закрываем диалоговое окно
                //обработка нажатия кнопки конец
            }
        });
        //кнопка закрытия диалогового окна конец

        //кнопка продожить начло
        Button btncontinue = (Button) dialog.findViewById(R.id.buttoncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();// закрываем диалоговое окно/
            }
        });

        //кнопка продожить конец

        dialog.show();//показать диалоговое окно


        //_____________________________________________________________________________________
        //Вызов диалогового окна в конце первого уровня
        dialogEnd = new Dialog(this);// новое диалоговое окно
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрыть загооловок стандартный
        dialogEnd.setContentView(R.layout.dialogend);// путь к маекету диалогового окна
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачныйыы фон диалогового окна
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);
        dialogEnd.setCancelable(false);//окно нельзя закрытть кнопкой назад

        //интересный фак начало
TextView textdescriptionEnd = (TextView)dialogEnd.findViewById(R.id.textdescriptionend);
textdescriptionEnd.setText(R.string.level2end);
        //интересный фак конец
        //кнопка закрытия диалогового окна начало
        TextView btnclose2 = (TextView) dialogEnd.findViewById(R.id.button_close);
        btnclose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //обработка нажатия кнопки начало
                try {
                    //вернуться назад к выбору уровня начало
                    Intent intent = new Intent(Level2.this, GameLevels.class);//намерение для перехода
                    startActivity(intent);//старт намерения
                    finish();//закрыть класс
                    //вернуться назад к выбору уровня конец
                } catch (Exception e) {
                }
                dialogEnd.dismiss();//закрываем диалоговое окно
                //обработка нажатия кнопки конец
            }
        });
        //кнопка закрытия диалогового окна конец

        //кнопка продожить начло
        Button btncontinue2 = (Button) dialogEnd.findViewById(R.id.buttoncontinue);
        btncontinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level2.this, Level3.class);
                    startActivity(intent);finish();
                }catch (Exception e){}
                dialogEnd.dismiss();// закрываем диалоговое окно/
            }
        });

        //кнопка продожить конец


        //_____________________________________________________________________________________

        //кнопка НАЗАД начало
        Button btn_back = (Button) findViewById(R.id.button_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //обработка кнопки назад начало
                try {
                    //вернуться назад к выбору уровня начало
                    Intent intent = new Intent(Level2.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                    //вернуться назад к выбору уровня конец
                } catch (Exception e) {
                }
                //обработка кнопки назад конец
            }
        });
        //кнопка НАЗАД конец

       //массив для прогресса игры начало
        final int[] progress = {R.id.point1,R.id.point2,R.id.point3,R.id.point4,R.id.point5,
                R.id.point6,R.id.point7,R.id.point8,R.id.point9,R.id.point10,R.id.point11,
                R.id.point12,R.id.point13,R.id.point14,R.id.point15,R.id.point16,R.id.point17,
                R.id.point18,R.id.point19,R.id.point20, };
       //массив для прогресса игры конец




        //полключаем анис=мацию начало
        final Animation a = AnimationUtils.loadAnimation(Level2.this, R.anim.alpha);

        //полключаем анис=мацию конец


        numLeft= random.nextInt(10);//генерация числоа от0 - 9
         img_Left.setImageResource(array.images2[numLeft]);
         text_left.setText(array.text2[numLeft]);

         numRight = random.nextInt(10);
         //цикл с предусловие начло
         while (numLeft == numRight){ numRight = random.nextInt(10);}
         //цикл с предусловием конец
          img_right.setImageResource(array.images2[numRight]);
         text_right.setText(array.text2[numRight]);


         // обработка нажатия на левую картинку начало
        img_Left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // условие касания картинки начало
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                 //если конулся картинки начало
                    img_right.setEnabled(false);//блокировка правой картинки
                    if (numLeft > numRight){
                        img_Left.setImageResource(R.drawable.img_true);
                    }else{img_Left.setImageResource(R.drawable.img_false);}
                    //если коснулся картинки конец
                }else if (event.getAction() == MotionEvent.ACTION_UP){
                    // если отпустил палец начало
if (numLeft >numRight){
    if(count < 20){count++;}
    //закрашиваем прогресс серым цветом начало
    for (int i = 0; i < 20; i++) {
        TextView tv = findViewById(progress[i]);
        tv.setBackgroundResource((R.drawable.style_points));
    }
    //закрашиваем прогресс серым цветом когнец
    //определяю правильные ответы и закрашиваю зеоеным
    for (int i = 0; i < count ; i++) {
        TextView tv = findViewById(progress[i]);
        tv.setBackgroundResource(R.drawable.style_points_green);
    }
}else {
if (count > 0){
    if(count == 1){
        count = 0;
    }
    else {
        count = count -2;
    }
}
    for (int i = 0; i < 19; i++) {
        TextView tv = findViewById(progress[i]);
        tv.setBackgroundResource((R.drawable.style_points));
    }
    //закрашиваем прогресс серым цветом когнец
    //определяю правильные ответы и закрашиваю зеоеным
    for (int i = 0; i < count ; i++) {
        TextView tv = findViewById(progress[i]);
        tv.setBackgroundResource(R.drawable.style_points_green);
    }
}
//если отпустил палец конец

                    if(count == 20){
                        //ВЫХОД ИЗ УРОВНЯ
                        dialogEnd.show();
                    }else{

                        numLeft= random.nextInt(10);//генерация числоа от0 - 9
                        img_Left.setImageResource(array.images2[numLeft]);
                        img_Left.startAnimation(a);
                        text_left.setText(array.text2[numLeft]);
                        numRight = random.nextInt(10);
                        //цикл с предусловие начло
                        while (numLeft == numRight){ numRight = random.nextInt(10);}
                        //цикл с предусловием конец
                        img_right.setImageResource(array.images2[numRight]);
                        img_right.startAnimation(a);
                        text_right.setText(array.text2[numRight]);
                        img_right.setEnabled(true);//вкл обраьно правую картинку
                    }
                }

                // условие касания картинки конец

                return true;
            }
        });
         // обработка нажатия на левую картинку конец



        // обработка нажатия на правую картинку начало
        img_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // условие касания картинки начало
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    //если конулся картинки начало
                    img_Left.setEnabled(false);//блокировка левой картинки
                    if (numLeft < numRight){
                        img_right.setImageResource(R.drawable.img_true);
                    }else{img_right.setImageResource(R.drawable.img_false);}
                    //если коснулся картинки конец
                }else if (event.getAction() == MotionEvent.ACTION_UP){
                    // если отпустил палец начало
                    if (numLeft < numRight){
                        if(count < 20){count++;}
                        //закрашиваем прогресс серым цветом начало
                        for (int i = 0; i < 20; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource((R.drawable.style_points));
                        }
                        //закрашиваем прогресс серым цветом когнец
                        //определяю правильные ответы и закрашиваю зеоеным
                        for (int i = 0; i < count ; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    }else {
                        if (count > 0){
                            if(count == 1){
                                count = 0;
                            }
                            else {
                                count = count -2;
                            }
                        }
                        for (int i = 0; i < 19; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource((R.drawable.style_points));
                        }
                        //закрашиваем прогресс серым цветом когнец
                        //определяю правильные ответы и закрашиваю зеоеным
                        for (int i = 0; i < count ; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    }
//если отпустил палец конец

                    if(count == 20){
                        //ВЫХОД ИЗ УРОВНЯ
                        dialogEnd.show();
                    }else{

                        numLeft= random.nextInt(10);//генерация числоа от0 - 9
                        img_Left.setImageResource(array.images2[numLeft]);
                        img_Left.startAnimation(a);
                        text_left.setText(array.text2[numLeft]);
                        numRight = random.nextInt(10);
                        //цикл с предусловие начло
                        while (numLeft == numRight){ numRight = random.nextInt(10);}
                        //цикл с предусловием конец
                        img_right.setImageResource(array.images2[numRight]);
                        img_right.startAnimation(a);
                        text_right.setText(array.text2[numRight]);
                        img_Left.setEnabled(true);//вкл обраьно левую картинку
                    }
                }

                // условие касания картинки конец

                return true;
            }
        });
        // обработка нажатия на правую картинку конец
    }
    //Системная кнопка назад начало
    @Override
    public void onBackPressed(){
        //обработка кнопки назад начало
        try {
            //вернуться назад к выбору уровня начало
            Intent intent = new Intent(Level2.this, GameLevels.class);
            startActivity(intent);finish();
            //вернуться назад к выбору уровня конец
        }catch (Exception e){}
        //обработка кнопки назад конец
    }
    //Системная кнопка назад Конец
}
