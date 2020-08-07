package org.gwnu.tutorial.workmanager;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import java.util.concurrent.TimeUnit;

public class WorkManagerTutorial extends AppCompatActivity {
    private static final String TAG = WorkManagerTutorial.class.getSimpleName();

    OneTimeWorkRequest oUploadWorkRequest;
    PeriodicWorkRequest pUploadWorkRequest;

    /**********************************************************************************************/

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Constraints constraints = new Constraints.Builder()
                .setRequiresCharging(true)
                .build();

        Data data = new Data.Builder()
                .putString("Key", "key")
                .build();


        oUploadWorkRequest = new OneTimeWorkRequest.Builder(WorkerBundle.UploaderWorker.class)
                .setConstraints(constraints)
                .build();

        pUploadWorkRequest = new PeriodicWorkRequest.Builder(WorkerBundle.UploaderWorker.class, 1, TimeUnit.HOURS)
                .setConstraints(constraints)
                .setInputData(data)
                .build();

        WorkManager.getInstance(this).enqueue(oUploadWorkRequest);
        WorkManager.getInstance(this).enqueue(pUploadWorkRequest);


    }

    /**********************************************************************************************/

    @Override
    protected void onStart() {
        super.onStart();
    }

    /**********************************************************************************************/

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    /**********************************************************************************************/

}
