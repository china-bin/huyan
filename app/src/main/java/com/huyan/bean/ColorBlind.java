package com.huyan.bean;

/**
 * @date: 2019/4/24
 * @author:bin
 * @email:958615915@qq.com
 */
public class ColorBlind {
    private String img;
    private String question;
    private String option;// 选项用，分割
    private String info;// 选项对应的信息

    public ColorBlind(String img, String question, String option, String info) {
        this.img = img;
        this.question = question;
        this.option = option;
        this.info = info;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "ColorBlind{" +
                "img='" + img + '\'' +
                ", question='" + question + '\'' +
                ", option='" + option + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
