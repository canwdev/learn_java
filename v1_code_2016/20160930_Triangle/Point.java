class Point {
	int x,y;
	Point() {
		this.x=0;
		this.y=0;
	}
	Point(int x,int y) {
		this.x=x;
		this.y=y;
		System.out.println("������ȡ�ɹ���x="+x+"  y="+y);
	}
	void Show(){
		System.out.println("x="+x+"  y="+y);
	}
}