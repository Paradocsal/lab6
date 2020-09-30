package Commands;

import This.*;


public class Info implements Command {
    public Info(){
        CommandExecutor.addCommand("info",this);

    }

    @Override
    public String execute(String s, OrganizationData orgData) {
        return ("Тип: ArrayDequeue\n"  +
                " Количество элементов: " + orgData.getOrganizationArrayDeque().size() + '\n');
    }
}
