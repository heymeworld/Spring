package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class PrivateMethodCall {
	public static void main(String[] args) throws Exception {
//		Hello hello = new Hello();
//		hello.main(); // private이라서 외부 호출 불가
		
		// private 메서드인데도 외부에서 후출이 가능했던 이유
		// Reflection API를 사용하기 떄문 - 클래스 정보를 얻고 다룰 수 있는 강력한 기능 제공
		// java.lang.reflecti 패키지를 제공
		// Hello 클래스의 Class객체(클래스의 정보를 담고 있는 개체)를 얻어온다
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		Hello hello = (Hello)helloClass.newInstance(); // Class객체가 가진 정보로 객체 생성
		Method main = helloClass.getDeclaredMethod("main");
		main.setAccessible(true); // private인 main()을 호출가능하게 한다
		
		main.invoke(hello); // hello.main()
	}

}
