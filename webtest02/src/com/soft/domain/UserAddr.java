package com.soft.domain;

public class UserAddr {
	
	private int id;
	
	private String receiver; //�ռ���
	
	private String addr;     //�ռ��˵�ַ
	
	private long receivertel;		//�ռ��˵绰
	
	private String receiveraddr; //�ռ�����ϸ��ַ
	
	public UserAddr(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public long getReceivertel() {
		return receivertel;
	}

	public void setReceivertel(long receivertel) {
		this.receivertel = receivertel;
	}

	public String getReceiveraddr() {
		return receiveraddr;
	}

	public void setReceiveraddr(String receiveraddr) {
		this.receiveraddr = receiveraddr;
	}
	
	
}
