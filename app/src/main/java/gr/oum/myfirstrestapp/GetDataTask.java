package gr.oum.myfirstrestapp;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetDataTask extends AsyncTask<String, Void, String> {

    public static final String TAG = "RestApp";

    public String jsonResult;


    public String downloadRestData(String remoteUI){
        Log.d(TAG, "Downloading Data");
        for (int i=0; i<1000000; i++){
            long k = i+1;
        }

        StringBuilder sb = new StringBuilder();
        String result = "";

        try{
            URL url = new URL(remoteUI);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            int responseCode = connection.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK){
                Log.d(TAG, "Request Accepted");

                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                String line = reader.readLine();

                while (line != null){
                    sb.append(line).append("\n");

                    result += line + "\n";

                    line = reader.readLine();
                }
                reader.close();

                return sb.toString();
            }
            else{
                Log.d(TAG, "Something went wrong. Response code was " + responseCode);
            }

        }catch (Exception e){
            Log.e(TAG, "Error happend... ", e);
        }


        return result;
    }

    @Override
    protected String doInBackground(String... strings) {
        String url = strings[0];
        Log.d(TAG, "Doing task on Background for url " + url);
        return downloadRestData(url);
    }

    @Override
    protected void onPostExecute(String result) {
        jsonResult = result;
        Log.d(TAG, "Just got results");
        Log.d(TAG, jsonResult);

    }

    public String getJsonResult() {
        return jsonResult;
    }
}
