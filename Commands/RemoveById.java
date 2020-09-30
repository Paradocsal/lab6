package Commands;

import This.OrganizationData;

import java.io.IOException;

public class RemoveById implements Command {
    public  RemoveById(){
        CommandExecutor.addCommand("remove_id",this);
    }
    @Override
    public String execute(String arg, OrganizationData data) {
        try {
            Long id = Long.parseLong(arg);
            if (data.getListOfIds().contains(id)) {
                data.remove( data.getOrganizationArrayDeque().stream().filter(o ->o.getId()==id).findFirst().get());

                return ("Organizartion with id " + id + " was removed");
            } else {
                return ("Organization with id " + id + " not found");
            }


        } catch (NumberFormatException e) {
            return ("Id's number format error");
        }
    }
}
