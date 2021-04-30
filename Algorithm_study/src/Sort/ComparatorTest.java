package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval {
	int start;
	int end;
	
	Interval(int s, int e){
		this.start = s;
		this.end = e;
	}
}

public class ComparatorTest {

	public static void main(String[] args) {
		
		Interval in1 = new Interval(1,3);
		Interval in2 = new Interval(2,6);
		Interval in3 = new Interval(8,10);
		Interval in4 = new Interval(15,18);
		
		List<Interval> intervals = new ArrayList<>();
		intervals.add(in4);
		intervals.add(in2);
		intervals.add(in1);
		intervals.add(in3);
		ComparatorTest a = new ComparatorTest();
		List<Interval> list = a.merge(intervals);
		a.print(list);
	}
	
	public List<Interval> merge(List<Interval> intervals){
		if(intervals.isEmpty()) return intervals;
		
		//1. sorting
		Collections.sort(intervals, comp);
		//Collections.sort(intervals,(a,b) -> a.start - b.start);
		
		List<Interval> result = new ArrayList<>();
		Interval before = intervals.get(0);
		for(int i=1; i<intervals.size();i++) {
			Interval current = intervals.get(i);
			if(before.end >= current.start) {
				before.end = Math.max(before.end, current.end);
			}else {
				result.add(before);
				before = current;
			}
		}
		if(!result.contains(before)) result.add(before);
		return result;
	}
	
	Comparator comp = new Comparator<Interval>(){
		@Override
		public int compare(Interval a, Interval b) {
			return a.start - b.start;
		}	
	};
	

//	Comparator comp2 = new Comparator<Interval>(){
//		@Override
//		public int compare(Interval a, Interval b) {
//			if(a.start < b.start ) return -1; // 오름차순
//			else if(a.start > b.start ) return 1; //내림차순
//			else return 0;
//		}
//	};
	
	void print(List<Interval> list) {
		for(int i=0; i<list.size();i++) {
			Interval in = list.get(i);
			System.out.println(in.start + " " + in.end);
		}
	}

}
