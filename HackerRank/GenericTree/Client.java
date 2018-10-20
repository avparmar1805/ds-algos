package GenericTree;

public class Client {
	public static void main(String[] args) throws Exception {
		// 10 3 20 2 50 0 60 0 30 3 70 0 80 2 110 0 120 0 90 0 40 1 100 0
		// 10 3 20 1 50 0 30 0 40 1 60 0
		// 10 3 20 2 50 0 60 0 30 0 40 1 70 0
		GenericTree gt = new GenericTree();

		// gt.display();
		//// System.out.println(gt.size2());
		// System.out.println(gt.max());
		// System.out.println(gt.find(0));
		// System.out.println(gt.height());

		// gt.preo();
		System.out.println();
		// gt.posto();
		 //gt.levelOzz();
		//gt.LeftView();
		gt.RightView();
		// gt.mirror();
		// System.out.println();
		// gt.removeLeaves();
		// gt.linearize();
		// gt.linearizeEff();
		//gt.display();
		// System.out.println(gt.isSymmetric());
		// gt.multiSolver(120);
		// gt.predSucc(100);
		// gt.justLarger(50);
		//System.out.println(gt.kThSmallest(3));
	}
}
