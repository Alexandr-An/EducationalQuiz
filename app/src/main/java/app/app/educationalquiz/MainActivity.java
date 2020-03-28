package app.app.educationalquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private long backPressedTime;// для кнопки назад системной

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);// связь с окном игры
//связываю кнопку buttonStart начало
        Button buttonStart = (Button)findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
Intent intent = new Intent(MainActivity.this, GameLevels.class);
startActivity(intent);finish();
                }catch (Exception e){}
            }
        });
        //связываю кнопку buttonStart конец

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); // Убрать строку состояния.
    }
    //системная кнопка назад начало

    @Override
    public void onBackPressed() {

        if(backPressedTime + 2000 > System.currentTimeMillis()){
            super.onBackPressed();// оманда закрывает приложение
            return;
        }else {
            Toast.makeText(getBaseContext(), " Нажмите ещё раз, чтобы выйти.",Toast.LENGTH_SHORT).show();//иначе вывод текста
        }
        backPressedTime = System.currentTimeMillis();// получаем время
    }

    //системная кнопка назад конец
}
