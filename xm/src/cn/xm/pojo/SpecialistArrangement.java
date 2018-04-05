package cn.xm.pojo;

public class SpecialistArrangement extends SpecialistArrangementKey {
    private String leader;

    private Boolean isagree;

    private String source;

    private Boolean ispromise;

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader == null ? null : leader.trim();
    }

    public Boolean getIsagree() {
        return isagree;
    }

    public void setIsagree(Boolean isagree) {
        this.isagree = isagree;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Boolean getIspromise() {
        return ispromise;
    }

    public void setIspromise(Boolean ispromise) {
        this.ispromise = ispromise;
    }
}