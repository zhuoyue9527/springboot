var BinTreeNode = function(data){
	this.data = data ;
	this.leftChild = null ;
	this.rightChild = null ;
	this.parentNode = null ;
	
	
}
function Stack(){
	var items =[]; //私有变量
	
	// 从栈顶添加一个元素， 压栈
	this.push = function(item){
		items.push(item);
	}
	
	//弹出栈顶元素
	this.pop =function(){
		return items.pop();
	}
	
	//返回栈顶元素
	this.top = function(){
		return items[items.length -1];
	}
	
	//判断栈是否为空
	this.isEmpty = function(){
		return items.length == 0;
	}
	
	//返回栈的大小
	this.size = function(){
		return items.length ;
	}
	
	//清空栈
	this.clear = function(){
		return items =[] ;
	}
}


function BinaryTree(){
	var root = null ; //根节点

	this.init_tree = function(string){
		var stack = new Stack();
		var k = 0 ;
		var new_node = null ;
		
		for(var i=0 ;i<string.length;i++){
			var item = string[i];
			
			if(item =="#"){
				break;
			}
			if(item =="("){
				stack.push(new_node);
				k= 1;
			}else if(item ==","){
				k =2 ;
			}else if(item ==")"){
				stack.pop();
			}else{
				new_node = BinTreeNode(item);
				if(root ==null){
					root = new_node;
				}else{
					if(k==1){
						var top_item = stack.top();
						top_item.leftChild = new_node;
						new_node.parentNode = top_item();
					}else if(k==2){
						var top_item = stack.top();
						top_item.rightChild = new_node;
						new_node.parentNode = top_item();
					}
				}
			}
		}
	};
	
	this.get_root = function(){
		return root ;
	}
	//中序遍历  左 中 右 当前节点中间输出
	this.in_order = function(node){
		if(node == null){
			return ;
		}
		this.in_order(node.leftChild);
		console.log(node.data);
		this.in_order(node.rightChild);
		
	};
	
	//前序遍历  中 左  右 当前节点前面输出
	this.pre_order = function(node){
		if(node == null){
			return ;
		}
		console.log(node.data);
		this.pre_order(node.leftChild);
		this.pre_order(node.rightChild);
		
	};
	
	//后序遍历  左 右 中  当前节点最后输出
	this.pre_order = function(node){
		if(node == null){
			return ;
		}
		
		this.pre_order(node.leftChild);
		this.pre_order(node.rightChild);
		console.log(node.data); 
	};
	
	var tree_node_count = function(node){
		if(node == null){
			return 0;
		}
		var left_node_count = tree_node_count(node.leftChild);
		var right_node_count = tree_node_count(node.rightChild);
		return  left_node_count + right_node_count +1 ;
	};
	
	this.size = function(){
		return tree_node_count(root);
	};
	
	var tree_height = function(node){
		if(node ==null){
			return 0 ;
		}
		//先计算左子树的高度
		var left_child_height = tree_height(node.leftChild);
		
		//计算右子树
		var right_child_height = tree_height(node.rightChild);
		
		if(left_child_height > right_child_height){
			return left_child_height + 1 ;
		}else{
			return right_child_height + 1 ;
		}
		
	};
	

	
	this.height = function(){
		return tree_height(root);
	};
	
	var find_node = function(node,data){
		if(node == null){
			return null ;
		}
		//当前节点的值 
		if(node.data == data){
			return node ;
		}
		
		//先到左子树
		var left_res = find_node(node.leftChild,data);
		//找到了
		if(left_res){
			return left_res;
		}
		
		//没找到，去右子树
		return find_node(node.right,data);
		
	}
	this.find = function(data){
		find_node(root,data);
	}
	
	var mirr_1 =function(node){
		if(node ==null){
			return ;
		}
		var temp = node.leftChild;
		node.leftChild = node.rightChild;
		node.rightChild = temp;
		
		mirr_1(node.leftChild);
		mirr_1(node.rightChild);
		
	}
	var mirr_2 function(node){
		if( node ==null){
			return ;
		}
		var left = mirr_2(node.left);
		var right = mirr_2(node.right);
		
		node.leftChild = right;
		node.rightChild = left ;
		return node;
	}
	
	//非递归
	function pre_order(node){
		var stack = new Stack();
		var curr_node = node ;
		
		while(curr_node){
			console.log(curr_node);
			if(curr_node.rightChild){
				stack.push(curr_node.rightChild);
			}
			if(curr_node.leftChild){
				curr_node = curr_node.leftChild;
			}else{
				curr_node = stack.pop();
			}
		}
		
		
	}
	
	
	
};

var bt = new BinaryTree();
bt.init_tree("A(B(D,E(G,)),C(,F))#");

//var root_node = bt.get_root();
//bt.in_order(root_node);
