import java.lang.Math;

class Triangle {
	Point a = new Point();
	Point b = new Point();
	Point c = new Point();
	Triangle() {
		
	}
	Triangle(Point a,Point b,Point c) {
		this.a=a;this.b=b;this.c=c;
		System.out.println("�����ȡ�ɹ�: a("+a.x+","+a.y+") "+"b("+b.x+","+b.y+") "+"c("+c.x+","+c.y+")");
	}
	
	void V() {
		double l1,l2,l3;
		l1=Math.sqrt( (a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y) );
		l2=Math.sqrt( (b.x-c.x)*(b.x-c.x) + (b.y-c.y)*(b.y-c.y) );
		l3=Math.sqrt( (c.x-a.x)*(c.x-a.x) + (c.y-a.y)*(c.y-a.y) );
		System.out.println("���������߶γ���: ab="+l1+"  bc="+l2+"  ca="+l3);
		
		if (l1+l2>l3 && l2+l3>l1 && l1+l3>l2) {
			System.out.print("�ɹ��������Σ������ε����Ϊ��");
			double p = (l1+l2+l3)/2;
			double area = Math.sqrt(p*(p-l1)*(p-l2)*(p-l3));
			System.out.println(area);
		}
		else
			System.out.println("���ɹ��������Ρ�");
	}
}