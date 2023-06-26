package com.professionalcipher.stickers.newyearstickers;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.ads.nativetemplates.NativeTemplateStyle;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;

public class StartUp_Activity extends AppCompatActivity {
    private final String TAG = "Hello";
    AdRequest adRequest = new AdRequest.Builder().build();
    private Button more_apps_btn, rateUs_btn, launch_new_screen_btn;
    private ImageView imageView;
    private ProgressBar progressBar;
    private TemplateView template;
    private SaveDataOnSharePref sharePref;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up);
        Initialization();
        HideAllView();
        MobileAds.initialize(this);
        AdLoader adLoader = new AdLoader.Builder(this, getString(R.string.nativeAd_startUpActivity))
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    @Override
                    public void onNativeAdLoaded( NativeAd nativeAd) {
                        NativeTemplateStyle styles = new
                                NativeTemplateStyle.Builder().build();
                        template.setStyles(styles);
                        template.setNativeAd(nativeAd);
                    }
                })
                .build();

        adLoader.loadAd(adRequest);
        new CountDownTimer(2000, 1000) {
            public void onTick( long millisUntilFinished ) {
            }

            public void onFinish() {
                ShowAllView();
            }
        }.start();

        launch_new_screen_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View view ) {
                Intent intent = new Intent(StartUp_Activity.this, EntryActivity.class);
                startActivity(intent);
            }
        });
        more_apps_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                moreApps_btn_Click(v);
            }
        });
        rateUs_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                Rate_Us_btn(v);
            }
        });
    }

    @Override
    protected void onDestroy() {
        sharePref.setData("1",TAG,StartUp_Activity.this);
        super.onDestroy();
    }

    private void Initialization() {
        imageView = findViewById(R.id.welcomeAnimationView);
        launch_new_screen_btn = findViewById(R.id.viewSticker_btn);
        progressBar = findViewById(R.id.startUp_ProgressBar);
        rateUs_btn = findViewById(R.id.rateUs_btn);
        more_apps_btn  = findViewById(R.id.youtube_btn);
        template = findViewById(R.id.native_ad_view_startupActivity);
        sharePref = new SaveDataOnSharePref();

    }

    private void HideAllView() {
        more_apps_btn.setVisibility(View.GONE);
        imageView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        template.setVisibility(View.GONE);
        rateUs_btn.setVisibility(View.GONE);
        launch_new_screen_btn.setVisibility(View.GONE);

    }

    private void ShowAllView() {
        rateUs_btn.setVisibility(View.VISIBLE);
        more_apps_btn.setVisibility(View.VISIBLE);
        imageView.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
        template.setVisibility(View.VISIBLE);
        launch_new_screen_btn.setVisibility(View.VISIBLE);
        String data = sharePref.getData("0",TAG,StartUp_Activity.this);
        if(data.endsWith("0")){
            Glide.with(this).asGif().load(R.drawable.welcomeanimation).into(imageView);
        }
        else {
            imageView.setImageResource(R.drawable.welcome_back_animation);
            Glide.with(this).asGif().load(R.drawable.welcome_back_animation).into(imageView);
        }

    }

//    private void ShowBannerAds() {
//        startUp_Banner_2.loadAd(adRequest1);
//        startUp_Banner_2.setAdListener(new AdListener() {
//            @Override
//            public void onAdFailedToLoad( @NonNull LoadAdError loadAdError ) {
//                super.onAdFailedToLoad(loadAdError);
//                startUp_Banner_2.loadAd(adRequest1);
//            }
//
//            @Override
//            public void onAdClosed() {
//                super.onAdClosed();
//                startUp_Banner_2.loadAd(adRequest1);
//            }
//
//            @Override
//            public void onAdOpened() {
//                super.onAdOpened();
//            }
//
//            @Override
//            public void onAdLoaded() {
//                super.onAdLoaded();
//                Log.d("Hello", "Banner 2 is Loaded");
//            }
//        });
//
//
//    }


    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item ) {
        int id = item.getItemId();
        if (id == R.id.action_info) {
startActivity(new Intent(StartUp_Activity.this,Show_Privacy_Policy.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    public void moreApps_btn_Click( View view ) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(
                getString(R.string.appStoreDirectory)));
        startActivity(intent);
    }

    public void Rate_Us_btn( View view ) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(
                getString(R.string.appplayStoreLink)));
        startActivity(intent);
    }
}
