package com.example.printonpax.printingstrategy.bluetooth_printer;

public class BluetoothPrinterConstants {

    public static final int MODE = 1; // O for BT, 1 for WIFI and 2 for USB. We're using BT here


    //Status code definition:
    public static final int BT_STATE_DISCONNECTED = 0; //Bluetooth disconnected
    public static final int BT_STATE_LISTEN = 1; //Bluetooth is listening
    public static final int BT_STATE_CONNECTING = 2; //Bluetooth connecting
    public static final int BT_STATE_CONNECTED = 3; //Bluetooth connected
    public static final int WIFI_STATE_CONNECTED = 4; //wifi connected
    public static final int WIFI_STATE_DISCONNECTED = 5; //wifi disconnected
    public static final int USB_STATE_CONNECTED = 6; //usb connected
    public static final int USB_STATE_DISCONNECTED = 7; //usb disconnected

    //Error code definition
    public static final int BT_NOT_AVAILABLE = 1000; //Bluetooth is not available on this device
    public static final int BT_UNABLE_CONNECT_TO_DEVICE = 1001; //Unable to connect to Bluetooth
    public static final int BT_CONNECTION_LOST = 1002; //Unable to connect Bluetooth or Bluetooth disconnect
    public static final int CONTEXT_ERROR = 1003; //Context error
    public static final int WIFI_SEND_FAILED = 1004; //WIFI failed to send data
    public static final int WIFI_CONNECT_ERROR = 1005; //WIFI connection failed
    public static final int USB_NOT_FIND_DEVICE = 1006; //USB connection failed
    public static final int USB_NO_PERMISSION = 1007; //USB does not have permission
    public static final int BT_NO_PERMISSION = 1008; //Bluetooth has no permissions
    public static final int DEVICE_NOT_CONNECTED = 1009; //Device not connected
    public static final int IMAGE_NOT_FOUND = 1010; //Device not connected
    public static final int NULL_POINTER_EXCEPTION = 9999; // null pointer exception

    //Event type definition
    //Bluetooth searches device events, object is BluetoothDevice type, is the Bluetooth searched device
    public static final int EVENT_FIND_BT_DEVICE = 1;
    //Bluetooth search completed event
    public static final int EVENT_DISCOVERY_BT_FINISHED = 2;
    //Bluetooth receives a data event, object is a byte[] array type, which is the received data.
    public static final int EVENT_BT_RECEIVE_DATA = 3;
    //WIFI receives a data event, object is a byte[] array type, which is the received data.
    public static final int EVENT_WIFI_RECEIVE_DATA = 4;

    /**
     * Transform an int to a comprehensive error message, occured while Printing
     * @param errorCode : Error code, int
     * @return
     */
    public static  String errorCodeToString(int errorCode){
        switch (errorCode){
            case BT_NOT_AVAILABLE:
                return "Bluetooth : device not available";
            case BT_UNABLE_CONNECT_TO_DEVICE:
                return "Bluetooth : unable to connect to device";
            case  BT_CONNECTION_LOST:
                return "Bluetooth : connection lost";
            case CONTEXT_ERROR:
                return "Printer : Context Error";
            case WIFI_SEND_FAILED:
                return "Printer : WI-FI send failed";
            case WIFI_CONNECT_ERROR:
                return "Printer : WI-FI connection error";
            case  USB_NOT_FIND_DEVICE:
                return "Printer : USB connection failed";
            case USB_NO_PERMISSION:
                return "Printer : No Permission to use USB";
            case BT_NO_PERMISSION:
                return "Printer : No permission to use Bluetooth";
            case DEVICE_NOT_CONNECTED:
                return "Printer : Device Not Connected";
            case IMAGE_NOT_FOUND:
                return "Printing : Image Not Found";
            case NULL_POINTER_EXCEPTION:
                return "Printing : Null Pointer Exception occurred \n :-( \n Sorry \n :-(";

            default:
                return "Unknown error, code ==>"+errorCode;
        }
    }

    public static String statusToString(int statusCode){
        switch (statusCode){
            case BT_STATE_DISCONNECTED:
                return "Bluetooth Printer : BT device is disconnected";
            case BT_STATE_LISTEN:
                return "Bluetooth Printer : BT listening...";
            case  BT_STATE_CONNECTING:
                return "Bluetooth Printer : BT connecting ...";
            case BT_STATE_CONNECTED:
                return "Bluetooth Printer : BT Connected :-)";
            case WIFI_STATE_CONNECTED:
                return "Printer : WI-FI connected :-)";
            case WIFI_STATE_DISCONNECTED:
                return "Printer : WI-FI is disconnected :-(";
            case  USB_STATE_CONNECTED:
                return "Printer : USB is connected";
            case USB_STATE_DISCONNECTED:
                return "Printer : USB is disconnected";
            default:
                return "Unknown state :: code ==>"+statusCode;
        }
    }

    public static String eventToString(int event){
        switch (event){
            case EVENT_FIND_BT_DEVICE:
                return "Bluetooth : Device Found";
            case EVENT_DISCOVERY_BT_FINISHED:
                return "Bluetooth search completed event";
            case  EVENT_BT_RECEIVE_DATA:
                return "Printer : receiving data By Bluetooth";
            case EVENT_WIFI_RECEIVE_DATA:
                return "Printer : Receiving Data By Wi-Fi";
            default:
                return "Unknown event :: code ==>"+event;
        }
    }

}
