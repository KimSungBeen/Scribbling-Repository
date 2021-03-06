package org.gwnu.tutorial.workmanager;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class WorkerBundle {


    /**
     * Uploader Worker
     * */
    public static class UploaderWorker extends Worker {

        public UploaderWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
            super(context, workerParams);
        }

        @NonNull
        @Override
        public Result doWork() {
            //        uploadImage();

            Data data = getInputData();

            String key = data.getString("key");

            return Result.success();
        }
    }

    /**
     * Loading Worker
     * */
    public static class LoadingWorker extends Worker {

        public LoadingWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
            super(context, workerParams);
        }

        @NonNull
        @Override
        public Result doWork() {
            return null;
        }
    }

}
