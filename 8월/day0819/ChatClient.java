package day0819;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame {
    JTextArea ta;
    JScrollPane scrol;
    JTextField send_tf;
    
    JLabel la_msg;
    JList<String> list;
    JScrollPane list_scrol;
    
    JButton bt_change,bt_exit;
    
    JPanel p;
    
    
    	
	public ChatClient() {
		setTitle("채팅방");
		
		ta = new JTextArea();
		ta.setEditable(false);
		scrol = new JScrollPane(ta);
		send_tf = new JTextField();
		
		la_msg = new JLabel("Message");
		list = new JList<String>();
		list_scrol = new JScrollPane(list);
		
		bt_change = new JButton("대화명변경");
		bt_exit = new JButton("나가기");
		p = new JPanel();
		
		scrol.setBounds(10, 10, 350, 300);
		list_scrol.setBounds(370, 10, 120, 260);
		la_msg.setBounds(10, 320, 60, 30);
		send_tf.setBounds(70, 320, 290, 30);
		bt_change.setBounds(370, 280, 120, 30);
		bt_exit.setBounds(370, 320, 120, 30);
		
		p.setLayout(null);
		p.setBackground(Color.orange);
		
		p.add(scrol);
		p.add(la_msg);
		p.add(send_tf);
		p.add(list_scrol);
		p.add(bt_change);
		p.add(bt_exit);
		
		add(p);
		
		setBounds(300, 200, 520, 400);
		//setVisible(true);
		send_tf.requestFocus();
		//setDefaultCloseOperation(EXIT_ON_CLOSE);	
		
	}//생성자	

}




