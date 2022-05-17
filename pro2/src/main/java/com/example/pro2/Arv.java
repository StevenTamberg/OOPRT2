package com.example.pro2;


public class Arv {
    private int arv;
    private boolean loetud;

    //Failist lugemisel kasutan seda konstruktorit
    public Arv(String rida) {
        String[] osad = rida.split(",");
        arv = Integer.parseInt(osad[0]);
        loetud = Boolean.parseBoolean(osad[2]);
    }
    //Kui faili ei ole veel loodud või on failis olevad arvud mängus juba kasutatud
    //kasutan seda konstruktorit et genereerida 5 uut arvu ning need arvulisti lisada.
    public Arv(int result, boolean b) {
        arv = result;
        loetud = b;
    }

    public int getArv() {
        return arv;
    }

    public boolean isLoetud() {
        return loetud;
    }

    public void setLoetud(boolean loetud) {
        this.loetud = loetud;
    }
}