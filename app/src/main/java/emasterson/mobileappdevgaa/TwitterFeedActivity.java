package emasterson.mobileappdevgaa;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.twitter.sdk.android.tweetui.TweetTimelineRecyclerViewAdapter;
import com.twitter.sdk.android.tweetui.UserTimeline;

public class TwitterFeedActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter_feed);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        UserTimeline userTimeline = new UserTimeline.Builder()
                .screenName(getTimeline(getIntent().getIntExtra("county", 0)))
                .build();

        TweetTimelineRecyclerViewAdapter adapter = new TweetTimelineRecyclerViewAdapter.Builder(this)
                .setTimeline(userTimeline)
                .setViewStyle(R.style.tw__TweetLightWithActionsStyle)
                .build();

        recyclerView.setAdapter(adapter);
    }

    public String getTimeline(int stringResource){
        String timeline = "";
        switch(stringResource){
            case R.string.antrim_gaa:
                timeline = "AontroimGAA";
                break;
            case R.string.armagh_gaa:
                timeline = "Armagh_GAA";
                break;
            case R.string.carlow_gaa:
                timeline = "Carlow_GAA";
                break;
            case R.string.cavan_gaa:
                timeline = "CavanCoBoardGaa";
                break;
            case R.string.clare_gaa:
                timeline = "GaaClare";
                break;
            case R.string.cork_gaa:
                timeline = "OfficialCorkGAA";
                break;
            case R.string.derry_gaa:
                timeline = "Doiregaa";
                break;
            case R.string.donegal_gaa:
                timeline = "officialdonegal";
                break;
            case R.string.down_gaa:
                timeline = "OfficialDownGAA";
                break;
            case R.string.dublin_gaa:
                timeline = "DubGAAOfficial";
                break;
            case R.string.fermanagh_gaa:
                timeline = "FermanaghGAA";
                break;
            case R.string.galway_gaa:
                timeline = "Galway_GAA";
                break;
            case R.string.kerry_gaa:
                timeline = "Kerry_Official";
                break;
            case R.string.kildare_gaa:
                timeline = "KildareGAA";
                break;
            case R.string.kilkenny_gaa:
                timeline = "KilkennyCLG";
                break;
            case R.string.laois_gaa:
                timeline = "CLGLaois";
                break;
            case R.string.leitrim_gaa:
                timeline = "LeitrimGAA";
                break;
            case R.string.limerick_gaa:
                timeline = "LimerickCLG";
                break;
            case R.string.longford_gaa:
                timeline = "OfficialLDGAA";
                break;
            case R.string.louth_gaa:
                timeline = "louthgaa";
                break;
            case R.string.mayo_gaa:
                timeline = "MayoGAA";
                break;
            case R.string.meath_gaa:
                timeline = "MeathGAA";
                break;
            case R.string.monaghan_gaa:
                timeline = "monaghangaa";
                break;
            case R.string.offaly_gaa:
                timeline = "Offaly_GAA";
                break;
            case R.string.roscommon_gaa:
                timeline = "RoscommonGAA";
                break;
            case R.string.sligo_gaa:
                timeline = "sligogaa";
                break;
            case R.string.tipperary_gaa:
                timeline = "TipperaryGAA";
                break;
            case R.string.tyrone_gaa:
                timeline = "TyroneGAALive";
                break;
            case R.string.waterford_gaa:
                timeline = "WaterfordGAA";
                break;
            case R.string.westmeath_gaa:
                timeline = "westmeath_gaa";
                break;
            case R.string.wexford_gaa:
                timeline = "OfficialWexGAA";
                break;
            case R.string.wicklow_gaa:
                timeline = "wicklowgaa";
                break;
        }
        return timeline;
    }
}
