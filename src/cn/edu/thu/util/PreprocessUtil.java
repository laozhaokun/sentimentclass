package cn.edu.thu.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月13日 下午10:14:10
 */
public class PreprocessUtil {
	public static HashMap<String,Integer> convertReviewToHashMap(String input) {
		String temp = input.replaceAll("[^a-zA-Z 0-9]", " ").toLowerCase();
		temp = temp.replaceAll("\\s+", " ");
		String[] str = temp.split(" ");
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for(String s : str){
			if(map.containsKey(s))
				map.put(s, map.get(s)+1);
			else
				map.put(s, 1);
		}
		return map;
		
	}
	public static HashMap<String, Double> weightVectorFromFile (File f) {
		String line = new String();
		HashMap<String, Double> weightVector = new HashMap<String, Double>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			line = br.readLine();
			if (line==null){
				System.err.println("Weight vector file is empty: "+f.toString());
				return null;
			}
			br.close();
			String[] arrayWithFeatures = line.split(" ");
			for (String feature : arrayWithFeatures) {
				String[] featureAndValue = feature.split(":");
				String key = featureAndValue[0];
				Double value = Double.parseDouble(featureAndValue[1]);
				weightVector.put(key, value);
			}
		} catch (FileNotFoundException e) {
			System.err.println("Weight vector file not found: "+f.toString());
			weightVector = null;
		} catch (IOException e) {
			e.printStackTrace();
			weightVector = null;
		}
		
		return weightVector;
	}

}
