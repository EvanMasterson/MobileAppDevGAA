package emasterson.mobileappdevgaa;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.services.StatusesService;
import com.twitter.sdk.android.tweetcomposer.ComposerActivity;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;
import com.twitter.sdk.android.tweetcomposer.TweetUploadService;
import com.twitter.sdk.android.tweetui.SearchTimeline;
import com.twitter.sdk.android.tweetui.TimelineResult;
import com.twitter.sdk.android.tweetui.TweetTimelineRecyclerViewAdapter;
import com.twitter.sdk.android.tweetui.UserTimeline;

/*
    @Reference
    https://dev.twitter.com/twitterkit/android/overview
 */
public class TwitterFeedActivity extends BaseActivity{
    String getIntent;
    Button timelineBtn, searchfeedBtn, tweetBtn;
    RecyclerView recyclerView;
    UserTimeline userTimeline;
    SearchTimeline searchTimeline;
    TweetTimelineRecyclerViewAdapter adapter;
    SwipeRefreshLayout swipeLayout;
    boolean isExistTwitterClient = false;
    TwitterSession session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter_feed);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getIntent = getTimeline(getIntent().getIntExtra("county", 0));
        timelineBtn = findViewById(R.id.timelineBtn);
        searchfeedBtn = findViewById(R.id.searchfeedBtn);
        tweetBtn = findViewById(R.id.tweetBtn);
        recyclerView = findViewById(R.id.recyclerView);
        swipeLayout = findViewById(R.id.swipeLayout);
        session = TwitterCore.getInstance().getSessionManager().getActiveSession();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        userTimeline = new UserTimeline.Builder()
                .screenName(getIntent)
                .includeReplies(true)
                .includeRetweets(true)
                .build();

        searchTimeline = new SearchTimeline.Builder()
                .query(getIntent)
                .maxItemsPerRequest(50)
                .build();

        adapter = new TweetTimelineRecyclerViewAdapter.Builder(this)
                .setTimeline(userTimeline)
                .setViewStyle(R.style.tw__TweetLightWithActionsStyle)
                .build();

        recyclerView.setAdapter(adapter);

        timelineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter = new TweetTimelineRecyclerViewAdapter.Builder(getApplicationContext())
                        .setTimeline(userTimeline)
                        .setViewStyle(R.style.tw__TweetLightWithActionsStyle)
                        .build();
                recyclerView.setAdapter(adapter);
            }
        });

        searchfeedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter = new TweetTimelineRecyclerViewAdapter.Builder(getApplicationContext())
                        .setTimeline(searchTimeline)
                        .setViewStyle(R.style.tw__TweetLightWithActionsStyle)
                        .build();
                recyclerView.setAdapter(adapter);
            }
        });

        tweetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                    Check if Twitter app is installed
                    If it is it lets the user compose the tweet from inside our application
                    If not it opens twitter in the browser as we don't have access to the Composer
                 */
                try {
                    ApplicationInfo info = getPackageManager().getApplicationInfo("com.twitter.android", 0 );
                    isExistTwitterClient = true;
                } catch (PackageManager.NameNotFoundException e) {}

                if(isExistTwitterClient) {
                    Intent intent = new ComposerActivity.Builder(TwitterFeedActivity.this)
                            .session(session)
                            .text("@" + getIntent)
                            .createIntent();
                    startActivity(intent);
                    receiver();
                } else {
                    Toast.makeText(getApplicationContext(), "Twitter App is not installed on device, launching in browser!", Toast.LENGTH_LONG).show();
                    TweetComposer.Builder builder = new TweetComposer.Builder(TwitterFeedActivity.this)
                        .text("@" + getIntent);
                     builder.show();
                }
            }
        });

        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeLayout.setRefreshing(true);
                adapter.refresh(new Callback<TimelineResult<Tweet>>() {
                    @Override
                    public void success(Result<TimelineResult<Tweet>> result) {
                        swipeLayout.setRefreshing(false);
                    }

                    @Override
                    public void failure(TwitterException exception) {
                        Toast.makeText(getApplicationContext(), "Unable to Refresh", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    public void receiver(){
        IntentFilter intentFilter = new IntentFilter("com.twitter.sdk.android.tweetcomposer.UPLOAD_SUCCESS");
        MyResultReceiver receiver = new MyResultReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Bundle intentExtras = intent.getExtras();
                if (TweetUploadService.UPLOAD_SUCCESS.equals(intent.getAction())) {
                    // success
                    Long tweetId = intentExtras.getLong(TweetUploadService.EXTRA_TWEET_ID);
                    Toast.makeText(getApplicationContext(), "Successful Tweet", Toast.LENGTH_LONG).show();
                } else if (TweetUploadService.UPLOAD_FAILURE.equals(intent.getAction())) {
                    // failure
                    Intent retryIntent = intentExtras.getParcelable(TweetUploadService.EXTRA_RETRY_INTENT);
                    Toast.makeText(getApplicationContext(), "Failed to Tweet", Toast.LENGTH_LONG).show();
                } else if (TweetUploadService.TWEET_COMPOSE_CANCEL.equals(intent.getAction())) {
                    // cancel
                    Toast.makeText(getApplicationContext(), "Cancelled Tweet", Toast.LENGTH_LONG).show();
                }
            }
        };
        registerReceiver(receiver, intentFilter);
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
