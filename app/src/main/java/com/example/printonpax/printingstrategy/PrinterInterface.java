package com.example.printonpax.printingstrategy;

import android.view.View;

public interface PrinterInterface {

    void print(View v, String header, String toPrint);

}
