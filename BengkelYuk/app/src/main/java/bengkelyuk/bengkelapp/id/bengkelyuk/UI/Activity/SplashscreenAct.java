package bengkelyuk.bengkelapp.id.bengkelyuk.UI.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import bengkelyuk.bengkelapp.id.bengkelyuk.R;
import bengkelyuk.bengkelapp.id.bengkelyuk.SessionManager.UserSession;

public class SplashscreenAct extends AppCompatActivity {
    UserSession userSession;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        userSession = new UserSession(SplashscreenAct.this);

        Thread timerThread = new Thread(){
            public void run(){
                try {
                    sleep(3000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    if (userSession.isUserLoggedIn()){
                        Intent intent = new Intent(SplashscreenAct.this,MainActivity.class);
                        startActivity(intent);
                    }else{
                        Intent intent = new Intent(SplashscreenAct.this,LoginActivity.class);
                        startActivity(intent);
                    }
                }
            }
        };
        timerThread.start();
    }
    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }
}
