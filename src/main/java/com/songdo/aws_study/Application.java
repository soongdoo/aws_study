package com.songdo.aws_study;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;


@SpringBootApplication
// 스프링 부트의 자동 설저으 스프링 Bean 읽기와 생성을 모두 자동으로 설정
// 해당 어노테이션이 있는 위치부터 설정을 읽어가기 때문에 이 클래스는 항상 프로젝트의 최상단에 위치해야만한다.
public class Application {

    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(Application.class);
        application.addListeners(new ApplicationPidFileWriter());
        application.run(args);

        // 여기서 내장 was (Web Application Service) 실행
        // 외부에 별도 was 를 두지 않고 애플리케이션 실행할 때 내부에서 was를 실행 == 톰캣 설치 불필요 스프링 부트로 만들어진 jar파일 실행
    }
}
