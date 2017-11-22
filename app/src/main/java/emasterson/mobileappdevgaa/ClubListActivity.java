package emasterson.mobileappdevgaa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class ClubListActivity extends AppCompatActivity implements View.OnClickListener{
    private FirebaseAuth auth;
    private Button antrimBtn, armaghBtn, carlowBtn, cavanBtn, clareBtn, corkBtn, derryBtn,
            donegalBtn, downBtn, dublinBtn, fermanaghBtn, galwayBtn, kerryBtn, kildareBtn,
            kilkennyBtn, laoisBtn, leitrimBtn, limerickBtn, longfordBtn, louthBtn, mayoBtn,
            meathBtn, monaghanBtn, offalyBtn, roscommonBtn, sligoBtn, tipperaryBtn, tyroneBtn,
            waterfordBtn, westmeathBtn, wexfordBtn, wicklowBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_list);

        auth = FirebaseAuth.getInstance();

        antrimBtn = findViewById(R.id.antrimBtn);
        armaghBtn = findViewById(R.id.armaghBtn);
        carlowBtn = findViewById(R.id.carlowBtn);
        cavanBtn = findViewById(R.id.cavanBtn);
        clareBtn = findViewById(R.id.clareBtn);
        corkBtn = findViewById(R.id.corkBtn);
        derryBtn = findViewById(R.id.derryBtn);
        donegalBtn = findViewById(R.id.donegalBtn);
        downBtn = findViewById(R.id.downBtn);
        dublinBtn = findViewById(R.id.dublinBtn);
        fermanaghBtn = findViewById(R.id.fermanaghBtn);
        galwayBtn = findViewById(R.id.galwayBtn);
        kerryBtn = findViewById(R.id.kerryBtn);
        kildareBtn = findViewById(R.id.kildareBtn);
        kilkennyBtn = findViewById(R.id.kilkennyBtn);
        laoisBtn = findViewById(R.id.laoisBtn);
        leitrimBtn = findViewById(R.id.leitrimBtn);
        limerickBtn = findViewById(R.id.limerickBtn);
        longfordBtn = findViewById(R.id.longfordBtn);
        louthBtn = findViewById(R.id.louthBtn);
        mayoBtn = findViewById(R.id.mayoBtn);
        meathBtn = findViewById(R.id.meathBtn);
        monaghanBtn = findViewById(R.id.monaghanBtn);
        offalyBtn = findViewById(R.id.offalyBtn);
        roscommonBtn = findViewById(R.id.roscommonBtn);
        sligoBtn = findViewById(R.id.sligoBtn);
        tipperaryBtn = findViewById(R.id.tipperaryBtn);
        tyroneBtn = findViewById(R.id.tyroneBtn);
        waterfordBtn = findViewById(R.id.waterfordBtn);
        westmeathBtn = findViewById(R.id.westmeathBtn);
        wexfordBtn = findViewById(R.id.wexfordBtn);
        wicklowBtn = findViewById(R.id.wicklowBtn);

        antrimBtn.setOnClickListener(this);
        armaghBtn.setOnClickListener(this);
        carlowBtn.setOnClickListener(this);
        cavanBtn.setOnClickListener(this);
        clareBtn.setOnClickListener(this);
        corkBtn.setOnClickListener(this);
        derryBtn.setOnClickListener(this);
        donegalBtn.setOnClickListener(this);
        downBtn.setOnClickListener(this);
        dublinBtn.setOnClickListener(this);
        fermanaghBtn.setOnClickListener(this);
        galwayBtn.setOnClickListener(this);
        kerryBtn.setOnClickListener(this);
        kildareBtn.setOnClickListener(this);
        kilkennyBtn.setOnClickListener(this);
        laoisBtn.setOnClickListener(this);
        leitrimBtn.setOnClickListener(this);
        limerickBtn.setOnClickListener(this);
        longfordBtn.setOnClickListener(this);
        louthBtn.setOnClickListener(this);
        mayoBtn.setOnClickListener(this);
        meathBtn.setOnClickListener(this);
        monaghanBtn.setOnClickListener(this);
        offalyBtn.setOnClickListener(this);
        roscommonBtn.setOnClickListener(this);
        sligoBtn.setOnClickListener(this);
        tipperaryBtn.setOnClickListener(this);
        tyroneBtn.setOnClickListener(this);
        waterfordBtn.setOnClickListener(this);
        westmeathBtn.setOnClickListener(this);
        wexfordBtn.setOnClickListener(this);
        wicklowBtn.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.logout:
                auth.signOut();
                Toast.makeText(getApplicationContext(), "Logged out", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onClick(View view){
        Intent i = new Intent(getApplicationContext(), TwitterFeedActivity.class);
        switch(view.getId()){
            case R.id.antrimBtn:
                i.putExtra("county", antrimBtn.getText());
                startActivity(i);
                break;
            case R.id.armaghBtn:
                i.putExtra("county", armaghBtn.getText());
                startActivity(i);
                break;
            case R.id.carlowBtn:
                i.putExtra("county", carlowBtn.getText());
                startActivity(i);
                break;
            case R.id.cavanBtn:
                i.putExtra("county", cavanBtn.getText());
                startActivity(i);
                break;
            case R.id.clareBtn:
                i.putExtra("county", clareBtn.getText());
                startActivity(i);
                break;
            case R.id.corkBtn:
                i.putExtra("county", corkBtn.getText());
                startActivity(i);
                break;
            case R.id.derryBtn:
                i.putExtra("county", derryBtn.getText());
                startActivity(i);
                break;
            case R.id.donegalBtn:
                i.putExtra("county", donegalBtn.getText());
                startActivity(i);
                break;
            case R.id.downBtn:
                i.putExtra("county", downBtn.getText());
                startActivity(i);
                break;
            case R.id.dublinBtn:
                i.putExtra("county", dublinBtn.getText());
                startActivity(i);
                break;
            case R.id.fermanaghBtn:
                i.putExtra("county", fermanaghBtn.getText());
                startActivity(i);
                break;
            case R.id.galwayBtn:
                i.putExtra("county", galwayBtn.getText());
                startActivity(i);
                break;
            case R.id.kerryBtn:
                i.putExtra("county", kerryBtn.getText());
                startActivity(i);
                break;
            case R.id.kildareBtn:
                i.putExtra("county", kildareBtn.getText());
                startActivity(i);
                break;
            case R.id.kilkennyBtn:
                i.putExtra("county", kilkennyBtn.getText());
                startActivity(i);
                break;
            case R.id.laoisBtn:
                i.putExtra("county", laoisBtn.getText());
                startActivity(i);
                break;
            case R.id.leitrimBtn:
                i.putExtra("county", leitrimBtn.getText());
                startActivity(i);
                break;
            case R.id.limerickBtn:
                i.putExtra("county", limerickBtn.getText());
                startActivity(i);
                break;
            case R.id.longfordBtn:
                i.putExtra("county", longfordBtn.getText());
                startActivity(i);
                break;
            case R.id.louthBtn:
                i.putExtra("county", louthBtn.getText());
                startActivity(i);
                break;
            case R.id.mayoBtn:
                i.putExtra("county", mayoBtn.getText());
                startActivity(i);
                break;
            case R.id.meathBtn:
                i.putExtra("county", meathBtn.getText());
                startActivity(i);
                break;
            case R.id.monaghanBtn:
                i.putExtra("county", monaghanBtn.getText());
                startActivity(i);
                break;
            case R.id.offalyBtn:
                i.putExtra("county", offalyBtn.getText());
                startActivity(i);
                break;
            case R.id.roscommonBtn:
                i.putExtra("county", roscommonBtn.getText());
                startActivity(i);
                break;
            case R.id.sligoBtn:
                i.putExtra("county", sligoBtn.getText());
                startActivity(i);
                break;
            case R.id.tipperaryBtn:
                i.putExtra("county", tipperaryBtn.getText());
                startActivity(i);
                break;
            case R.id.tyroneBtn:
                i.putExtra("county", tyroneBtn.getText());
                startActivity(i);
                break;
            case R.id.waterfordBtn:
                i.putExtra("county", waterfordBtn.getText());
                startActivity(i);
                break;
            case R.id.westmeathBtn:
                i.putExtra("county", westmeathBtn.getText());
                startActivity(i);
                break;
            case R.id.wexfordBtn:
                i.putExtra("county", wexfordBtn.getText());
                startActivity(i);
                break;
            case R.id.wicklowBtn:
                i.putExtra("county", wicklowBtn.getText());
                startActivity(i);
                break;
        }
    }
}
