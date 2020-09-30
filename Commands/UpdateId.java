package Commands;

import This.NewElementData;
import This.Organization;
import This.OrganizationData;

public class UpdateId implements Command {
    public UpdateId(){
        CommandExecutor.addCommand("update_id", this);
    }

    @Override
    public String execute(String s, OrganizationData data) {
        try{
            long id = Long.parseLong(s);


            if (data.getListOfIds().contains(id)) {
                Organization organization = NewElementData.createOrganization();
                data.updateOrganization(id, organization);
                Organization newOrganization = data.getElementById(id);
                return ("Element with id " + id + " was updated, new one:\n" + newOrganization);
            } else {
                return ("Band with id " + id + " doesn't exist");
            }

        } catch (NumberFormatException e) {
            return ("Wrong id number format");
        }

        }
    }

