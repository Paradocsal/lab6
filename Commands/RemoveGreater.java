package Commands;

import This.NewElementData;
import This.Organization;
import This.OrganizationData;

import java.util.NoSuchElementException;

public class RemoveGreater implements Command{
    public RemoveGreater() {
        CommandExecutor.addCommand("remove_greater", this);
    }
    public String execute(String arg, OrganizationData data) {
        long oldSize = data.getListOfIds().size();

        Organization organization = NewElementData.createOrganization();
        try {
            data.remove(data.getOrganizationArrayDeque().stream()
                    .filter(o -> organization.compareTo(o) < 0)
                    .findFirst()
                    .get());
            //data.removeIfGreater(organization);

            long newSize = data.getListOfIds().size();
            return ((oldSize - newSize) + " elements greater than " + organization + "\nwere removed");
        }
        catch (NoSuchElementException e){
            return ( "0 elements greater than " + organization + "\nwere removed");
        }
    }
}
