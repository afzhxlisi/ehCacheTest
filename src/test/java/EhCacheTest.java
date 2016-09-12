import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)		//��ʾ�̳���SpringJUnit4ClassRunner��
@ContextConfiguration(locations = {"classpath:application.xml"})

public class EhCacheTest {

	public static Logger logger = LoggerFactory.getLogger(EhCacheTest.class);
	@Resource
	UserService userService;
	
	@Test
	public void testAll(){
		try {
//			logger.info(userService.find(null).toString());
			Thread.sleep(10000);
			logger.info(userService.find(null).toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public  static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		context.getBean(UserService.class).find(null);
//		context.getBean(CacheManager.class).getCache("users").put("123", "123");
		logger.info(context.getBean(CacheManager.class).getCache("users").get("123").get().toString());
		logger.info(context.getBean(CacheManager.class).getCache("users").get("234").get().toString());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info(context.getBean(CacheManager.class).getCache("users").get("123").get().toString());
		boolean flag;
		flag =(context.getBean(CacheManager.class).getCache("users").get("234")!=null);
		logger.info(String.valueOf(flag));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info(context.getBean(CacheManager.class).getCache("users").get("123").get().toString());
		logger.info(context.getBean(CacheManager.class).getCache("users").get("234").get().toString());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
