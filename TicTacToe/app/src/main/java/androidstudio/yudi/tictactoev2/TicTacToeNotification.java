package androidstudio.yudi.tictactoev2;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.content.Context;
import android.graphics.BitmapFactory;

public class TicTacToeNotification extends IntentService {
    public static final String EXTRA_MESSAGE = "tictactoenotification";
    public static final int NOTIFICATION_ID = 2222;

    public TicTacToeNotification() {

        super("TicTacToeNotification");
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
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.tic_tac_toe_icon))
                .setContentTitle("Tic Tac Toe")
                .setContentText(text)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .build();

        NotificationManager nManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nManager.notify(NOTIFICATION_ID, nn);

    }

}