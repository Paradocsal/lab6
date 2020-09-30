package This;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
/**
 * Class for serializing xml data fields
 */
public class LocalDateTimer extends XmlAdapter<String, LocalDateTime> {
    public LocalDateTime unmarshal(String s) throws Exception {
        return LocalDateTime.parse(s);
    }
    public String marshal(LocalDateTime s) throws Exception {
        return s.toString();
    }
}
