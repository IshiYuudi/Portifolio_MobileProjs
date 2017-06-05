package androidstudio.yudi.jokenpov2;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.content.Context;
import android.graphics.BitmapFactory;

public class JokenpoNotification extends IntentService {
    public static final String EXTRA_MESSAGE = "jokenponotification";
    public static final int NOTIFICATION_ID = 1111;

    public JokenpoNotification() {

        super("JokenpoNotification");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        String text = intent.getStringExtra(EXTRA_MESSAGE);
        showText(text);
    }

    private void showText(String text) {
        Intent in = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(in);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);

        Notification nn = new Notification.Builder(this)
                .setDefaults(Notification.DEFAULT_VIBRATE | Notification.DEFAULT_LIGHTS)
                .setSmallIcon(R.mipmap.hand)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.hand))
                .setContentTitle("Jokenpo!")
                .setContentText(text)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .build();

        NotificationManager nManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nManager.notify(NOTIFICATION_ID, nn);

    }

}