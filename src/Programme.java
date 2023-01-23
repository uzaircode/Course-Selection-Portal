// ProgrammeInfo is part of Composition.
public class Programme {
    public String programmeId;
    public String programmeName;

    public Programme(String programmeId, String programmeName) {
        this.programmeId = programmeId;
        this.programmeName = programmeName;
    }

    @Override
    public String toString() {
        return "Programme [programmeId=" + programmeId + ", programmeName=" + programmeName;
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

}
