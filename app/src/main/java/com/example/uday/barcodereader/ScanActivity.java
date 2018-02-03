package com.example.uday.barcodereader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.barcode.Barcode;

import java.util.List;

import es.dmoral.toasty.Toasty;
import info.androidhive.barcode.BarcodeReader;

/**
 * Created by uday on 13/1/18.
 */

public class ScanActivity extends AppCompatActivity implements BarcodeReader.BarcodeReaderListener{
    BarcodeReader barcodeReader;
    int RESULT = 100;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        barcodeReader = (BarcodeReader) getSupportFragmentManager().findFragmentById(R.id.barcode_scanner);

    }

    @Override
    public void onScanned(Barcode barcode) {
        barcodeReader.playBeep();

        Intent intent  = new Intent();
        intent.putExtra("scan_data",barcode.rawValue);
        setResult(RESULT,intent);
        finish();


    }

    @Override
    public void onScannedMultiple(List<Barcode> barcodes) {

    }

    @Override
    public void onBitmapScanned(SparseArray<Barcode> sparseArray) {

    }

    @Override
    public void onScanError(String errorMessage) {

    }

    @Override
    public void onCameraPermissionDenied() {

    }
}
