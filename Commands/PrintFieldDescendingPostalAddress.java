package Commands;

import This.NewElementData;
import This.Organization;
import This.OrganizationData;

public class PrintFieldDescendingPostalAddress implements Command {
    public PrintFieldDescendingPostalAddress() {
        CommandExecutor.addCommand("print_field_descending_postal_address", this);
    }

    @Override
    public String execute(String arg, OrganizationData data) {
        System.out.println("All postal addresses in decreasing order: ");
        data.getOrganizationArrayDeque().stream()
                .filter(o ->o.compareTo(o)<0)
                .forEach(o ->System.out.println("sss"));
        return null;

    }
}
