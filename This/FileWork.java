package This;
import java.io.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
/**
 * Class reading/writing xml files
 */
public class FileWork {
    /**
     * Method that save your collection in xml file with path ...
     *
     * @param collection - collection to save
     * @param filePath   - path to file
     * @throws JAXBException
     */

    public static void saveToXml(OrganizationData collection, String filePath) throws JAXBException{
        File file = new File(filePath);
        try{
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            JAXBContext context = JAXBContext.newInstance(OrganizationData.class, Organization.class,Coordinates.class,Address.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(collection, writer);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("file save error");
        }
    }
    public static OrganizationData readFromXML(String filePath) throws JAXBException {
        String xmldata = "";
        File file = new File(filePath);
        try {
            FileInputStream fil = new FileInputStream(file);
            BufferedInputStream buf = new BufferedInputStream(fil);
            while (buf.available() > 0) {
                xmldata += (char) buf.read();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Program can't find file");
        } catch (IOException ex) {
            System.out.println("Reading file error");
        }
        StringReader reader = new StringReader(xmldata);

        JAXBContext context = JAXBContext.newInstance(OrganizationData.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        OrganizationData data = (OrganizationData)unmarshaller.unmarshal(reader);
        return data;
    }

}

