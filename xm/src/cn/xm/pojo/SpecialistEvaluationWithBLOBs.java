package cn.xm.pojo;

public class SpecialistEvaluationWithBLOBs extends SpecialistEvaluation {
    private String reviewsuggestion;

    private String opinion;

    public String getReviewsuggestion() {
        return reviewsuggestion;
    }

    public void setReviewsuggestion(String reviewsuggestion) {
        this.reviewsuggestion = reviewsuggestion == null ? null : reviewsuggestion.trim();
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion == null ? null : opinion.trim();
    }
}