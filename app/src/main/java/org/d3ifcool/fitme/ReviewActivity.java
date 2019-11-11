package org.d3ifcool.fitme;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import org.d3ifcool.fitme.model.DataInfo;

import java.util.ArrayList;

public class ReviewActivity extends AppCompatActivity {
    public static final String EXTRA_INT_REVIEW = "extra_INT";
    private DrawerLayout myDrawer;
    private ActionBarDrawerToggle myToggle;

    ImageView gift;
    TextView jdl, gerakan, manfaat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        gift = findViewById(R.id.imageView2);
        jdl = findViewById(R.id.judul_gerakan);
        manfaat = findViewById(R.id.tv_manfaat);
        gerakan = findViewById(R.id.tv_gerakan);

        int pos = getIntent().getIntExtra(EXTRA_INT_REVIEW, 0);

        ArrayList<DataInfo> data = new ArrayList<>();
        data.add(new DataInfo("Sit Up",
                "1.\tTekuk lutut dengan bola kaki dan tumit ditempatkan rata dengan tanah.\n" +
                        "2.\tLetakkan tangan di atas bahu yang berlawanan, sehingga kedua lengan Anda bersilangan di atas dada, atau di belakang kepala seperti yang terlihat pada gambar diatas. Ini memungkinkan Anda mencapai titik kenaikan sentral.\n" +
                        "3.\tKencangkan otot perut secara lembut dengan menarik pusar ke arah tulang belakang Anda. Dengan tetap menjaga agar tumit tetap di atas lantai dan jari-jari kaki rata dengan lantai, secara perlahan dan lembut angkat terlebih dahulu kepala, diikuti oleh tulang belikat Anda. Fokuskan mata Anda pada lutut Anda yang ditekuk, sambil mengontraksi otot-otot perut dengan lembut.",
                "Manfaat dari melakukan Sit Up ialah meningkatkan metabolism, menjaga postur tubuh serta meningkatkan otot inti.",
                R.drawable.situp));
        data.add(new DataInfo("Push Up",
                "1.\tTengkurap di atas lantai.\n " +
                        "2.\tJagalah jarak kedua kaki kamu supaya tetap berdekatan, dan semua berat badan harus dibebankan pada bagian dada kamu.\n" +
                        "3.\tSelanjutnya, letakkan telapak tangan kamu di atas lantai dengan lebar kira-kira sebahu. Dan dengan posisi siku yang mengarah pada jari kaki kamu. Tekuk jari-jari kaki ke arah atas, dan pangkal jari kaki kamu harus menyentuh lantai.\n" +
                        "4.\tAngkat tubuh menggunakan lengan kamu dengan kuat. Pada posisi ini, berat badan kamu akan ditopang hanya pada lengan dan jari kaki. Posisi dari tubuh kamu harus lurus mulai dari ujung kepala hingga ujung kaki, tidak boleh bengkok. Dan posisi ini harus tetap terjaga mulai dari awal posisi push up hingga akhir push up.",
                "Manfaat dari melakukan Push Up ialah meningkatkan otot dada, otot trisep, dan otot deltoid.",
                R.drawable.pushup));
        data.add(new DataInfo("Bench Press",
                "1.\tMulailah dengan berbaring pada sebuah bangku, dalam posisi tubuh yang alami dan rileks. Pastikan Anda tidak menempatkan bahu pada posisi yang tidak nyaman. Ikuti kurva alami tulang belakang Anda. Jangan ratakan punggung bagian bawah di atas kursi, tetapi pastikan Anda juga tidak menekuknya secara berlebihan.\n" +
                        "2.\tAngkat tiang dari rak dan tempatkan tepat di atas bagian tengah dada Anda. Tarik napas saat Anda menurunkannya, sentuhlah dada dengan lembut — pada bagian tengah sternum — dengan tiangnya. Jangan pantulkan tiang dari dada Anda, karena hal ini dapat menyebabkan cedera serius dan membiasakan posisi yang buruk.\n" +
                        "3.\tMulailah mengeluarkan napas saat Anda mendorong tiang kembali ke atas dan menjauhi tubuh Anda.\n" +
                        "4.\tUlurkan tangan dengan maksimal.",
                "Manfaat Bench Press ialah membentuk otot dada, bahu dan tricep, meningkatkan kadar testosteron tubuh, serta meningkatkan kekuatan tulang belakang.",
                R.drawable.benchpress));
        data.add(new DataInfo("Angled Leg Press",
                "1.\tAtur beban terlebih dahulu. Duduk di mesin dan langsung tempatkan kaki Anda pada platform di depan Anda dengan posisi kaki selebar bahu. (Catatan : dalam pembahasan ini, kami menjelaskan dengan posisi kaki sedang atau selebar bahu, namun dalam prakteknya terdapat beberapa posisi kaki).\n" +
                        "2.\tPegang dan rendahkan safety bar pada leg press machine sambil menahan platform dengan kedua kaki, dorong platform sampai kaki Anda lurus, namun perlu diingat agar jangan mengunci kaki Anda ketika dalam posisi lurus. Torso dan kaki sebaiknya membentuk sudut 90 derajat. Posisi ini merupakan posisi awal dari leg press.\n" +
                        "3.\tTarik nafas, perlahan-lahan turunkan platform sampai posisi kaki atas dengan bawah membentuk sudut 90 derajat.\n" +
                        "4.\tDorong kembali dengan menggunakan tumit, dan aktifkan/gunakan otot Quadriceps Anda untuk kembali ke posisi awal. Hembuskan nafas.\n" +
                        "5.\tKetika selesai menggunakan machine, jangan lupa mengunci safety pin pada machine. Pastikan terkunci sehingga Anda tidak tertiban platform. Repetisi latihan dapat Anda sesuaikan dengan goal Anda.",
                "Leg Press menggunakan machine adalah latihan yang baik sekali untuk melatih otot paha karena dengan memposisikan tubuh pada machine dengan benar, tidak akan ada otot lain yang terlibat selama latihan ini. Otot inti yang dilatih adalah Quadriceps atau otot paha depan, namun turut melatih juga otot Gluteal.",
                R.drawable.angledlegpress));
        data.add(new DataInfo("Chin Ups",
                "1.\tLetakkan tangan Anda di tiang dengan posisi kedua telapaknya menghadap ke tubuh. Walau gerakan pull up akan dimulai dengan telapak tangan yang membelakangi tubuh, gerakan chin up dimulai dengan kedua telapak tangan menghadap ke tubuh Anda. Pegang tiangnya dengan nyaman tetapi mantap, pastikan ada jarak beberapa cm di antara kedua tangan Anda.\n" +
                        "2.\tAngkat tubuh hingga dagu Anda berada di atas tiang. Gunakan kekuatan lengan atas Anda untuk mengangkat tubuh mendekati tiang dan berhentilah saat dagu Anda berada di atas tiang. Kedua siku Anda akan tertekuk penuh. Tekuk lutut atau silangkan kedua kaki untuk mendistribusikan berat tubuh Anda dengan lebih merata.\n" +
                        "3.\tTurunkan kembali tubuh Anda. Dengan gerakan lambat yang terkontrol, turunkan tubuh hingga kedua lengan Anda lurus.",
                "Manfaat dari melakukan Chin Ups ialah meningkatkan otot bagian atas, membantu meningkatkan stamina serta meningkatkan otot punggung.",
                R.drawable.chinups));
        data.add(new DataInfo("Concentration Curls",
                "1.\tDuduk di bangku latihan. Concentration curl dasar dilakukan duduk. Cari bangku pendek yang nyaman dan duduk disana. Posisikan kakimu dilantai dan lebarkan lutut kamu dalam posisi seperti “V”. duduk lurus dengan bahu disenderkan kebelakang dan dada kamu dikeluarkan.\n" +
                        "2.\tPegang beban dengan tangan kanan. Jika belum, ambil beban dan bawa ke bangku. Pegang dengan tangan kanan dan taruh siku kamu di dibagian dalam paha kanan kamu, atau lutut kamu. Pelan-pelan turunkan beban ke lantai.\n" +
                        "3.\t“Curl” bebannya keatas. Ketika bebannya berada dibawah, keraskan bicep kamu untuk mengangkat beban keatas kembali. Tangan bagian atas dan bahu kamu tetap diam ketika melakukan ini. Jika kamu menggerakannya, kedua bagian itu dapat “membantu” bicep kamu ketika mengangkat, mengurangi efektifitas dari latihan ini.\n" +
                        "4.\tPelan-pelan menurunkan bebannya. Ketika kamu sudah menaikkan bebannya setinggi mungkin (kurang lebih dekat dada atau badan), pelan-pelan dan sedikit demi sedikit menurunkan beban kembai ke lantai. Bagian ini sama pentingnya seperti bagian kamu mengangkat; jangan menurunkan beban dengan cepat ke lantai atau kamu akan menghilangi banyak bagian dari latihan.\n" +
                        "5.\tUlangi gerakan keatas dan kebawah ini. Ketika beban dibawah badan lagi dan kamu hampir meluruskan tangan kamu, keraskan bicep lagi untuk mengangkatnya. Ualngi proses mengangkat ini dan turunkan beban kembali sampai merasakan rasa “panas”.\n" +
                        "6.\tGanti tangan dan ulangi. Ketika kamu sudah berlatih sampai merasakan panas pada satu tangan, ganti dengan tangan satunya dan lakukan gerakan yang sama seperti sebelumnya. Setelah melatih kedua tangan, beristirahatlah sebentar (sekitar 30 detik sampai 1 menit biasanya cukup) dan ulangi sebanyak yang kamu mau.\n",
                "Manfaat melakukan Concentration Curls ialah memperkencang otot bisep.",
                R.drawable.concentrationcurls));
        data.add(new DataInfo("Dumbbell Presses",
                "1.\tPosisi punggung tegak\n" +
                        "2.\tTangan memegang dumbbell dengan posisi forearm vertical\n" +
                        "3.\tPosisi siku tidak lebih belakang dari bahu (minimal sejajar)\n" +
                        "4.\tKaki menyentuh lantai\n" +
                        "5.\tAngkat Dumbbell dengan posisi punggung tetap tegak. (tidak bergerak)\n" +
                        "6.\tTarik nafas saat menurunkan beban dan hembuskan nafas saat mengangkat beban\n",
                "Manfaat melakukan Dumbbell Presses ialah meningkatkankan otot bahu, otot lat serta perut.",
                R.drawable.dumbbelpresses));
        data.add(new DataInfo("Plank",
                "1.\tAmbil Posisi. Untuk melakukan plank dengan baik, pastikan tubuh Anda dalam posisi yang benar. Perut menghadap ke lantai, mulai dengan tangan posisi lurus lalu letakkan tangan di bawah sejajar dengan bahu Anda.\n" +
                        "2.\tKemudian, turunkan lengan sehingga bertumpu pada siku Anda. Usahakan lengan Anda pada sudut 90 derajat dan ujung siku di bawah dan sejajar dengan bahu Anda.\n",
                "Manfaatnya yaitu membakar lemak lebih cepat, memperkuat otot punggung dan memperbaiki postur tubuh.",
                R.drawable.plank));
        data.add(new DataInfo("Low Pulley Cable Crossover",
                "1.\tMulai dengan sikap kuda-kuda dengan tubuh diposisikan di tengah mesin kabel ganda, pasang satu beban pada salah satu sisi. Atur pegangan agar sedikit ke bawah dari tinggi bahu. Pegang gagang sehingga kedua telapak tangan menghadap ke depan dan kedua lengan berada sejajar dengan lantai. Pertahankan kedua siku sedikit menekuk.\n" +
                        "2.\tKencangkan otot pecs dan dorong kedua lengan ke depan Anda, jaga tubuh sedikit condong ke depan dari pinggang ke atas. Berhenti sejenak, lalu kembali ke posisi awal secara perlahan.\n",
                "Manfaat dari Low Pulley Cable Crossover yaitu melatih dan meningkatkan otot dada, otot deltoid serta trisep.",
                R.drawable.lowpulley));

