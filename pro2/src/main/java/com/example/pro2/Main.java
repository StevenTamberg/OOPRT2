package com.example.pro2;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;

/*Loeb sisse arvude faili mis sisalsab programmi poolt genereeritud arvu 1 - 100
  ning boolean väärtust (true - arvu võib kasutada, false - arv on juba kasutatud ning selle peab
  vahele jätma.
  Seejärel küsib programm kasutajalt numbrit ning annab vihjeid kas tegu on väiksema või suuremaga.
  Kui kasutaja on arvu ära arvanud muudab programm arvu boolean väärtust vastavalt.
  Kui kõik numbrid on failist ära arvatud genereerib programm uued numbrid.

*/

public class Main {

    private static List<Arv> LoeFaili(String failiNimi) throws IOException {
        List<Arv> arvuList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(failiNimi), "UTF-8"))) {
            while (true) {
                String rida = br.readLine();
                if (rida == null) return arvuList;
                arvuList.add(new Arv(rida));
            }
        }
    }


    public static void main(String[] args) throws IOException, SisestusErind {
        Path path = Paths.get("arvud.txt");
        List<Arv> arvud = new ArrayList<>();
        if (Files.exists(path)) { arvud = LoeFaili("arvud.txt"); }
        else {
            for (int i = 0; i < 5; i++) {
                Random r = new Random();
                int result = r.nextInt(99) + 1;
                arvud.add(new Arv(result, true));
            }
        }
        try (BufferedReader kasutajaSisend = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                int hetkeArv = 0;
                for (Arv arv : arvud) {
                    if (arv.isLoetud()) { hetkeArv = arv.getArv(); }
                }

                System.out.println("Sisesta arv: ");
                String sisestus = kasutajaSisend.readLine();
                //if (!sisestus.matches("[0-9+]")) {
                //    throw new SisestusErind("Sisesta number!");
                //}
                if (Integer.parseInt(sisestus) < hetkeArv) {
                    System.out.println("Otsitud arv peab olema suurem.");
                }
                else if (Integer.parseInt(sisestus) > hetkeArv) {
                    System.out.println("Otsitud arv peab olema vaiksem.");
                } else {
                    System.out.println("Arv on oige!");
                    for (Arv arv : arvud) {
                        if (arv.getArv() == hetkeArv) {
                            arv.setLoetud(false);
                        }
                    }
                }
            }
        }

    }

}
