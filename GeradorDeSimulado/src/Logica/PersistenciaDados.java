package Logica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import com.thoughtworks.xstream.XStream;

public class PersistenciaDados {

    public static Prova pegaDados() {
        try {
            XStream xstream = new XStream();
            Prova prova;
            xstream.alias("list", ArrayList.class);
            BufferedReader input = new BufferedReader(new FileReader("prova.xml"));
            prova = (Prova) xstream.fromXML(input);
            return prova;

        } catch (FileNotFoundException e) {
        }
        return new Prova();
    }

    public static void guardaDados(Prova prova) throws IOException {
        try {
            XStream xstream = new XStream();
            PrintWriter out;
            xstream.alias("list", ArrayList.class);
            out = new PrintWriter(new FileWriter("prova.xml"));
            out.println(xstream.toXML(prova));
            out.close();
        } catch (FileNotFoundException e) {
        }
    }
}
