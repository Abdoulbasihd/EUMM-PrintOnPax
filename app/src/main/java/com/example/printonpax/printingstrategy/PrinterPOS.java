package com.example.printonpax.printingstrategy;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.Toast;

import com.example.printonpax.R;
import com.example.printonpax.utils.Utils;
import com.pax.dal.IDAL;
import com.pax.dal.IPrinter;
import com.pax.dal.exceptions.PrinterDevException;
import com.pax.neptunelite.api.NeptuneLiteUser;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PrinterPOS implements PrinterInterface {

    private static Bitmap logo_eu;

    @Override
    public void print(View v, String header, String toPrint) {

        NeptuneLiteUser neptuneLiteUser;
        IDAL idal;
        IPrinter printer;
        neptuneLiteUser = NeptuneLiteUser.getInstance();

        logo_eu = BitmapFactory.decodeResource(v.getResources(), R.drawable.logo_eu_for_ticket);

        String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        String hour = new SimpleDateFormat("HH-mm-ss").format(Calendar.getInstance().getTime());



        try {
            idal = neptuneLiteUser.getDal(v.getContext());
            printer = idal.getPrinter();

            printer.init();

            printer.printStr("EXPRESS UNION FINANCE S.A.\n", null); // printing the company name in bold and centered
            printer.printStr(header+"\n", null);

            //printer.printBitmap(logo_eu);
            printer.printStr(date + "         " +hour + "\n", null);


            printer.printStr(toPrint, null);
            printer.printBitmap(logo_eu);
            printer.printStr("\n ", null);
            printer.printStr("--------------------------------\n", null);

            int print_state = printer.start();
/*
            if (print_state == 0){
                Toast.makeText(v.getContext(), v.getResources().getString(R.string.successfully_printed), Toast.LENGTH_SHORT).show();
            }else if (print_state == 1){
                Utils.showDialog(v.getContext(),"",v.getResources().getString(R.string.printer_busy_please_reprint_later));

            }else if (print_state == 2){
                Utils.showDialog(v.getContext(),"", v.getResources().getString(R.string.no_print_paper_please_try_again_later));

            }else if (print_state == 3){
                Utils.showDialog(v.getContext(),"", v.getResources().getString(R.string.print_data_format_error));

            }else if (print_state == 4){
                Utils.showDialog(v.getContext(), "", v.getResources().getString(R.string.printer_malfunction_please_try_again_after_checking) );

            }else if (print_state == 8){
                Utils.showDialog(v.getContext(), "", v.getResources().getString(R.string.printer_overheating_please_try_again_later) );

            }else if (print_state == 9){
                Utils.showDialog(v.getContext(), "", v.getResources().getString(R.string.very_low_printer_supply_voltage));

            }else if (print_state == -16){
                Utils.showDialog(v.getContext(), "", v.getResources().getString(R.string.printing_not_completed));

            }else if (print_state == -4){
                Utils.showDialog(v.getContext(), "", v.getResources().getString(R.string.the_printer_does_not_have_the_library_for_the_font));

            }else if (print_state == -2){
                Utils.showDialog(v.getContext(), "", v.getResources().getString(R.string.very_large_data_size));

            }else {
                Utils.showDialog(v.getContext(), "",v.getResources().getString(R.string.an_unknown_error_occurred_while_printing));
            }
*/

        } catch (PrinterDevException e) {
            e.printStackTrace();
            Toast.makeText(v.getContext(), "An error occurred while printing : " +
                    e.getMessage(), Toast.LENGTH_SHORT).show();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}
