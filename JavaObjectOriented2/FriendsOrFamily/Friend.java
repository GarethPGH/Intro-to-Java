/**Friend Class*/
package CIT244_LabAssignments.Wk2;

public class Friend {
    private String name;
    private int timeKnown;

    public Friend(String name, int timeKnown) {
        this.name = name;
        this.timeKnown = timeKnown;
    }

    public void validateTimeKnown() {
        int time = this.timeKnown;
        if (time < 0) {
            this.timeKnown = 0;
        }
    }

    public String toString() {
        return this.name + " and you have been friends for " + this.timeKnown + " years.";
    }
}
