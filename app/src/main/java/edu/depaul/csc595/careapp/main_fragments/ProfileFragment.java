package edu.depaul.csc595.careapp.main_fragments;


import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import de.hdodenhof.circleimageview.CircleImageView;
import edu.depaul.csc595.careapp.ListData.Card;
import edu.depaul.csc595.careapp.ListData.CardList;
import edu.depaul.csc595.careapp.ListData.ProfileList;
import edu.depaul.csc595.careapp.R;
import edu.depaul.csc595.careapp.TestActivity;

public class ProfileFragment extends Fragment {

    private ListView mList;
    private View view;
    String userName;
    String userID;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_profile, container, false);

        //TODO: Criar isso aqui dentro de uma classe com metodos para retorno dos valores, assim fica mais facil acessa isso de qualquer do codigo.
        //Method to get Facebook information
        GraphRequest request;
        request = GraphRequest.newMeRequest(
                AccessToken.getCurrentAccessToken(),
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {

                        try {
                            //userLocation = object.getJSONObject("user_location").getString("name");
                            saveProfileInformation(object.getString("first_name") + " " + object.getString("last_name"), object.getString("id"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id, location, last_name, first_name");
        request.setParameters(parameters);
        request.executeAsync();
        // Facebook end.

        mList = (ListView) view.findViewById(R.id.profile_list);

        CardListAdapter adapter = new CardListAdapter(getContext(), new ProfileList());

        mList.setAdapter(adapter);

        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override public void onItemClick(AdapterView<?> arg0, View arg1,int position, long arg3)
            {
                Toast.makeText(getActivity(), "Stop Clicking me " + position, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    //This method is part of facebook implementation
    void saveProfileInformation(String name, String id) throws IOException {

        userName = name;
        userID = id;
        setInformationToView();
    }

    //This method is part of facebook implementation
    void setInformationToView() throws IOException {

        TextView txtUserName = (TextView) view.findViewById(R.id.username);
        CircleImageView imagem1 = (CircleImageView) view.findViewById(R.id.imgRoundedRight);

        txtUserName.setText(userName);
        new ImageLoadTask("https://graph.facebook.com/" + userID + "/picture?type=large", imagem1).execute();

    }

    //This method is part of facebook implementation
    class ImageLoadTask extends AsyncTask<Void, Void, Bitmap> {

        private String url;
        private CircleImageView imageView;

        public ImageLoadTask(String url, CircleImageView imageView) {
            this.url = url;
            this.imageView = imageView;
        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            try {
                URL urlConnection = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) urlConnection.openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                Bitmap myBitmap = BitmapFactory.decodeStream(input);
                return myBitmap;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            super.onPostExecute(result);
            imageView.setImageBitmap(result);
        }
    }




    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
