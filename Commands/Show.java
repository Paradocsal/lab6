package Commands;

import This.Organization;
import This.OrganizationData;

public class Show implements Command {
    public Show(){
        CommandExecutor.addCommand("show",this  );
    }
    @Override
    public String execute(String s, OrganizationData data){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Queue elements:\n ");
        for (Organization org : data.getOrganizationArrayDeque()){
            stringBuilder.append(org+"\n");
        }
        return stringBuilder.toString();
    }
}
