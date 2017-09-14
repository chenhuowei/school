package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fireway.utils.Encrypt;
import com.fireway.utils.Utils;


public class Test{
	
	
	
	
	public static void main(String[] args) throws IOException{
		
		List<String> list = new ArrayList<String>();
		String grade = "2016";
		int now = Integer.parseInt(grade);
		int next = now+1;
		
			for (int i = 0; i < 4; i++) {
				list.add(now+"-"+next);
				now++;
				next++;
			}
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equalsIgnoreCase(Utils.getSchoolYearAtNow())){
				System.out.println(list.get(i)+","+Utils.getTermAtNow());
			}
		}
		
		
		System.out.println(Encrypt.md5Encode("123456"));
		
		
		
		
		
	}
}