package com.example.printonpax.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.fragment.app.Fragment;

import com.example.printonpax.R;
import com.example.printonpax.notifyer.ByAgResponse;
import com.example.printonpax.notifyer.DefaultPrintingDataSet;
import com.example.printonpax.printingstrategy.NonAbstractPrinter;
import com.example.printonpax.printingstrategy.PrinterType;
import com.example.printonpax.printingstrategy.bluetooth_printer.BluetoothPrinter;

import java.util.Locale;

public class Utils {

    public static final int DEPOSIT_TITLE_N = 1;
    public static final int WITHDRAWAL_TITLE_N = 2;
    public static final String RECEIPT = "bordereau";
    public static final String EUMM_DEPOSIT = "Depot EUMM";
    public static final String MESSAGE = "message";
    public static final String SUCCESS = "SUCCESS";
    public static final String STATUS = "status";
    public static final String COLOR_APPROX_MATTERHORN_OR_RGB_75 = "#4B4A4A";
    public static final String COLOR_APPROX_BLUE = "#213783";
    public static final String COLOR_BLACK = "#000000";
    public static final String COLOR_APPROX_CRIMSON_EUI_SEND = "#C90044";


    private static final String PREFERENCES_FILE = "materialsample_settings";

    public static final String UPDATE_BALANCE = "mettre_solde_a_jour";

    private static final String[] motifsSendMoney = {"( Motif du transfert)","Approvisionnement compte",
            "Envoi / Reception de fonds","Dons fournis / Reçus",
            "Envoi des fonds des travailleurs","Frais de mission",
            "Frais de scolarité",
            "Frais de voyages médicaux",
            "Frais de voyages touristiques",
            "Autres..."};
    private static final int[] figImMotifs = {R.drawable.ic_back_left_0,R.drawable.ic_back_left_0,
            R.drawable.ic_back_left_0,R.drawable.ic_back_left_0,
            R.drawable.ic_back_left_0,R.drawable.ic_back_left_0,
            R.drawable.ic_back_left_0,R.drawable.ic_back_left_0,
            R.drawable.ic_back_left_0,R.drawable.ic_back_left_0};

    private static final String[] piece = {"( Type de pièce )", "Carte nationale d'identité","Passeport","Carte du consulat","Preuve d'identité","Carte d'électeur","Carte d'assurance"};
    private static final int[] figurant3 = {R.drawable.ic_back_left_0,R.drawable.ic_back_left_0,
            R.drawable.ic_back_left_0,R.drawable.ic_back_left_0,R.drawable.ic_back_left_0,
            R.drawable.ic_back_left_0};

    private static final String[] countries = {
            "COTE D'IVOIRE",
            "SENEGAL",
            "GUINEE BISSAU",
            "BURKINA",
            "Mali",
            "TOGO",
            "GUINEE CONAKRY",
            "BENIN",
            "BURUNDI",
            "NIGER",
            "CAP-VERT",
            "CAMEROUN",
            "KENYA",
            "UGANDA",
            "TANZANIE",
            "COMORES",
            "NIGERIA",
            "GHANA",
            "MONZAMBIQUE",
            "SIERRA LEONE",
            "LIBERIA",
            "MAURITANIE",
            "DR CONGO",
            "ETHI0PIA",
            "GABON",
            "LESOTHO",
            "MADAGASCAR",
            "MALAWI",
            "RWANDA",
            "SOUTH AFRICA",
            "SWAZILAND",
            "ZAMBIA",
            "ZIMBABWE"
    };

    private static  final String[] centralAfricaCountriesCodeISO2 = {"CM", "CF", "CG", "CD",
            "GA", "GQ", "TD"};

    private static  final  String[] centralAfricaCountriesAndSn = {"Cameroun","Sénégal","RCA", "Congo", "RDC",
            "Gabon", "Guinée équa.", "Tchad"};

