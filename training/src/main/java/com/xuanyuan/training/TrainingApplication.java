package com.xuanyuan.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/** *
 * @Author Lee
 * @Description //TODO 启动程序
 * @Date  2020/3/30 10:32
 * @Param
 * @return
 **/
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class TrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingApplication.class, args);
		System.out.println("(♥◠‿◠)ﾉﾞ  系统启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
				" .-------.       ____     __        \n" +
				" |  _ _   \\      \\   \\   /  /    \n" +
				" | ( ' )  |       \\  _. /  '       \n" +
				" |(_ o _) /        _( )_ .'         \n" +
				" | (_,_).' __  ___(_ o _)'          \n" +
				" |  |\\ \\  |  ||   |(_,_)'         \n" +
				" |  | \\ `'   /|   `-'  /           \n" +
				" |  |  \\    /  \\      /           \n" +
				" ''-'   `'-'    `-..-'              ");
	}

}
