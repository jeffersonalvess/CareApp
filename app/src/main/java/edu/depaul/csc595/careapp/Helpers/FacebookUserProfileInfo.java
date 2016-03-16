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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import edu.depaul.csc595.careapp.MainActivity;

/**
 * Created by jeffersonalvess on 3/1/16.
 */
public class FacebookUserProfileInfo extends AsyncTask<Void, Void, FacebookUserInfo>
{

    Context c;
    AccessToken currentAccessToken;
   //public static FacebookUserInfo f = new FacebookUserInfo();

    public FacebookUserProfileInfo(Context c, AccessToken currentAccessToken) throws ExecutionException, InterruptedException
    {
        FacebookSdk.sdkInitialize(c);
        this.c = c;
        this.currentAccessToken = currentAccessToken;

    }

    @Override
    protected FacebookUserInfo doInBackground(Void... params)
    {
        //final FacebookUserInfo f = new FacebookUserInfo();

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

                            MainActivity.f.setUserID(object.getString("id"));
                            MainActivity.f.setUserName(object.getString("first_name") + " " + object.getString("last_name"));
                            MainActivity.f.setUserPicture(profilePictureBitmap);

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

        GraphRequest request2;
        request2 = GraphRequest.newMyFriendsRequest(
                currentAccessToken,
                new GraphRequest.GraphJSONArrayCallback() {
                    @Override
                    public void onCompleted( JSONArray jsonArray, GraphResponse response) {
                        ArrayList<FacebookUserInfo> FriendsList = new ArrayList<FacebookUserInfo>();
                        for(int i =0 ; i< jsonArray.length(); i++) {
                            try {
                                JSONObject friend = jsonArray.getJSONObject(i);

                                URL urlConnection = new URL("https://graph.facebook.com/" + friend.getString("id") + "/picture?type=large");
                                HttpURLConnection connection = (HttpURLConnection) urlConnection.openConnection();
                                connection.setDoInput(true);
                                connection.connect();

                                InputStream input = connection.getInputStream();
                                Bitmap profilePictureBitmap = BitmapFactory.decodeStream(input);

                                FacebookUserInfo newFriend = new FacebookUserInfo();

                                newFriend.setUserID(friend.getString("id"));
                                newFriend.setUserName(friend.getString("name"));
                                newFriend.setUserPicture(profilePictureBitmap);

                                FriendsList.add(newFriend);
                                System.out.println("userId: " + newFriend.getUserID());
                                System.out.println("name: " + newFriend.getUserName());
                                //System.out.println("userId: " + friend.getString("id"));
                                //System.out.println("name: " + friend.getString("name"));

                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        MainActivity.f.setUserFriends(FriendsList);

                    }
                });

//        request2.executeAsync();
        request2.executeAndWait();

        return MainActivity.f;
    }
}

