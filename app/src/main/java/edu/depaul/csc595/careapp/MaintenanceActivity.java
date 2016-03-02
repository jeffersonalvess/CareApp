package edu.depaul.csc595.careapp;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import edu.depaul.csc595.careapp.ListData.Card;
import edu.depaul.csc595.careapp.ListData.MaintenanceAddTypeList;
import edu.depaul.csc595.careapp.ListData.MaintenanceList;
import edu.depaul.csc595.careapp.main_fragments.CardListAdapter;

public class MaintenanceActivity extends Activity {

    private ListView mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenence);

        mList = (ListView) findViewById(R.id.maintenanceListView);

        final CardListAdapter adapter = new CardListAdapter(getApplicationContext(), new MaintenanceAddTypeList());

        mList.setAdapter(adapter);

        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Intent result = new Intent();
                result.putExtra("Icon", adapter.cardList.PROFILES.get(position).getIcon());
                result.putExtra("ContentTitle", adapter.cardList.PROFILES.get(position).getContentTitle());
                result.putExtra("Line1", adapter.cardList.PROFILES.get(position).getLine1());
                setResult(RESULT_OK, result);
                finish();
            }
        });
    }
}