    private static final String[] worldTimeZones = { "Europe/Dublin","Europe/Paris","Europe/Athens", "Asia/Calcutta",
            "Japan","Australia/Perth","US/Pacific", "US/Eastern" };

    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_FORMAT_WITHOUT_DASH = "yyyyMMdd";

    private static final String[] monthList = {"( Selectionnez un mois )", "Janvier", "Fevrier", "Mars", "Avril", "Mai", "Juin"
            , "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Decembre"};

    private static final int[] monthFigs = {R.drawable.ic_back_left_0, R.drawable.ic_back_left_0,
            R.drawable.ic_back_left_0, R.drawable.ic_back_left_0,
            R.drawable.ic_back_left_0, R.drawable.ic_back_left_0,
            R.drawable.ic_back_left_0, R.drawable.ic_back_left_0,
            R.drawable.ic_back_left_0, R.drawable.ic_back_left_0,
            R.drawable.ic_back_left_0, R.drawable.ic_back_left_0
            , R.drawable.ic_back_left_0};


    public static String getRealPathFromURI(Context context, Uri contentUri) {
        Cursor cursor = null;
        try {
            String[] proj = {MediaStore.Images.Media.DATA};
            cursor = context.getContentResolver().query( contentUri, proj, null, null, null );


            int columnIndex = cursor.getColumnIndexOrThrow( MediaStore.Images.Media.DATA );
            cursor.moveToFirst();
            return cursor.getString( columnIndex );

        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }



    public static int getToolbarHeight(Context context) {
        return (int) context.getResources().getDimension( R.dimen.abc_action_bar_default_height_material );
    }



    public static Drawable tintMyDrawable(Drawable drawable, int color) {
        drawable = DrawableCompat.wrap( drawable );
        DrawableCompat.setTint( drawable, color );
        DrawableCompat.setTintMode( drawable, PorterDuff.Mode.SRC_IN );
        return drawable;
    }


    public static String readSharedSetting(Context ctx, String settingName, String defaultValue) {
        SharedPreferences sharedPref = ctx.getSharedPreferences( PREFERENCES_FILE, Context.MODE_PRIVATE );
        return sharedPref.getString( settingName, defaultValue );
    }

    public static void saveSharedSetting(Context ctx, String settingName, String settingValue) {
        SharedPreferences sharedPref = ctx.getSharedPreferences( PREFERENCES_FILE, Context.MODE_PRIVATE );
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString( settingName, settingValue );
        editor.apply();
    }

    public static String getSelectedIdType(int position){
        String pieceSelected;
        switch (position) {
            case 1:
                pieceSelected = "CI";
                break;
            case 2:
                pieceSelected = "PP";
                break;
            case 3:
                pieceSelected = "CC";
                break;
            case 4:
                pieceSelected = "AI";
                break;
            case 5:
                pieceSelected = "CE";
                break;
            case 6:
                pieceSelected = "CA";
                break;
            default:
                pieceSelected = "";
                break;
        }
        return  pieceSelected;
    }

    public static ViewPropertyAnimatorCompat  getViewPropertyAnimatorCompat(View v){
        return ViewCompat.animate(v).setDuration(200).scaleX(0.9f).scaleX(0.9f).setInterpolator( new CycleInterpolator() );
    }

    /**
     *
     * @param position : position of ze selected element, based on Utils.countries tab order
     * @return Country object in witch codeISO2 and phone prefix are set.
     */
    public static Country getSelectedCountryInfo(int position){
        Country country = new Country();
        String codepays="N-A";
        String codeISOpays = "N-A";
        switch (position) {
            case 0:
                codepays = "00225";
                codeISOpays = "CI";
                break;
            case 1:
                codepays = "00221";
                codeISOpays = "SN";
                break;
            case 2:
                codepays = "00245";
                codeISOpays = "GW";
                break;
            case 3:
                codepays = "00226";
                codeISOpays = "BF";
                break;
            case 4:
                codepays = "00223";
                codeISOpays = "ML";
                break;
            case 5:
                codepays = "00228";
                codeISOpays = "TG";
                break;
            case 6:
                codepays = "00224";
                codeISOpays = "GN";
                break;
            case 7:
                codepays = "00229";
                codeISOpays = "BJ";
                break;
            case 8:
                codepays = "00257";
                codeISOpays = "BI";
                break;
            case 9:
                codepays = "00227";
                codeISOpays = "NE";
                break;
            case 10:
                codepays = "00238";
                codeISOpays = "CV";
                break;
            case 11:
                codepays = "00237";
                codeISOpays = "CM";
                break;
            case 12:
                codepays = "00254";
                codeISOpays = "KE";
                break;
            case 13:
            case 14:
                codepays = "00256";
                codeISOpays = "UG";
                break;
            case 15:
                codepays = "00269";
                codeISOpays = "KM";
                break;
            case 16:
                codepays = "00234";
                codeISOpays = "NG";
                break;
            case 17:
                codepays = "00233";
                codeISOpays = "GH";
                break;
            case 18:
                codepays = "00258";
                codeISOpays = "MZ";
                break;
            case 19:
                codepays = "00232";
                codeISOpays = "SL";
                break;
            case 20:
                codepays = "00232";
                codeISOpays = "LR";
                break;
            case 21:
                codepays = "00222";
                codeISOpays = "MR";
                break;
            case 22:
                codepays = "00243";
                codeISOpays = "CD";
                break;
            case 23:
                codepays = "00251";
                codeISOpays = "ET";
                break;
            case 24:
                codepays = "00241";
                codeISOpays = "GA";
                break;
            case 25:
                codepays = "00266";
                codeISOpays = "LS";
                break;
            case 26:
                codepays = "00261";
                codeISOpays = "MG";
                break;
            case 27:
                codepays = "00265";
                codeISOpays = "MW";
                break;
            case 28:
                codepays = "00250";
                codeISOpays = "RW";
                break;
            case 29:
                codepays = "0927";
                codeISOpays = "ZA";
                break;
            case 30:
                codepays = "00268";
                codeISOpays = "SZ";
                break;
            case 31:
                codepays = "00260";
                codeISOpays = "ZM";
                break;
            case 32:
                codepays = "00263";
                codeISOpays = "ZW";
                break;
            default:
                break;
        }
        country.setCodeISO2(codeISOpays);
        country.setPhonePrefixCode(codepays);

        return  country;
    }

    public static String[] getPiece(){
        return piece;
    }

    public static int[] getFigurant3(){
        return figurant3;
    }

    public static String[] getCountries(){
        return countries;
    }


    public static String[] getCentralAfricaCountries(){
        return  centralAfricaCountriesAndSn;
    }

    public static String[] getWorldTimeZones(){
        return worldTimeZones;
    }

    public static String[] getMotifsSendMoney(){
        return  motifsSendMoney;
    }

    public static String getSelectedMotif(int position){
        if (position==0)
            return "approvisionnement compte";
        else
            return Utils.getMotifsSendMoney()[position];

    }

    public static int[] getFigImMotifs(){
        return figImMotifs;
    }

    public static int[] getMonthFigs(){
        return monthFigs;
    }

    public static String[] getMonthList(){
        return monthList;
    }
    public static boolean isValidSecretCode(String code){
        return code.matches("[0-9]{4}");
    }



    public static boolean isBackgroundExecuting(Fragment context, boolean setToBack){
        return ((!context.isVisible() && context.getUserVisibleHint()) || setToBack);
    }


    public static void selectPrinterAndPrint(Context context, Activity activity, View view, String title, String toPrint){
        if (!Build.MODEL.contains("A920")){
            new BluetoothPrinter(context, activity, title, toPrint);
        }else {
            NonAbstractPrinter.print(PrinterType.POS, view, title, toPrint);
        }
    }


}
