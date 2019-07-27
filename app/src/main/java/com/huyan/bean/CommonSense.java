package com.huyan.bean;

/**
 * @date: 2019/4/26
 * @author:bin
 * @email:958615915@qq.com
 */
public class CommonSense {
    private String title;
    private String content;// 内容

    public CommonSense(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CommonSense{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
