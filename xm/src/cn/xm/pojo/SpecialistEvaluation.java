package cn.xm.pojo;

public class SpecialistEvaluation extends SpecialistEvaluationKey {
    private String remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}