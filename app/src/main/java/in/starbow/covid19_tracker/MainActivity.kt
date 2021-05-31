package `in`.starbow.covid19_tracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchResult()
    }
    private fun fetchResult(){
        GlobalScope.launch (Dispatchers.Main){
            val response = withContext(Dispatchers.IO){Client.api.execute()}
            if(response.isSuccessful)
            {
            //    response.body?.string()?.let { Log.i("info", it) }
                val data = Gson().fromJson(response.body?.string(),Response::class.java)
            }
        }

    }
}