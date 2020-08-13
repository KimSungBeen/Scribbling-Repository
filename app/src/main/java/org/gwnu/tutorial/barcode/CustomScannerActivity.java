package org.gwnu.tutorial.barcode;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.journeyapps.barcodescanner.CaptureManager;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import com.journeyapps.barcodescanner.ViewfinderView;

import org.gwnu.tutorial.R;

import java.lang.reflect.Field;

public class CustomScannerActivity extends Activity implements DecoratedBarcodeView.TorchListener {

    private CaptureManager capture;
    private DecoratedBarcodeView barcodeScannerView;
    private BackPressCloseHandler backPressCloseHandler;
    private ImageButton setting_btn, switchFlashlightButton;
    private Boolean switchFlashlightButtonCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_scanner);

        switchFlashlightButtonCheck = true;

        backPressCloseHandler = new BackPressCloseHandler(this);

        setting_btn = (ImageButton) findViewById(R.id.setting_btn);
        switchFlashlightButton = (ImageButton) findViewById(R.id.switch_flashlight);

        if (!hasFlash()) {
            switchFlashlightButton.setVisibility(View.GONE);
        }

        barcodeScannerView = (DecoratedBarcodeView) findViewById(R.id.zxing_barcode_scanner);
        barcodeScannerView.setTorchListener(this);

        //뷰파인더 레이저 제거
        ViewfinderView viewfinderView = barcodeScannerView.getViewFinder();
        Field scannerAlphaField = null;
        try {
            scannerAlphaField = viewfinderView.getClass().getDeclaredField("SCANNER_ALPHA");
            scannerAlphaField.setAccessible(true);
            scannerAlphaField.set(viewfinderView, new int[1]);
        } catch (Exception e) {
            Log.e("eTag", "e : " + e.getMessage());
        }

        capture = new CaptureManager(this, barcodeScannerView);
        capture.initializeFromIntent(getIntent(), savedInstanceState);
        capture.decode();
    }

    @Override
    protected void onResume() {
        super.onResume();
        capture.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        capture.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        capture.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        capture.onSaveInstanceState(outState);
    }

    public void onBackPressed() {
        backPressCloseHandler.onBackPressed();
    }

    public void switchFlashlight(View view) {
        if (switchFlashlightButtonCheck) {
            barcodeScannerView.setTorchOn();
        } else {
            barcodeScannerView.setTorchOff();
        }
    }

    private boolean hasFlash() {
        return getApplicationContext().getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
    }

    @Override
    public void onTorchOn() {
        switchFlashlightButton.setImageResource(R.drawable.ic_baseline_flash_on_24);
        switchFlashlightButtonCheck = false;
    }

    @Override
    public void onTorchOff() {
        switchFlashlightButton.setImageResource(R.drawable.ic_baseline_flash_off_24);
        switchFlashlightButtonCheck = true;
    }

}
