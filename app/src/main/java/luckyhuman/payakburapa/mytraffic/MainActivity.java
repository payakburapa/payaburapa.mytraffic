package luckyhuman.payakburapa.mytraffic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {// Start Main Class (เริ่ม Code หลัก)

    //วิธีการ Explicit หรือ การประกาศตัวแปร
    private ListView trafficListView;//Access(private,public),type,name;ปุ่ม listview
    private Button aboutMeButton;//ปุ่ม Buttom(About me)
    private String urlYoutubeString = "https://youtu.be/g9L7PXcIaKU";//เป็นการกำหนดตัวแปร URL เพื่อที่จะ Copy url like มาใส่

    @Override
    protected void onCreate(Bundle savedInstanceState) {// Start Main Method
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget (การผูกคำสั่งกับพวกปุ่ม)
        trafficListView = (ListView) findViewById(R.id.listView);
        aboutMeButton = (Button) findViewById(R.id.button);

        //Controller button(method สร้างเอง) แล้วมันจะcreate method ให้ข้างล่าง
        controllerButton();

    }// End Main Method

    private void controllerButton() {

        aboutMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Sound Effect
                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.bird);//getBaseContext()คือการmatแหล่งกำเนิดเสียงกับโปรแกรม
                mediaPlayer.start();

                //Start Web View
                Intent intent = new Intent(Intent.ACTION_VIEW);//สร้าง Constant
                intent.setData(Uri.parse(urlYoutubeString));
                startActivity(intent);
                //End Web View


            } //onClick
        });

    } //Controller

}// End Main Class (จบ Code หลัก)
