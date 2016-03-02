package edu.depaul.csc595.careapp.Helpers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by jeffersonalvess on 3/1/16.
 */
public class FacebookUserProfileInfo extends AsyncTask<Void, Void, FacebookUserInfo>
{

    Context c;
    AccessToken currentAccessToken;

    public FacebookUserProfileInfo(Context c, AccessToken currentAccessToken) throws ExecutionException, InterruptedException
    {
        FacebookSdk.sdkInitialize(c);
        this.c = c;
        this.currentAccessToken = currentAccessToken;

    }

    @Override
    protected FacebookUserInfo doInBackground(Void... params)
    {
        final FacebookUserInfo f = new FacebookUserInfo();

        GraphRequest request = GraphRequest.newMeRequest(
                currentAccessToken,
                new GraphRequest.GraphJSONObjectCallback()
                {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response)
                    {
                        try
                        {
                            URL urlConnection = new URL("https://graph.facebook.com/" + object.getString("id") + "/picture?type=large");
                            HttpURLConnection connection = (HttpURLConnection) urlConnection.openConnection();
                            connection.setDoInput(true);
                            connection.connect();

                            InputStream input = connection.getInputStream();
                            Bitmap profilePictureBitmap = BitmapFactory.decodeStream(input);

                            f.setUserID(object.getString("id"));
                            f.setUserName(object.getString("first_name") + " " + object.getString("last_name"));
                            f.setUserPicture(profilePictureBitmap);

                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                });

        Bundle parameters = new Bundle();
        parameters.putString("fields", "id, last_name, first_name");

        request.setParameters(parameters);
        request.executeAndWait();

        return f;
    }
}

