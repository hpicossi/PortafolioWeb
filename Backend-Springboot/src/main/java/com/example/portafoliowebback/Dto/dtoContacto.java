package com.example.portafoliowebback.Dto;

import jakarta.validation.constraints.NotBlank;

public class dtoContacto {

    @NotBlank
    private String githubUrl;
    @NotBlank
    private String linkedinUrl;

    public dtoContacto() {
    }

    public dtoContacto(String githubUrl, String linkedinUrl) {
        this.githubUrl = githubUrl;
        this.linkedinUrl = linkedinUrl;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }
}
