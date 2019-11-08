package uk.gov.ch.chips.process;

/**
 * This is a simple tool created to convert html to pdf using the
 * Flying Saucer API.
 * 
 * https://github.com/flyingsaucerproject/flyingsaucer
 *
 */

import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xhtmlrenderer.resource.XMLResource;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import java.io.*;
import java.util.Scanner;


public class Convert {

    public static void main(String[] args) throws IOException {

        Convert convert = new Convert();
        convert.displayMessage();
        Scanner scanner = new Scanner(System.in);
       String inputFile = scanner.next();
       String outputFile = scanner.next();

        String inputFileUrl = new File(inputFile).toURI().toURL().toString();
        System.out.println("The input file name is : " + inputFileUrl );
       System.out.println("The output file name is : " + outputFile);
        createPDF(inputFileUrl, outputFile);
    }

    /**
     * Method to convert a well formed html file to a pdf format
     *
     * @param url: This is the path/name of the html file
     * @param pdf: This is the path/name of the pdf file
     * @throws IOException
     */
    public static void createPDF(String url, String pdf)
            throws IOException {
        OutputStream os = null;
        try {
            os = new FileOutputStream(pdf);
            ITextRenderer renderer = new ITextRenderer();
            Document doc = XMLResource.load(new InputSource(url)).getDocument();
            renderer.setDocument(doc, url);
            renderer.layout();
            renderer.createPDF(os);
            os.close();
            os = null;
        } catch (com.lowagie.text.DocumentException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                     e.getMessage();
                }
            }
        }
    }


    public void displayMessage() {
        String s = "\n ---------------------------------------------------------------\n" +
                " To use the HTML 2 PDF converter Test Bed, \n" +
                " Please enter the html file name and the pdf file name" +
                " you want to covert to, for example \n " +
                " java -jar Converter.jar inputfile.html outputfile.pdf \n";
        System.out.println(s);
    }

    private String getJarFolder() {
        // get name and path
        String name = Convert.class.getName().replace('.', '/');
        name = Convert.class.getResource("/" + name + ".class").toString();
        // remove junk
        name = name.replace('/', File.separatorChar);
        name = name.substring(0, name.indexOf(".jar"));
        name = name.substring(name.lastIndexOf(':')-1, name.lastIndexOf('/')+1).replace('%', ' ');
        // remove escape characters
        String s = "";
        for (int k=0; k<name.length(); k++) {
            s += name.charAt(k);
            if (name.charAt(k) == ' ') k += 2;
        }
        // replace '/' with system separator char
        return s.replace('/', File.separatorChar);
    }
}
