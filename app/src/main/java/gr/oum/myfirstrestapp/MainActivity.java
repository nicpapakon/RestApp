package gr.oum.myfirstrestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "RestApp";

    private static final String REMOTE_API = "https://jsonplaceholder.typicode.com/posts";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: Starting Download from Web Service Data");

        GetDataTask getDataTaskObject = new GetDataTask();

        //getDataTaskObject.downloadRestData(REMOTE_API);

        getDataTaskObject.execute(REMOTE_API);

        //String jsonResult = getDataTaskObject.getJsonResult();

        //Log.d(TAG, "JSON_RESULT = " +jsonResult);

        Log.d(TAG, "STARTED ASYNC REQUEST...");
    }
}