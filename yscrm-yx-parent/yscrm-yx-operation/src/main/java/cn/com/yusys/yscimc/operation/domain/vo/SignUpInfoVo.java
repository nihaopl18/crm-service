package cn.com.yusys.yscimc.operation.domain.vo;

/**
 * @author houyx3
 * @email houyx3@yusys.com.cn
 * @date 2022/1/11 11:13
 */
public class SignUpInfoVo implements ContentInfoVo{

    /**
     * 栏位图片地址
     */
    private String imageurl;

    /**
     * 活动页面地址
     */
    private String actHtml;

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getActHtml() {
        return actHtml;
    }

    public void setActHtml(String actHtml) {
        this.actHtml = actHtml;
    }
}
