package Commands;

import This.NewElementData;
import This.Organization;
import This.OrganizationData;

public class AddNew implements Command {
    public AddNew(){
        CommandExecutor.addCommand("add",this);
    }
    public String execute(String s, OrganizationData orgData){
        Organization organization = NewElementData.createOrganization();
        orgData.addOrganization(organization);
        return (organization.getName() + " was added");

    }
}
