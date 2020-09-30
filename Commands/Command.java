package Commands;

import This.Organization;
import This.OrganizationData;

import java.io.Serializable;

public interface Command extends Serializable {
    String execute(String s, OrganizationData data);
}
