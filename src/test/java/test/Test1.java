package test;

import com.alibaba.fastjson.JSON;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.junit.Test;

import com.fireway.entity.ChatRecord;
import com.fireway.utils.BeanAndMapUtil;
import com.fireway.utils.LogUtil;

public class Test1 {

	@Test
	public void test() {
		
		Map<String , Object> map = BeanAndMapUtil.bean2Map(new TestUser("chen", "1306", new Date()));
		
		LogUtil.info(getClass(), map.keySet()+"-"+map.values());
		
		TestUser user = (TestUser) BeanAndMapUtil.map2Bean(map, new TestUser());
		LogUtil.info(getClass(), user.toString());
	}
	
	@Test
	public void test1() {
		
		Calendar calendar = Calendar.getInstance();
		System.out.println("现在："+calendar.getTime().getTime());
		calendar.add(Calendar.YEAR, 10);
		System.out.println("10年后："+calendar.getTime().getTime());
		System.out.println(System.currentTimeMillis());
	}
	
	@Test
	public void test2() {
		String id = "chen123465";
		String  s = "<a style='color:red'>未发送</a>  "
				+ " <INPUT type='button' value='点击发送' onclick='updateSendStatus("+id+",1)'"+
                "style='border-right: #7b9ebd 1px solid; padding-right: 2px;"
                + "color: green;cursor: hand;'>";
		System.out.println(s);
	}
	
	@Test
	public void test3() {
		boolean flag = true;
		int i = 0;
		while(flag){
			i++;
			if (i==10){
				flag = false;
			}
			System.out.println(i);
		}
	}
	
	@Test
	public void jsonTest() {
		
		ChatRecord record = new ChatRecord();
		record.setFromUserId("123");
		record.setFromUserName("test");
		record.setMessage("message");
		String json = JSON.toJSONString(record);
		System.out.println(json);
		ChatRecord chatRecord = JSON.parseObject(json, ChatRecord.class);
		System.out.println(chatRecord);
		
	}

}
