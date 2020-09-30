package This;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class NewElementData {
    public static Organization createOrganization() {
        Scanner sc = new Scanner(System.in);
        Organization organization = new Organization();
        organization.setCreationDate(Date.from(Instant.now()));
        organization.setName(defineName());
        organization.setFullName(defineFullName());
        organization.setCoordinates(defineCoords());
        organization.setAnnualTurnover(defineAnnualTurnover());
        organization.setEmployeesCount(defineEmployeesCount());
        organization.setType(chooseOrganizationType());
        organization.setPostalAddress(definePostalAddress());
        return organization;
    }

    public static String defineName() {
        System.out.println("Define name of the organization");
        String name = " ";
        while (name.equals(" ")) {
            name = Inputting.readLine().trim();
            if (name.equals(" ")) {
                System.out.println("You must define this field");
            }
        }
        return name;
    }

    public static String defineFullName() {
        System.out.println("Define full name of the organization");
        String name = " ";
        while (name.equals(" ")) {
            name = Inputting.readLine().trim();
            if (name.equals(" ")) {
                System.out.println("You must define this field");
            }
        }
        return name;
    }

    public static Coordinates defineCoords() {
        Integer coordX = null;
        Integer coordY = null;
        while (coordX == null) {
            try {
                System.out.println("Define coordinate x(x must be Integer)");
                coordX = Integer.parseInt(Inputting.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Wrong number format");
            }
        }
        while (coordY == null) {
            try {
                System.out.println("Define coordinate y(y must be Integer)");
                coordY = Integer.parseInt(Inputting.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Wrong number format");
            }
        }
        Coordinates coordinates = new Coordinates();
        coordinates.setX(coordX);
        coordinates.setY(coordY);
        return coordinates;
    }

    public static double defineAnnualTurnover() {
        System.out.println("define Annual Turnover(must be double)");
        double annualTurnover = 0;
        while (annualTurnover <= 0) {
            try {
                String s = Inputting.readLine();
                if (s.isEmpty()) {
                    return 0;
                }
                annualTurnover = Double.parseDouble(s);

                if (annualTurnover <= 0) {
                    System.out.println("Annual Turnover can't be less then 1");
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong number format. Field must be double");
            }
        }
        return annualTurnover;
    }

    public static Integer defineEmployeesCount() {
        System.out.println("Define employees count(must be Integer)");
        Integer employeesCount = 0;
        while (employeesCount <= 0) {
            try {
                String line = Inputting.readLine();
                if (line.isEmpty()) {
                    return null;
                }
                employeesCount = Integer.parseInt(line);

                if (employeesCount <= 0) {
                    System.out.println("Employees count must be more then 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong number format. Field must be integer");
            }
        }
        return employeesCount;
    }

    public static OrganizationType chooseOrganizationType() {
        OrganizationType type = null;
        OrganizationType[] allTypes = OrganizationType.values();
        String[] allTypesStrings = new String[allTypes.length];
        for (int i = 0; i < allTypes.length; i++) {
            OrganizationType possibleGenre = allTypes[i];
            allTypesStrings[i] = possibleGenre.name();
        }
        System.out.println("Choose organization type(" + String.join(", ", allTypesStrings) + ")");
        boolean correctInput = false;
        while (!correctInput) {
            List<String> typesList = Arrays.asList(allTypesStrings);

            String s = Inputting.readLine();
            if (!typesList.contains(s)) {
                System.out.println("Choose organization type(" + String.join(", ", allTypesStrings) + ")");
            } else {
                if (typesList.contains(s)) {
                    type = OrganizationType.valueOf(s);
                }
                correctInput = true;
            }
        }
        return type;
    }
    public static Address definePostalAddress(){
        Address postalAddress = new Address();
        System.out.println("Enter address(street only)");
        String addressNameInput = Inputting.readLine().trim();
        if (!addressNameInput.equals("")) {
            postalAddress.setStreet(addressNameInput);
        }
        return postalAddress;


    }
}
