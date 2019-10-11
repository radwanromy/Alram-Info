package abu.alarm;  
  
import android.app.Activity;  
import android.app.AlarmManager;  
import android.app.PendingIntent;  
import android.content.Intent;  
import android.os.Bundle;  
import android.view.View;  
import android.view.View.OnClickListener;  
import android.widget.Button;  
import android.widget.EditText;  
import android.widget.Toast;  
  
public class MainActivity extends Activity {  
    Button b1;  
  
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  
        b1=(Button) findViewById(R.id.button1);  
  
        b1.setOnClickListener(new OnClickListener() {  
  
            @Override  
            public void onClick(View v) {  
                // TODO Auto-generated method stub  
                startAlert();  
            }  
        });  
  
    }   public void startAlert() {  
        EditText text = (EditText) findViewById(R.id.time);  
        int i = Integer.parseInt(text.getText().toString());  
        Intent intent = new Intent(this, MyBroadcastReceiver.class);  
        PendingIntent pendingIntent = PendingIntent.getBroadcast(  
                this.getApplicationContext(), 234324243, intent, 0);  
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);  
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()  
                + (i * 1000), pendingIntent);  
        Toast.makeText(this, "Alarm set in " + i + " seconds",Toast.LENGTH_LONG).show();  
    }  
  
}  
