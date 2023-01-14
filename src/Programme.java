// ProgrammeInfo is part of Composition.
// Definition : Composition Like Aggregation but the owned object is not
// independent from the owner which means by deleting owner the owned object
// will also be deleted.

public class Programme {
    public String programmeId;
    public String programmeName;
    public String programmeDescription;

    public Programme(String programmeId, String programmeName, String programeDescription) {
        this.programmeId = programmeId;
        this.programmeName = programmeName;
        this.programmeDescription = programeDescription;
    }

    @Override
    public String toString() {
        return "Programme [programmeId=" + programmeId + ", programmeName=" + programmeName + ", programmeDescription="
                + programmeDescription + "]";
    }

    public String getProgrammeId() {
        return programmeId;
    }

    public void setProgrammeId(String programmeId) {
        this.programmeId = programmeId;
    }

    public String getProgrammeName() {
        return programmeName;
    }

    public void setProgrammeName(String programmeName) {
        this.programmeName = programmeName;
    }

    public String getProgrammeDescription() {
        return programmeDescription;
    }

    public void setProgrammeDescription(String programmeDescription) {
        this.programmeDescription = programmeDescription;
    }

}
