package day6;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GuiApp extends JFrame {
	JButton closeBtn = new JButton("닫기");
	JButton saveBtn = new JButton("저장");
	JButton exitBtn = new JButton("종료");
	JButton cancelBtn = new JButton("취소");

	public GuiApp() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		add(saveBtn);
		add(exitBtn);
		add(cancelBtn);
		add(closeBtn);

		// 이벤트 핸들러(이벤트 리스터) 작성하기
		// 버튼을 클릭했을 때, 입력필드에서 enter키를 눌렀을 때는 ActionEvent가 발생한다.
		// 이벤트 소스 : JButton
		// 선정된 이벤트 : ActionEvent
		// 이벤트 핸들러 : ActionListener 인터페이스를 구현해서 작성한다.

		// 저장하기 버튼에서 이벤트 발생시 실행할 내용이 구현된 익명클래스 및 객체 생성
		ActionListener listener1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("저장이 완료되었습니다");
			}
		};

		// 저장하기 버튼에서 이벤트 발생시 실행할 내용이 구현된 익명클래스 및 객체 생성
		ActionListener listener2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("프로그램을 종료합니다.");
			}
		};

		// 이벤트소스에 이벤트핸들러(이벤트리스너) 연결하기
		saveBtn.addActionListener(listener1);
		exitBtn.addActionListener(listener2);
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("실행을 취소합니다.");
			}
		});
//		closeBtn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("창을 닫습니다.");
//			}
//		});
//		=>람다식
		closeBtn.addActionListener(e -> System.out.println("닫기를 실행함"));

		setVisible(true);
		setBounds(400, 400, 300, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new GuiApp();
	}
}
