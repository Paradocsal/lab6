package This;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
@XmlRootElement(namespace = "OrganizationData")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrganizationData {


     ArrayDeque<Organization> organizationArrayDeque;
    /**
     * Building empty OrganizationData
     */
    public OrganizationData(){
        organizationArrayDeque = new ArrayDeque<>();

    }

    public void setQ(ArrayDeque<Organization> q){
        this.organizationArrayDeque = q;
    }
    public ArrayDeque<Organization> getOrganizationArrayDeque() {
        return organizationArrayDeque;
    }
    public Organization getFirst(){return organizationArrayDeque.getFirst();}
    public void removeFirst(){ organizationArrayDeque.removeFirst();}
    public long getLastId(){
        long lastId = 0;
        for(Organization org : organizationArrayDeque){
            if(org.getId() > lastId){
                lastId = org.getId();
            }
        }
        return lastId;
    }
    public void addOrganization(Organization org){
        org.setId(getLastId()+1);
        this.organizationArrayDeque.add(org);
    }

    public ArrayList<Long> getListOfIds() {
        ArrayList<Long> ids = new ArrayList<>();
        for (Organization organization :
                organizationArrayDeque) {
            ids.add(organization.getId());
        }
        return ids;
    }
    public Organization getElementById(long id){
        for(Organization org : organizationArrayDeque){
            if(org.getId() == id){
                return org;
            }
        }
        return null;
    }
    public void updateOrganization(long id, Organization organization) {
        Organization updatingOrganization = new Organization();
        for (Organization org :
                organizationArrayDeque) {
            if (org.getId() == id) {
                updatingOrganization = org;
            }
        }
        organizationArrayDeque.remove(updatingOrganization);
        organization.setId(id);
        organizationArrayDeque.add(organization);
    }
    public void remove(Organization org){
        organizationArrayDeque.remove(org);
    }
    public void clearCollection(){
        organizationArrayDeque.clear();
    }
}
