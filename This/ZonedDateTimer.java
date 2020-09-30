package This;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.ZonedDateTime;

public class ZonedDateTimer extends XmlAdapter<String, ZonedDateTime> {
    public ZonedDateTime unmarshal(String s) throws Exception {
        return ZonedDateTime.parse(s);
    }

    public String marshal(ZonedDateTime s) throws Exception {
        return s.toString();
    }
}
