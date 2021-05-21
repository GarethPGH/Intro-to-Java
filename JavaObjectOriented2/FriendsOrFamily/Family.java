/**Family Class*/
package CIT244_LabAssignments.Wk2;

public class Family {
    private String name;
    private String relation;

    public Family(String name, String relation) {
        this.name = name;
        this.relation = relation;
    }

    public String toString() {
        return this.name + " is a part of your family. You are their " + this.relation + ".";
    }
}