        if (pos == 0) {
            DataInfo dataInfo = data.get(0);
            gift.setImageResource(dataInfo.getImageResId());
            jdl.setText(dataInfo.getJudulGerakan());
            gerakan.setText(dataInfo.getIsiInfo());
            manfaat.setText(dataInfo.getIsiManfaat());
        } else if (pos == 1) {
            DataInfo dataInfo = data.get(1);
            gift.setImageResource(dataInfo.getImageResId());
            jdl.setText(dataInfo.getJudulGerakan());
            gerakan.setText(dataInfo.getIsiInfo());
            manfaat.setText(dataInfo.getIsiManfaat());
        } else if (pos == 2) {
            DataInfo dataInfo = data.get(2);
            gift.setImageResource(dataInfo.getImageResId());
            jdl.setText(dataInfo.getJudulGerakan());
            gerakan.setText(dataInfo.getIsiInfo());
            manfaat.setText(dataInfo.getIsiManfaat());
        } else if (pos == 3) {
            DataInfo dataInfo = data.get(3);
            gift.setImageResource(dataInfo.getImageResId());
            jdl.setText(dataInfo.getJudulGerakan());
            gerakan.setText(dataInfo.getIsiInfo());
            manfaat.setText(dataInfo.getIsiManfaat());
        } else if (pos == 4) {
            DataInfo dataInfo = data.get(4);
            gift.setImageResource(dataInfo.getImageResId());
            jdl.setText(dataInfo.getJudulGerakan());
            gerakan.setText(dataInfo.getIsiInfo());
            manfaat.setText(dataInfo.getIsiManfaat());
        } else if (pos == 5) {
            DataInfo dataInfo = data.get(5);
            gift.setImageResource(dataInfo.getImageResId());
            jdl.setText(dataInfo.getJudulGerakan());
            gerakan.setText(dataInfo.getIsiInfo());
            manfaat.setText(dataInfo.getIsiManfaat());
        } else if (pos == 6) {
            DataInfo dataInfo = data.get(6);
            gift.setImageResource(dataInfo.getImageResId());
            jdl.setText(dataInfo.getJudulGerakan());
            gerakan.setText(dataInfo.getIsiInfo());
            manfaat.setText(dataInfo.getIsiManfaat());
        } else if (pos == 7) {
            DataInfo dataInfo = data.get(7);
            gift.setImageResource(dataInfo.getImageResId());
            jdl.setText(dataInfo.getJudulGerakan());
            gerakan.setText(dataInfo.getIsiInfo());
            manfaat.setText(dataInfo.getIsiManfaat());
        } else if (pos == 8) {
            DataInfo dataInfo = data.get(8);
            gift.setImageResource(dataInfo.getImageResId());
            jdl.setText(dataInfo.getJudulGerakan());
            gerakan.setText(dataInfo.getIsiInfo());
            manfaat.setText(dataInfo.getIsiManfaat());
        } else if (pos == 9) {
            DataInfo dataInfo = data.get(9);
            gift.setImageResource(dataInfo.getImageResId());
            jdl.setText(dataInfo.getJudulGerakan());
            gerakan.setText(dataInfo.getIsiInfo());
            manfaat.setText(dataInfo.getIsiManfaat());
        } else if (pos == 10) {
            DataInfo dataInfo = data.get(10);
            gift.setImageResource(dataInfo.getImageResId());
            jdl.setText(dataInfo.getJudulGerakan());
            gerakan.setText(dataInfo.getIsiInfo());
            manfaat.setText(dataInfo.getIsiManfaat());
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (myToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                selectItemDrawer(menuItem);
                return true;
            }
        });
    }

    private void selectItemDrawer(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.menu_bmi:
                Intent bmiClass = new Intent(this, MainActivity.class);
                bmiClass.setFlags(bmiClass.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(bmiClass);
                finish();
                break;
            case R.id.menu_workout:
                Intent workout_class = new Intent(this, WorkoutActivity.class);
                workout_class.setFlags(workout_class.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(workout_class);
                finish();
                break;
            case R.id.menu_report:
                Intent report_class = new Intent(this, ReportActivity.class);
                report_class.setFlags(report_class.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(report_class);
                finish();
                break;
            case R.id.menu_grafik:
                Intent grafik_class = new Intent(this, GrafikActivity.class);
                grafik_class.setFlags(grafik_class.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(grafik_class);
                finish();
                break;
            case R.id.menu_quiz:
                Intent quiz_class = new Intent(this, QuizActivity.class);
                quiz_class.setFlags(quiz_class.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(quiz_class);
                finish();
                break;
            case R.id.menu_video:
                Intent video_class = new Intent(this, ArticleActivity.class);
                video_class.setFlags(video_class.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(video_class);
                finish();
                break;
            case R.id.menu_about:
                Intent about_class = new Intent(this, AboutActivity.class);
                about_class.setFlags(about_class.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(about_class);
                break;
        }
        myDrawer.closeDrawers();
    }

    @Override
    public void onBackPressed() {
        Intent back_class = new Intent(this, WorkoutActivity.class);
        startActivity(back_class);
        finish();
    }

    public void mulaiExercise(View view) {
        int pos = getIntent().getIntExtra(EXTRA_INT_REVIEW, 0);
        if (pos == 0) {
            Intent mulai_hitungExercise = new Intent(this, CountdownActivity.class);
            mulai_hitungExercise.putExtra(CountdownActivity.EXTRA_INT_COUNTDOWN, pos);
            startActivity(mulai_hitungExercise);
            finish();
        } else if (pos == 1) {
            Intent mulai_hitungExercise = new Intent(this, CountdownActivity.class);
            mulai_hitungExercise.putExtra(CountdownActivity.EXTRA_INT_COUNTDOWN, pos);
            startActivity(mulai_hitungExercise);
            finish();
        } else if (pos == 2) {
            Intent mulai_hitungExercise = new Intent(this, CountdownActivity.class);
            mulai_hitungExercise.putExtra(CountdownActivity.EXTRA_INT_COUNTDOWN, pos);
            startActivity(mulai_hitungExercise);
            finish();
        }
    }
}