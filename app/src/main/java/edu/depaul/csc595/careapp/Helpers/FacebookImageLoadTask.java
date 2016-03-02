package edu.depaul.csc595.careapp.Helpers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class FacebookImageLoadTask extends AsyncTask<Void, Void, Bitmap>
{

    // I'm not using this class, but I'll leave it here because the code is a good reference.

    private String userID;

    public FacebookImageLoadTask(String userID) {
        this.userID = userID;
    }

    @Override
    protected Bitmap doInBackground(Void... params) {

        try
        {
            URL urlConnection = new URL("https://graph.facebook.com/" + this.userID + "/picture?type=large");
            HttpURLConnection connection = (HttpURLConnection) urlConnection.openConnection();
            connection.setDoInput(true);
            connection.connect();

            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);

            return myBitmap;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
