package Commands;

import This.OrganizationData;

import java.util.NoSuchElementException;

public class RemoveFirst implements Command{
    public  RemoveFirst(){
        CommandExecutor.addCommand("remove_first_element",this);
    }
    public String execute(String arg, OrganizationData data) {
            try{
                data.removeFirst();
                return ("First organization was removed");
            }
            catch (NoSuchElementException e){
                return ("Collection is empty.");
            }
    }
}
