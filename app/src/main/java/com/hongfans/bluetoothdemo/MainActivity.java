package com.hongfans.bluetoothdemo;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * https://mp.weixin.qq.com/s?__biz=MzIwMzYwMTk1NA==&mid=2247486605&idx=1&sn=ac80b25046438a5dce28193c4810c04b&chksm=96cdadc0a1ba24d6955a9e8160582c004e2d99a6963ac20316e8acfd2ef8f01c87f56caebe43&mpshare=1&scene=23&srcid=0824uCliE0QmsDJ39wYr1aCx#rd
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private BluetoothAdapter mAdapter;

    private BluetoothGattCallback mGattCallback = new BluetoothGattCallback() {
        @Override
        public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
            super.onConnectionStateChange(gatt, status, newState);
            switch (status) {

            }
        }
    };

    private BluetoothAdapter.LeScanCallback mLeScanCallback = new BluetoothAdapter.LeScanCallback() {
        @Override
        public void onLeScan(BluetoothDevice device, int rssi, byte[] scanRecord) {
            mBluetoothGatt = device.connectGatt(MainActivity.this, true, mGattCallback);
        }
    };

    private BluetoothGatt mBluetoothGatt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BluetoothManager manager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        mAdapter = manager.getAdapter();

        findViewById(R.id.btn_1).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:

                mAdapter.startLeScan(mLeScanCallback);
                break;
        }
    }

}
