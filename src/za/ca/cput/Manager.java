package za.ca.cput;

public class Manager extends FileHandler {

    private String title, firstName, lastName;
    private boolean finTakeover, preTourn;

    public Manager(String title, String firstName, String lastName, boolean finTakeover, boolean preTourn) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.finTakeover = finTakeover;
        this.preTourn = preTourn;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastName;
    }

    public boolean isFinTakeover() {
        return finTakeover;
    }

    public boolean isPreTourn() {
        return preTourn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastname(String lastName) {
        this.lastName = lastName;
    }

    public void setSmoker(boolean finTakeover) {
        this.finTakeover = finTakeover;
    }

    public void setStaffMember(boolean preTourn) {
        this.preTourn = preTourn;
    }
    
    public boolean writeToFile (boolean wtf) {
        if (wtf == false) {
            closeFile();
        } else if (wtf == true) {
            openFile();
            processFile("============================" + "\n"
                    + "Club: " +title + "\n" + "Manager Name: "+ firstName + "\n"  + "Manager Surname: "+ lastName + "\n"  + "Financial Takeover?: "+ finTakeover + "\n"  +"Pre-Season Tournament: "+  preTourn + "\n");

            closeFile();
        }
        return wtf;
    }
}
