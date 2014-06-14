package cn.edu.thu.classify;

import java.io.File;
import java.util.HashMap;

import org.apache.struts2.ServletActionContext;

import cn.edu.thu.util.PreprocessUtil;


/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月13日 下午10:33:11
 */
public class ClassifyMain {
	public String classify(String input){
//		String file = "data//trained_all_1000_0.05.txt";
		String file=ServletActionContext.getServletContext().getRealPath("/trained_all_1000_0.05.txt");
		System.out.println(new File(file).getAbsolutePath());
		HashMap<String, Double> weightVector = PreprocessUtil.weightVectorFromFile(new File(file));
		HashMap<String, Integer> reviewMap = PreprocessUtil.convertReviewToHashMap(input);
		String label = "";
		double dotP = Perceptron.dotProduct(reviewMap, weightVector);
		if (dotP >= 0) {
			label = "positive";
		} else {
			label = "negative";
		}
		return label;
	}
}
