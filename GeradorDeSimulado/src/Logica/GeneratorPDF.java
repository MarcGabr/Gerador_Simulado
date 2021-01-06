package Logica;

import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.text.DecimalFormat;

public class GeneratorPDF {

    public static void gerar(String[] prova, String data, String file, int qtd, String disciplina, Float valor, String professor) {
        Document document = new Document(); //Cria o documento
        try {
            System.out.println(file);
            PdfWriter.getInstance(document, new FileOutputStream(file + ".pdf")); //Cria o arquivo PDF.
            document.open(); //Abre o documento

            Image figura = Image.getInstance("UFT.png"); // Abre a imagem.
            figura.scalePercent(70); //Define tamanho da imagem.
            figura.setAbsolutePosition(360, 755); // Define Posição da imagem.
            document.add(figura); // insere a imagem.
            
            DecimalFormat formato=new DecimalFormat("#.00");
  
            String cabecalho = "Curso de Ciência da Computação\nDisciplina: "
                    + disciplina+"\nData: " + data + "\b Valor:"+ formato.format(valor)+"\nProfessor(a):" +professor+"\nAluno:__________________________________________________ Matricula:____________\n\n\n";

            document.add(new Paragraph(cabecalho, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12))); //Adiciona o cabeçalho, com formatação de texto.

            Paragraph l = new Paragraph(); // Cria a lista para organizar as questões.

            for (int i = 0; i < qtd; i++) {
                document.add(new Paragraph(prova[i]+"\n"));
//                l.add(prova[i]);
//                l.add("\n");// adiciona as questões à lista.
            }
             // insere a lista com as questões, no documento.
        } catch (DocumentException | IOException de) {
            System.err.println(de.getMessage());
        }
        document.close(); // Fecha o documento
    }

}
