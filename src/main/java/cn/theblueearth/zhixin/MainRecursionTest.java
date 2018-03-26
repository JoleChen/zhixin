package cn.theblueearth.zhixin;

import java.util.ArrayList;
import java.util.List;

public class MainRecursionTest {

	public static void main(String[] args) {
		MainRecursionTest  test = new MainRecursionTest();
		List<PositionVo> positionVoList = new ArrayList<PositionVo>();
		PositionVo root = test.new PositionVo();
		root.setName("BXI-BB");
		root.setParentId(-1);
		positionVoList.add(root);
		
		List<PositionVo> subPositions = new ArrayList<PositionVo>();
		PositionVo p0 = test.new PositionVo();
		p0.setName("智能班牌");
		p0.setParentId(0);
		subPositions.add(p0);
		root.setSubPositions(subPositions);
	}
	
	class PositionVo {
	    String name;
	    long parentId;
	    List<PositionVo> subPositions;
	    public PositionVo(){
	        subPositions = new ArrayList<PositionVo>();
	    }
	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public long getParentId() {
	        return parentId;
	    }

	    public void setParentId(long parentId) {
	        this.parentId = parentId;
	    }

	    public List<PositionVo> getSubPositions() {
	        return subPositions;
	    }

	    public void setSubPositions(List<PositionVo> subPositions) {
	        this.subPositions = subPositions;
	    }
	}
}
