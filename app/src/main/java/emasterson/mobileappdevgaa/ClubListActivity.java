package emasterson.mobileappdevgaa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClubListActivity extends BaseActivity implements View.OnClickListener{
    private Button antrimBtn, armaghBtn, carlowBtn, cavanBtn, clareBtn, corkBtn, derryBtn,
            donegalBtn, downBtn, dublinBtn, fermanaghBtn, galwayBtn, kerryBtn, kildareBtn,
            kilkennyBtn, laoisBtn, leitrimBtn, limerickBtn, longfordBtn, louthBtn, mayoBtn,
            meathBtn, monaghanBtn, offalyBtn, roscommonBtn, sligoBtn, tipperaryBtn, tyroneBtn,
            waterfordBtn, westmeathBtn, wexfordBtn, wicklowBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_list);

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

    public void onClick(View view){
        Intent i = new Intent(getApplicationContext(), TwitterFeedActivity.class);
        switch(view.getId()){
            case R.id.antrimBtn:
                i.putExtra("county", R.string.antrim_gaa);
                startActivity(i);
                break;
            case R.id.armaghBtn:
                i.putExtra("county", R.string.armagh_gaa);
                startActivity(i);
                break;
            case R.id.carlowBtn:
                i.putExtra("county", R.string.carlow_gaa);
                startActivity(i);
                break;
            case R.id.cavanBtn:
                i.putExtra("county", R.string.cavan_gaa);
                startActivity(i);
                break;
            case R.id.clareBtn:
                i.putExtra("county", R.string.clare_gaa);
                startActivity(i);
                break;
            case R.id.corkBtn:
                i.putExtra("county", R.string.cork_gaa);
                startActivity(i);
                break;
            case R.id.derryBtn:
                i.putExtra("county", R.string.derry_gaa);
                startActivity(i);
                break;
            case R.id.donegalBtn:
                i.putExtra("county", R.string.donegal_gaa);
                startActivity(i);
                break;
            case R.id.downBtn:
                i.putExtra("county", R.string.down_gaa);
                startActivity(i);
                break;
            case R.id.dublinBtn:
                i.putExtra("county", R.string.dublin_gaa);
                startActivity(i);
                break;
            case R.id.fermanaghBtn:
                i.putExtra("county", R.string.fermanagh_gaa);
                startActivity(i);
                break;
            case R.id.galwayBtn:
                i.putExtra("county", R.string.galway_gaa);
                startActivity(i);
                break;
            case R.id.kerryBtn:
                i.putExtra("county", R.string.kerry_gaa);
                startActivity(i);
                break;
            case R.id.kildareBtn:
                i.putExtra("county", R.string.kildare_gaa);
                startActivity(i);
                break;
            case R.id.kilkennyBtn:
                i.putExtra("county", R.string.kilkenny_gaa);
                startActivity(i);
                break;
            case R.id.laoisBtn:
                i.putExtra("county", R.string.laois_gaa);
                startActivity(i);
                break;
            case R.id.leitrimBtn:
                i.putExtra("county", R.string.leitrim_gaa);
                startActivity(i);
                break;
            case R.id.limerickBtn:
                i.putExtra("county", R.string.limerick_gaa);
                startActivity(i);
                break;
            case R.id.longfordBtn:
                i.putExtra("county", R.string.longford_gaa);
                startActivity(i);
                break;
            case R.id.louthBtn:
                i.putExtra("county", R.string.louth_gaa);
                startActivity(i);
                break;
            case R.id.mayoBtn:
                i.putExtra("county", R.string.mayo_gaa);
                startActivity(i);
                break;
            case R.id.meathBtn:
                i.putExtra("county", R.string.meath_gaa);
                startActivity(i);
                break;
            case R.id.monaghanBtn:
                i.putExtra("county", R.string.monaghan_gaa);
                startActivity(i);
                break;
            case R.id.offalyBtn:
                i.putExtra("county", R.string.offaly_gaa);
                startActivity(i);
                break;
            case R.id.roscommonBtn:
                i.putExtra("county", R.string.roscommon_gaa);
                startActivity(i);
                break;
            case R.id.sligoBtn:
                i.putExtra("county", R.string.sligo_gaa);
                startActivity(i);
                break;
            case R.id.tipperaryBtn:
                i.putExtra("county", R.string.tipperary_gaa);
                startActivity(i);
                break;
            case R.id.tyroneBtn:
                i.putExtra("county", R.string.tyrone_gaa);
                startActivity(i);
                break;
            case R.id.waterfordBtn:
                i.putExtra("county", R.string.waterford_gaa);
                startActivity(i);
                break;
            case R.id.westmeathBtn:
                i.putExtra("county", R.string.westmeath_gaa);
                startActivity(i);
                break;
            case R.id.wexfordBtn:
                i.putExtra("county", R.string.wexford_gaa);
                startActivity(i);
                break;
            case R.id.wicklowBtn:
                i.putExtra("county", R.string.wicklow_gaa);
                startActivity(i);
                break;
        }
    }
}
