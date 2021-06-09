package com.example.printonpax;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.printonpax.utils.Utils;

public class MainActivity extends AppCompatActivity {

    private TextView transactionDate;
    private TextView transactionHeur;
    private TextView devise;
    private TextView transactionNumber;
    private TextView cardNumber;
    private TextView accountNumber;
    private TextView amountCredited;
    private TextView fees;
    private TextView totalAmount;
    private TextView agentName;
    private TextView reference;
    private RelativeLayout accountNumberLayout;
    private RelativeLayout cardNumberLayout;
    private TextView pageTitle;
    private TextView pageSubtitle;

    private static final String TAG = "frBordDepotSimOuAmpl";

    Button terminer;
    Button print;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pageTitle = findViewById(R.id.page_title);
       // pageTitle.setText("DEPOT COMPTE");
        pageSubtitle = findViewById(R.id.page_sub_title);
       // pageSubtitle.setText("SIMPLY");
        transactionDate = findViewById(R.id.dateFacture);
        transactionDate.setText("09/06/2021");
        transactionHeur = findViewById(R.id.heureFacture);
        transactionHeur.setText("12:00:00");
        transactionNumber = findViewById(R.id.transactionNumber);
        transactionNumber.setText("SMP31891394");
        reference = findViewById(R.id.reference);
        reference.setText("AGRSIMPLY783287910IDBNUI18");
        devise = findViewById(R.id.devise);
        devise.setText("XAF");

        cardNumber = findViewById(R.id.carteNumber);
        accountNumber = findViewById(R.id.accountNumber);
        accountNumber.setText("1120 1040 0000 0058");
        amountCredited = findViewById(R.id.amountCredited);
        amountCredited.setText("950");
        fees = findViewById(R.id.fees);
        fees.setText("50");
        totalAmount = findViewById(R.id.totalAmount);
        totalAmount.setText("1000");

        accountNumberLayout = findViewById(R.id.accountNumberLayout);
        cardNumberLayout = findViewById(R.id.cardNumberLayout);


        agentName = findViewById(R.id.agentName);
        agentName.setText("Ahmadou Bamanga");

        TextView agentCountry = findViewById(R.id.pays_agent);
        agentCountry.setText("Cameroon");

        terminer = findViewById( R.id.btn_terminer );
        terminer.setOnClickListener( v->{
            Toast.makeText(this, ":-)", Toast.LENGTH_SHORT).show();
        } );

        print = findViewById( R.id.print );
        print.setOnClickListener(v -> {

            Toast.makeText(this, "printing", Toast.LENGTH_SHORT).show();
            String title = "Depot Carte SIMPLY";
            String receiptSimplyDeposit = "";
            receiptSimplyDeposit = receiptSimplyDeposit+"Date : "+transactionDate.getText().toString()+"\n";
            receiptSimplyDeposit = receiptSimplyDeposit+"Heure : "+transactionHeur.getText().toString()+"\n";
            receiptSimplyDeposit = receiptSimplyDeposit+"Num Ref. : "+reference.getText().toString().trim()+"\n";
            receiptSimplyDeposit = receiptSimplyDeposit+"Num Trans. : "+transactionNumber.getText().toString().trim()+"\n";

                receiptSimplyDeposit = receiptSimplyDeposit+"Num Carte: "+cardNumber.getText().toString()+"\n";

            receiptSimplyDeposit = receiptSimplyDeposit+"Devise : "+devise.getText().toString()+"\n";

                receiptSimplyDeposit = receiptSimplyDeposit+"Montant credite : "+amountCredited.getText().toString()+"\n";
                receiptSimplyDeposit = receiptSimplyDeposit+"Frais : "+fees.getText().toString()+"\n";
                receiptSimplyDeposit = receiptSimplyDeposit+"Montant percu : "+totalAmount.getText().toString() +"\n";

            receiptSimplyDeposit = receiptSimplyDeposit+"Agent : "+agentName.getText().toString().trim() +"\n";
            receiptSimplyDeposit = receiptSimplyDeposit+"Signature Agent  Signature client\n";



            // block code for selecting suitable printer was moved to utils as a static method
            Utils.selectPrinterAndPrint(MainActivity.this, MainActivity.this, agentName.getRootView(), title, receiptSimplyDeposit);

        });

    }
}