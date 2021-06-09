package com.example.printonpax.printingstrategy;

import android.view.View;

public class NonAbstractPrinter {

    public static void  print(PrinterType type, View v, String header, String toPrint){
        PrinterInterface printerInterface;

        if (type.equals(PrinterType.POS)){
            printerInterface = new PrinterPOS();
        }else {
            printerInterface = new PrinterBT();
        }

        printerInterface.print(v, header, toPrint);
    }
}
