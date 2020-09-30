package Commands;

import This.Organization;
import This.OrganizationData;

public class Clear implements Command{
    public Clear() {
        CommandExecutor.addCommand("clear",this);
    }
    public String execute(String s, OrganizationData org){
        org.clearCollection();
        return ("Collection Cleared");
    }
}
