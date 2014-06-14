package cn.edu.thu.action;

import cn.edu.thu.classify.ClassifyMain;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月13日 下午10:06:00
 */
public class ClassifyAction extends ActionSupport{
	private String text;
	private String label;
	ClassifyMain main = new ClassifyMain();
	public String getResult(){
		label = main.classify(text);
		return SUCCESS;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}

}
