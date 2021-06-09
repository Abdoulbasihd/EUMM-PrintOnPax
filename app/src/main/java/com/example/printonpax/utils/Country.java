package com.example.printonpax.utils;

import java.io.Serializable;
import java.util.ArrayList;

public class Country implements Serializable
{
    private String name, nameFR, codeISO2, codeISO3, phonePrefixCode;
    private ArrayList<String> currencyCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameFR() {
        return nameFR;
    }

    public void setNameFR(String nameFR) {
        this.nameFR = nameFR;
    }

    public String getCodeISO2() {
        return codeISO2;
    }

    public void setCodeISO2(String codeISO2) {
        this.codeISO2 = codeISO2;
    }

    public String getCodeISO3() {
        return codeISO3;
    }

    public void setCodeISO3(String codeISO3) {
        this.codeISO3 = codeISO3;
    }

    public String getPhonePrefixCode() {
        return phonePrefixCode;
    }

    public void setPhonePrefixCode(String phonePrefixCode) {
        this.phonePrefixCode = phonePrefixCode;
    }

    public ArrayList<String> getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(ArrayList<String> currencyCode) {
        this.currencyCode = currencyCode;
    }

    public static ArrayList<Country> getAllCountries()
    {
        ArrayList<Country> countries = new ArrayList<>();
        ArrayList<String> currency = new ArrayList<>();
        currency.add("XAF");

        //0 ----------------------------------------------------
        Country country = new Country();
        country.setName("Cameroon");
        country.setNameFR("Cameroun");
        country.setPhonePrefixCode("237");
        country.setCodeISO2("CM");
        country.setCodeISO3("CMR");
        country.setCurrencyCode(currency);
        countries.add(country);

        //1 ----------------------------------------------------
        country = new Country();
        country.setName("Chad");
        country.setNameFR("Tchad");
        country.setPhonePrefixCode("235");
        country.setCodeISO2("TD");
        country.setCodeISO3("TCD");
        country.setCurrencyCode(currency);
        countries.add(country);

        //2 ----------------------------------------------------
        country = new Country();
        country.setName("RCA");
        country.setNameFR("RCA");
        country.setPhonePrefixCode("236");
        country.setCodeISO2("CF");
        country.setCodeISO3("CAF");
        country.setCurrencyCode(currency);
        countries.add(country);

        //3 ----------------------------------------------------
        country = new Country();
        country.setName("Gabon");
        country.setNameFR("Gabon");
        country.setPhonePrefixCode("241");
        country.setCodeISO2("GA");
        country.setCodeISO3("GAB");
        country.setCurrencyCode(currency);
        countries.add(country);



        //4 ----------------------------------------------------
        country = new Country();
        country.setName("Equatorial Guinea");
        country.setNameFR("Guinée équatorial");
        country.setPhonePrefixCode("240");
        country.setCodeISO2("GQ");
        country.setCodeISO3("GNQ");
        country.setCurrencyCode(currency);
        countries.add(country);

        //5 ----------------------------------------------------
        country = new Country();
        country.setName("Congo");
        country.setNameFR("Congo");
        country.setPhonePrefixCode("242");
        country.setCodeISO2("CG");
        country.setCodeISO3("COG");
        country.setCurrencyCode(currency);
        countries.add(country);

        //6 ----------------------------------------------------
        currency = new ArrayList<>();
        currency.add("XAF");
        currency.add("USD");
        currency.add("CDF");
        country = new Country();
        country.setName("RDC");
        country.setNameFR("RDC");
        country.setPhonePrefixCode("243");
        country.setCodeISO2("CD");
        country.setCodeISO3("COD");
        country.setCurrencyCode(currency);
        countries.add(country);

        //7 ----------------------------------------------------
        currency = new ArrayList<>();
        currency.add("XAF");
        country = new Country();
        country.setName("Senegal");
        country.setNameFR("Sénégal");
        country.setPhonePrefixCode("221");
        country.setCodeISO2("SN");
        country.setCodeISO3("SEN");
        country.setCurrencyCode(currency);
        countries.add(country);




        return countries;
    }
}
