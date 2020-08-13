package org.gwnu.tutorial.barcode;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.journeyapps.barcodescanner.CaptureManager;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import com.journeyapps.barcodescanner.ViewfinderView;

import org.gwnu.tutorial.R;

import java.lang.reflect.Field;

public class CustomScannerActivity extends Activity implements DecoratedBarcodeView.TorchListener {
    private static final String TAG = CustomScannerActivity.class.getSimpleName();
    public static final int PERMISSION_REQUEST_CODE = 100;

    private CaptureManager capture;
    private DecoratedBarcodeView barcodeScannerView;
    private BackPressCloseHandler backPressCloseHandler;
    private ImageButton switchFlashlightButton;
    private Boolean switchFlashlightButtonCheck;

    /**********************************************************************************************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_scanner);

        //사용자의 카메라 권한 체크 후 요청
        //콜백 메소드: onRequestPermissionsResult
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED) {
            //카메라권한이 허용되어 있음.

        } else {
            //카메라권한이 거절되어 있음.
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.CAMERA
            }, PERMISSION_REQUEST_CODE);
        }

        init(); //초기화 메소드

        //디바이스에 플래쉬 기능이 없다면 플래쉬버튼 비활성화
        if (!hasFlash()) {
            switchFlashlightButton.setVisibility(View.GONE);
        }

        //뷰파인더 레이저 제거
        ViewfinderView viewfinderView = barcodeScannerView.getViewFinder();
        Field scannerAlphaField = null;
        try {
            scannerAlphaField = viewfinderView.getClass().getDeclaredField("SCANNER_ALPHA");
            scannerAlphaField.setAccessible(true);
            scannerAlphaField.set(viewfinderView, new int[1]);
        } catch (Exception e) {
            Log.e(TAG, "e : " + e.getMessage());
        }

        //화면에 QR 스캔 카메라 적용
        capture = new CaptureManager(this, barcodeScannerView);
        capture.initializeFromIntent(getIntent(), savedInstanceState);
        capture.decode();
    }

    /**********************************************************************************************/

    @Override
    protected void onResume() {
        super.onResume();
        capture.onResume();

    }

    /**********************************************************************************************/

    @Override
    protected void onPause() {
        super.onPause();
        capture.onPause();
    }

    /**********************************************************************************************/

    @Override
    protected void onDestroy() {
        super.onDestroy();
        capture.onDestroy();
    }

    /**********************************************************************************************/

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        capture.onSaveInstanceState(outState);
    }

    /**********************************************************************************************/

    public void onBackPressed() {
        backPressCloseHandler.onBackPressed();
    }

    /**********************************************************************************************/

    public void switchFlashlight(View view) {
        if (switchFlashlightButtonCheck) {
            barcodeScannerView.setTorchOn();
        } else {
            barcodeScannerView.setTorchOff();
        }
    }

    /**********************************************************************************************/

    private boolean hasFlash() {
        return getApplicationContext().getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
    }

    /**********************************************************************************************/

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

    /**********************************************************************************************/

    //사용자가 권한요청 dialog 에 반응시 콜백
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if ((requestCode == PERMISSION_REQUEST_CODE) && permissions[0].equals(Manifest.permission.CAMERA)) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //권한 허용시

            } else {
                //권한 거부시
                Toast.makeText(this, "[설정] > [권한]에서 해당권한을 활성화 할 수 있습니다.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**********************************************************************************************/

    private void init() {
        switchFlashlightButtonCheck = true;

        switchFlashlightButton = findViewById(R.id.switch_flashlight);
        barcodeScannerView = findViewById(R.id.zxing_barcode_scanner);
        barcodeScannerView.setTorchListener(this);

        //Back 버튼 두번 클릭시 모든 Activity 종료
        backPressCloseHandler = new BackPressCloseHandler(this);
    }

    /**********************************************************************************************/

}
