package com.rizky_02736.desemar;

public class ModelList {
    String id, jobname, requirement, img;
    public ModelList(){};

    public ModelList(String id, String jobname, String requirement, String img) {
        this.id = id;
        this.jobname = jobname;
        this.requirement = requirement;
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
