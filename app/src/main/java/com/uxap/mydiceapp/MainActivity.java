package com.uxap.mydiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.squareup.seismic.ShakeDetector;

public class MainActivity extends AppCompatActivity implements ShakeDetector.Listener{

    ImageView diceImg1, diceImg2;
    TextView numTextView;
    Button randEventBtn;
    int[] diceImgFrmRes = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        ShakeDetector sd = new ShakeDetector(this);
        sd.start(sensorManager);

        diceImg1 = findViewById(R.id.dice_img_1);
        diceImg2 = findViewById(R.id.dice_img_2);
        numTextView = findViewById(R.id.num_text_view);
        randEventBtn = findViewById(R.id.temp_btn);

        //final MediaPlayer diceSoundEffect = MediaPlayer.create(this, R.raw.dices);
        randEventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] randNums = RandomNumberGenerator.getRandomNum();
                //diceSoundEffect.start();
                int num1 = randNums[0];
                int num2 = randNums[1];
                Log.i("Init-1","Click Event Listened. Num Generated for app : "+num1+ " / "+num2);

                YoYo.with(Techniques.Shake)
                        .duration(700)
                        .repeat(0)
                        .playOn(findViewById(R.id.dice_img_1));
                YoYo.with(Techniques.Shake)
                        .duration(700)
                        .repeat(0)
                        .playOn(findViewById(R.id.dice_img_2));

                numTextView.setText((num1+1)+" / "+(num2+1));
                diceImg1.setImageResource(diceImgFrmRes[num1]);
                diceImg2.setImageResource(diceImgFrmRes[num2]);
            }
        });
    }
    @Override
    public void hearShake() {
        int[] randNums = RandomNumberGenerator.getRandomNum();
        //diceSoundEffect.start();
        int num1 = randNums[0];
        int num2 = randNums[1];
        Log.i("Init-1","Click Event Listened. Num Generated for app : "+num1+ " / "+num2);

        YoYo.with(Techniques.Shake)
                .duration(700)
                .repeat(0)
                .playOn(findViewById(R.id.dice_img_1));
        YoYo.with(Techniques.Shake)
                .duration(700)
                .repeat(0)
                .playOn(findViewById(R.id.dice_img_2));

        numTextView.setText((num1+1)+" / "+(num2+1));
        diceImg1.setImageResource(diceImgFrmRes[num1]);
        diceImg2.setImageResource(diceImgFrmRes[num2]);
    }
}