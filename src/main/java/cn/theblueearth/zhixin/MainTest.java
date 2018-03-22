package cn.theblueearth.zhixin;

public class MainTest {
	private static String name = "MainTest Name";
	public static void main(String[] args) {
		Object obj = new Object();
		System.out.println("getClass:"+obj.getClass());
		System.out.println("hashCode:"+obj.hashCode());
		System.out.println("obj:"+obj);
		System.out.println("toString:"+obj.toString());
		System.out.println("equals:"+obj.equals(new Object()));
		
		MainTest mainTest = new MainTest();
		
		People people1 = mainTest.new People("张三");
		People people2 = mainTest.new People("张三");
		People people3 = mainTest.new People("李四");
		System.out.println("people1==people2:"+(people1==people2));
		System.out.println("people1.equals(people2):"+people1.equals(people2));

		System.out.println("people3==people2:"+(people3==people2));
		System.out.println("people3.equals(people2):"+people3.equals(people2));
		
		StaticPeople staticPeople = new StaticPeople();
		
		//http://blog.csdn.net/qq_22118507/article/details/51422591
		
		String p [] = "/voteqh/app/rdfx2018/post.app".split("/");
		//String p[] = new String[]{"","voteqh","app","rdfx2018","post.app"};
		String f = p[4];
		StringBuilder path = new StringBuilder("");       
		path.append(f.subSequence(0, f.indexOf("."))).append(".").append(f.charAt(0));
		System.out.print(path);
	}
	
	class People{
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public People(String name){
			this.name = name;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			People other = (People) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		private MainTest getOuterType() {
			return MainTest.this;
		}
	} 
	
	static class StaticPeople{
		public StaticPeople(){
			System.out.println("outer class:"+name);
		}
	}

}
