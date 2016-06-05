package luckyhuman.payakburapa.mytraffic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        //Controller ListView
        controllerListView();

    }// End Main Method

    private void controllerListView() {

        //Setup for Name
        final String[] nameStrings = new String[20];
        nameStrings[0] = "หัวข้อหลักที่ 1";
        nameStrings[1] = "หัวข้อหลักที่ 2";
        nameStrings[2] = "หัวข้อหลักที่ 3";
        nameStrings[3] = "หัวข้อหลักที่ 4";
        nameStrings[4] = "หัวข้อหลักที่ 5";
        nameStrings[5] = "หัวข้อหลักที่ 6";
        nameStrings[6] = "หัวข้อหลักที่ 7";
        nameStrings[7] = "หัวข้อหลักที่ 8";
        nameStrings[8] = "หัวข้อหลักที่ 9";
        nameStrings[9] = "หัวข้อหลักที่ 10";
        nameStrings[10] = "หัวข้อหลักที่ 11";
        nameStrings[11] = "หัวข้อหลักที่ 12";
        nameStrings[12] = "หัวข้อหลักที่ 13";
        nameStrings[13] = "หัวข้อหลักที่ 14";
        nameStrings[14] = "หัวข้อหลักที่ 15";
        nameStrings[15] = "หัวข้อหลักที่ 16";
        nameStrings[16] = "หัวข้อหลักที่ 17";
        nameStrings[17] = "หัวข้อหลักที่ 18";
        nameStrings[18] = "หัวข้อหลักที่ 19";
        nameStrings[19] = "หัวข้อหลักที่ 20";

        //for Detail Short
        String[] detailStrings = getResources().getStringArray(R.array.detail_short);

        //For Image
        MyData myData = new MyData();
        final int[] ints = myData.getInts();

        //Create ListView
        MyAdepter myAdepter = new MyAdepter(this, ints, nameStrings, detailStrings);
        trafficListView.setAdapter(myAdepter);

        trafficListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("Name", nameStrings[position]);
                intent.putExtra("Image", ints[position]);
                intent.putExtra("Index", position);
                startActivity(intent);

            }//onItemClick
        });
    }

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
