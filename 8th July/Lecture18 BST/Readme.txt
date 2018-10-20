~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
													Lecture 18 BST - Start
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
1. Lecture 18 BST
  1.1 Context & examples - rule, recursion difference, O(h)
	1.2 ctor, find, max, min
	1.3 printrange, replaceWithSumOfLarger
	1.4 pairTargetSum (BT vs BST)
		1.4.1 fill arraylist via heapmover, sort (?), and do left right
		1.4.2 fill hashmap via heapmover, and find complements
		1.4.3 traverse and call find on complement from every spot
	1.5 lca (BT vs BST) - place where paths diverge
		1.5.1 rootToNodePaths
					Last common element in the two rootToNode arraylists.
		1.5.2 startTime & endtime list -> heapMover [list of pair of starttime and endtimes]
					What? -> Last node with startime smaller than both and endtime larger than both
					How? -> traverse the list of pairs and find last such node
					Why? -> Last node ensures the lowest in ancestry
		1.5.3 bst -> first node while going down with value between d1 and d2
	1.6 addNode, removeNode
	1.7 AVL
		1.7.1 Balanced -> O(h) to O(logn)
		1.7.2 Node - height, add & remove
		1.7.3 right rotation, left rotation
		1.7.4 left left, left right, right right, right left
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
													Lecture 18 BST - End
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
