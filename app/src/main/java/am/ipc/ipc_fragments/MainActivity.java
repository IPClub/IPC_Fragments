package am.ipc.ipc_fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    enum AnimationType{
        RIGHT_LEFT,LEFT_RIGHT
    }

    LinearLayout container;
    TextView info;
    int fragmentNumber = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container = findViewById(R.id.container);
        info = findViewById(R.id.fragment_barev);
        showFragment(new IPCFragment1(),AnimationType.LEFT_RIGHT);
    }

    public void showFragment(Fragment fragment, AnimationType type){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        switch (type){
            case LEFT_RIGHT:
                ft.setCustomAnimations(R.anim.enter_from_left,R.anim.exit_to_right);
                break;
            case RIGHT_LEFT:
                ft.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left);
                break;
        }
        ft.replace(R.id.container,fragment);
        ft.commit();
    }
    public void previous(View view) {
        if(fragmentNumber == 1){
            showFragment(new IPCFragment2(),AnimationType.RIGHT_LEFT);
            fragmentNumber = 2;
        }else{
            showFragment(new IPCFragment1(),AnimationType.RIGHT_LEFT);
            fragmentNumber = 1;
        }
    }

    public void next(View view) {
        if(fragmentNumber == 1){
            showFragment(new IPCFragment2(),AnimationType.LEFT_RIGHT);
            fragmentNumber = 2;
        }else{
            showFragment(new IPCFragment1(),AnimationType.LEFT_RIGHT);
            fragmentNumber = 1;
        }
    }


    public void changeText(String x){
        info.setText(x);
    }
}
