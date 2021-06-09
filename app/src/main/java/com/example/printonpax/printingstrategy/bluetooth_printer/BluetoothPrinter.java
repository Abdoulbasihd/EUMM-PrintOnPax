package com.example.printonpax.printingstrategy.bluetooth_printer;


import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.hoinprinterlib.HoinPrinter;
import com.example.hoinprinterlib.module.PrinterCallback;
import com.example.hoinprinterlib.module.PrinterEvent;
import com.example.printonpax.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.scottyab.aescrypt.AESCrypt;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class BluetoothPrinter implements PrinterCallback {

    private HoinPrinter myHoinPrinter;
    private Context context;
    Activity activity;
    private String dataToPrint;
    private String qrCodeData;
    private String titleToPrint;
    private static final String TAG = "BluetoothPrinter";

    BluetoothAdapter bluetoothAdapter;
    BluetoothDevice bluetoothDevice;
    AlertDialog.Builder builder;
    ArrayList<String> devicesName;
    HashMap<String, BluetoothDevice> mapDevices;

    BluetoothSocket socket;
    OutputStream outputStream;
    InputStream inputStream;
    Thread workerThread;
    byte[] readBuffer;
    int readBufferPosition;
    volatile boolean stopWorker;


    //KProgressHUD printerProgress;

    //private String salt = "20200803110655";

    public BluetoothPrinter( Context context, Activity activity, String titleToPrint, String dataToPrint) {
        Log.d(TAG, "constructor");
        this.dataToPrint = dataToPrint;
        this.titleToPrint = titleToPrint;
        this.context = context;
        this.activity = activity;
        this.myHoinPrinter = HoinPrinter.getInstance(context, BluetoothPrinterConstants.MODE, this);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(!bluetoothAdapter.isEnabled()) {
            Intent enableBluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            context.startActivity(enableBluetooth);
            Log.d(TAG, "Enabling BT first");
        }

        builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getResources().getString(R.string.select_a_BT_printer));
        builder.setIcon(R.drawable.ic_bluetooth_blue_500_24dp);

        devicesName = new ArrayList<>();
        mapDevices = new HashMap<>();

        /*printerProgress = KProgressHUD.create(context);
        printerProgress.setAnimationSpeed(1);
        printerProgress.setCornerRadius(0.5f);
        printerProgress.setDimAmount(0.3f);
        printerProgress.setStyle(KProgressHUD.Style.SPIN_INDETERMINATE);
        printerProgress.setLabel("Printing");
        printerProgress.setDetailsLabel("Waiting for device's connexion...");
        printerProgress.show();

        printerProgress.setDetailsLabel("Search device...");*/
        Set<BluetoothDevice> pairedDevices =  myHoinPrinter.getPairedDevice();
        for(BluetoothDevice device : pairedDevices) {
            Log.d(TAG, "found : "+device.getName());
            if (device.getName().contains("MP300")){
                myHoinPrinter.connect( device.getAddress());
                printTicket();
            }
        }

    }

    public BluetoothPrinter( Context context, Activity activity, String titleToPrint, String dataToPrint, String qrCodeData) {
        Log.d(TAG, "constructor");
        this.dataToPrint = dataToPrint;
        this.titleToPrint = titleToPrint;
        this.qrCodeData = qrCodeData;
        this.context = context;
        this.activity = activity;
        this.myHoinPrinter = HoinPrinter.getInstance(context, BluetoothPrinterConstants.MODE, this);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(!bluetoothAdapter.isEnabled()) {
            Intent enableBluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            context.startActivity(enableBluetooth);
            Log.d(TAG, "Enabling BT first");
        }

        builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getResources().getString(R.string.select_a_BT_printer));
        builder.setIcon(R.drawable.ic_bluetooth_blue_500_24dp);

        devicesName = new ArrayList<>();
        mapDevices = new HashMap<>();

        Set<BluetoothDevice> pairedDevices =  myHoinPrinter.getPairedDevice();
        for(BluetoothDevice device : pairedDevices) {
            Log.d(TAG, "found : "+device.getName());
            if (device.getName().contains("MP300")){
                myHoinPrinter.connect( device.getAddress());
                printTicket();
            }
        }

    }

    /**
     * state callback
     * @param state :: parameter is status code, refer to status code definition
     */
    @Override
    public void onState(int state) {
        Log.i(TAG, "onState: "+BluetoothPrinterConstants.statusToString(state));
        if (state == BluetoothPrinterConstants.BT_STATE_CONNECTED){
            //myHoinPrinter.stopBtDiscovery();
            Log.i(TAG, "onState connected : "+BluetoothPrinterConstants.statusToString(state));
            Toast.makeText(context, "Printer already Connected.... Printing now", Toast.LENGTH_SHORT).show();
            //Already connected ;;; Print Directly
            //printerProgress.setDetailsLabel("Printing");
            printTicket();

        }else if (state == BluetoothPrinterConstants.BT_STATE_DISCONNECTED) {
            // connect  Before : List all paired devices first. Then on select one, connect and print
            //printerProgress.setDetailsLabel("Search device...");
            Set<BluetoothDevice> pairedDevices =  myHoinPrinter.getPairedDevice();
            if(pairedDevices.isEmpty())
                Toast.makeText(context, "No Devices found", Toast.LENGTH_LONG).show();
            Log.d(TAG, "paired : " +pairedDevices.size());
            devicesName.clear();
            mapDevices.clear();
            for(BluetoothDevice device : pairedDevices) {
                Log.d(TAG, "found : "+device.getName());
                devicesName.add(device.getName());
                mapDevices.put(device.getName(), device);
            }
            //obtenir la liste des noms sous forme d'un tableau de chaine de caractère afin de use la singleChoiceItems
            String[] devices = new String[devicesName.size()];
            for (int i=0; i<devicesName.size(); i++)
                devices[i] = devicesName.get(i);

            builder.setSingleChoiceItems(devices, -1, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    Log.d(TAG, "selected : "+which+" size : "+devicesName.size());

                    //After selected a device, get the address of the selected One then connect to it
                    bluetoothDevice = mapDevices.get(devicesName.get(which));
                    if (bluetoothDevice!=null) {
                        Log.i(TAG, "onClick: Before connecting to :: "+bluetoothDevice.getAddress()+"==>"+bluetoothDevice.getName());
                        myHoinPrinter.connect(bluetoothDevice.getAddress());
                        Log.i(TAG, "onClick: After connect to :: "+bluetoothDevice.getAddress()+"==>"+bluetoothDevice.getName());
                        //Connected : Let's print
                        printTicket();

                    } else {
                        Log.i(TAG, "Select BT device ==> null ==>");
                    }


                }
            });
            //printerProgress.dismiss();
            AlertDialog dialog = builder.create();
            dialog.show();

        }

    }

    /**
     * Error callback,
     * @param errorCode :: parameter is error code, refer to error code definition
     */
    @Override
    public void onError(int errorCode) {
        Log.d(TAG, "onError: "+BluetoothPrinterConstants.errorCodeToString(errorCode));
    }

    /**
     * Event callback,
     * @param printerEvent :: parameter is PrinterEvent event, refer to PrinterEvent definition
     */
    @Override
    public void onEvent(PrinterEvent printerEvent) {
        Log.i(TAG, "onEvent == "+printerEvent.event);
        //Should we alert like ?? printingAlertDialog "Error while Printing", BluetoothPrinterConstants eventToString printerEvent event
        if (printerEvent.event == BluetoothPrinterConstants.EVENT_BT_RECEIVE_DATA || printerEvent.event == BluetoothPrinterConstants.EVENT_WIFI_RECEIVE_DATA){
            byte[] data = (byte[]) printerEvent.object;
            String strData = new String(data);
            Log.i(TAG, "<== onEvent, received Data ==> \n ".concat(strData));
        } else if (printerEvent.event == BluetoothPrinterConstants.EVENT_FIND_BT_DEVICE){
            //We found a BT Device, what to do ?
            Log.i(TAG, "onEvent ==> find BT Device");
        } else if (printerEvent.event == BluetoothPrinterConstants.EVENT_DISCOVERY_BT_FINISHED){
            //Discovery Finished
            Log.i(TAG, "onEvent ==> Discovery BT Finished");
          //  printerProgress.setDetailsLabel("BT Discovery Finished,\n waiting for device's connection");
            //new BluetoothPrinter( context, titleToPrint, dataToPrint);
            //printTicket();
            //myHoinPrinter.printQRCode("etrfgyguhjiyutryftyhghji");
           // myHoinPrinter.testCutting();

        }
    }

    public void printTicket(){
        //Checking read write permission first for > 23 : if accorded, print. else ask for permission
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(context, "Permission write external storage Not granted", Toast.LENGTH_SHORT).show();

                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
            }else {
                if (qrCodeData!=null){
                    printingTicketWithQR();
                }else {
                    printingTicket();
                }
            }
        }else {
            try {
                if (qrCodeData!=null){
                    printingTicketWithQR();
                }else {
                    printingTicket();
                }
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(context, "Verify Permission 'write external storage' before continue please", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void printingTicket(){
        if (myHoinPrinter!=null){
            //Let's create file from bitmap and save it in the memory first (logo to print)
            Bitmap bbicon = BitmapFactory.decodeResource(context.getResources(),R.drawable.logo_eu_for_ticket);
            File downloadRoot = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            final String filename = "logo_eu_for_ticket.PNG";

            File file = new File(downloadRoot, filename);
            OutputStream output = null;


            try {
                output = new FileOutputStream(file);
                bbicon.compress(Bitmap.CompressFormat.PNG, 10, output);
                output.flush();
                output.close();

                Log.i(TAG, "printTicket: begin");
                //myHoinPrinter.switchType(true);"drawable/logo.png"
                Log.i(TAG, "printTicket: selecting type");
                myHoinPrinter.setCenter(true);

                myHoinPrinter.printText("EXPRESS UNION FINANCE S.A.", false, false, true, true); // printing the company name in bold and centered
                myHoinPrinter.printText(titleToPrint, false, false, true, true); // printing the operation title in bold and centered
                myHoinPrinter.printText(dataToPrint, false, false, false, false); //printing the ticket body.... simple text
                myHoinPrinter.printImage(file.getPath(), true); // printing created image
                //myHoinPrinter.printText("--------------------------------", false, false, false, false); //printing cuttintest
                Log.i(TAG, "printTicket: after print text");

            } catch(Exception e) {
                e.printStackTrace();
                Toast.makeText(context, "Printing error ==> "+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void printingTicketWithQR(){
        if (myHoinPrinter!=null){
            //Let's create file from bitmap and save it in the memory first (logo to print)
            Bitmap bbIconLogoEu = BitmapFactory.decodeResource(context.getResources(),R.drawable.logo_eu_for_ticket);
            File downloadRoot = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            final String filenameLogo = "logo_eu_for_ticket.PNG";
            final String fileQr = "qrCodeEummDist.PNG";

            File file = new File(downloadRoot, filenameLogo);
            OutputStream output = null;

            File fileQrCode = new File(downloadRoot, fileQr);
            OutputStream outputQr = null;

            //For QR
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();

            try {
                //For LOGO
                output = new FileOutputStream(file);
                bbIconLogoEu.compress(Bitmap.CompressFormat.PNG, 100, output);
                output.flush();
                output.close();

                //For QR
                //String encryptedDataForQRCode = this.encrypt(qrCodeData, secretKey);
                //String encryptedDataForQRCode = "this.encrypt(qrCodeData, secretKey)";
                //Below is for encoding. We'll use AES algorithm
                String secretKey = "EUkeYcryjAbdBsDhfp-sla_";
                String encryptedDataForQRCode = AESCrypt.encrypt(secretKey, qrCodeData);
                Log.i(TAG, "printingTicketWithQR, encrypted Data : "+encryptedDataForQRCode);
                Log.i(TAG, "printingTicketWithQR, brut Data : "+qrCodeData);
                BitMatrix bitMatrix = multiFormatWriter.encode(encryptedDataForQRCode, BarcodeFormat.QR_CODE,450,450);
                BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                //Bitmap bitmapQrCode = barcodeEncoder.encodeBitmap(encryptedDataForQRCode, BarcodeFormat.QR_CODE, 1000, 1000);
                Bitmap bitmapQrCode = barcodeEncoder.createBitmap(bitMatrix);

                for (int i = 0; i < bitMatrix.getWidth(); i++) {//width
                    for (int j = 0; j < bitMatrix.getHeight(); j++) {//height
                        bitmapQrCode.setPixel(i, j, bitMatrix.get(i, j) ? Color.BLACK: Color.WHITE);
                    }
                }
                outputQr = new FileOutputStream(fileQrCode);
                bitmapQrCode.compress(Bitmap.CompressFormat.PNG, 100, outputQr);
                outputQr.flush();
                outputQr.close();


                Log.i(TAG, "printTicket: begin");
                //myHoinPrinter.switchType(true);"drawable/logo.png"
                Log.i(TAG, "printTicket: selecting type");
                myHoinPrinter.setCenter(true);

                myHoinPrinter.printImage(file.getPath(), false); // printing created image
                myHoinPrinter.printText("EXPRESS UNION FINANCE S.A.", false, false, true, true); // printing the company name in bold and centered
                myHoinPrinter.printText(titleToPrint, false, false, true, true); // printing the operation title in bold and centered
                myHoinPrinter.printText(dataToPrint, false, false, false, false); //printing the ticket body.... simple text
                myHoinPrinter.printImage(fileQrCode.getPath(), false);
                //myHoinPrinter.printText("--------------------------------", false, false, false, false); //printing cuttintest
                Log.i(TAG, "printTicket: after print text");
                //printerProgress.dismiss();
                //myHoinPrinter.destroy();

            } catch(Exception e) {
                e.printStackTrace();
                Toast.makeText(context, "Printing error ==> "+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

}
