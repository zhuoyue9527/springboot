function LinkList(){
	var Node  = function(data){
		this.data = data ;
		this.next = null ;
	}
	
	var length = 0 ;
	var head = null ;
	var tail = null ;
	
	//在尾部添加一个节点
	this.append = function(data){
		//创建新节点
		var new_node = new Node(data);
		if(head == null){
			head = new_node;
			tail = new_node;
		}else{
			tail.next = new_node ;
			tail = new_node ;
		}
		
		length +=1 ;
		return true ;
	}
	
	 this.print = function(){
		 var curr_node = head ;
		 while(curr_node){
			 console.log(curr_node.data);
			 curr_node = curr_node.next;
		 }
	 }
	 
	 this.insert = function(index,data){
		 if(index <0 || index >length){
			 return false;
		 }else{
			 var new_node = new Node(data);
			 if(index == 0){
				 new_node.next = head ;
				 head = new_node ;
			 }else{
				 var insert_index = 1 ;
				 var curr_node = head ;
				 while(insert_index <index){
					 insert_index += 1;
					 curr_node = curr_node.next ;
				 }
				 
				 var next_node = curr_node.next ; 
				 curr_node.next = new_node ;
				 new_code.next = next_node ;
			 }
		 }
		 length += 1 ;
		 return true ;
	 }
	 
	 this.remove =function(index){
		 if(index <0 || index >= length ){
			 return null;
		 }else{
			 var del_node = null ;
			 if(index ==0 ){
				 del_node = head ;
				 head = head.next ;
			 }else{
//				 var del_index = 1 ;
//				 var curr_node = head ;
//				 //获取删除的前一个
//				 while(del_index < index){
//					 curr_node = curr_node.next ;
//					 del_index += 1 ;
//				 }
//				 del_node = curr_node.next ;
//				 curr_node.next = del_node.next;
				 
				 var del_index = 0 ;
				 var pre_node = null ;
				 var curr_node = head ;
				 while(del_index <index ){
					 del_index += 1 ;
					 pre_node = curr_node ;
					 curr_node = curr_node.next ;
				 }
				 
				 pre_node.next = curr_node.next ;
				 if(curr_node.next == null){
					 tail = pre_node ;
				 }
				 
			 }
		 }
		 length -= 1 ;
		 return true ;
	 }
	 
	 this.get = function(index){
		 if(index <0 || index >= length){
			 return null;
		 }
		 var curr_node = head;
		 var curr_index = 0 ;
		 while(curr_index < index){
			 curr_index += 1 ;
			 curr_node = curr_node.next ;
		 }
		 
		 return curr_index.data ;
	 }
	 
	 
}

var link = new LinkList();
link.append(2);
link.append(3); 
link.append(5); 
link.print();

//反转链表
function reverse_digui(head){
	if(head == null){
		return null ;
	}
	if(head.next == null){
		return head ;
	}
	var new_head = reverse_digui(head.next);
	head.next.next = head ;
	head.next = null ;
	return new_head ;
}
//找倒数第k个
function findindex(head,k){
	var fast = head ;
	var slow = head ;
	var step = k ;
	
	//让快的先走
	while(step > 0 && fast){
		fast = fast.next ;
		step -= 1 ;
	}
	
	if(step != 0){
		return null ;
	}else{
		//快的和慢的一起走
		while(fast && slow){
			fast = fast.next ;
			slow = slow.next ;
		}
	}
	return slow.data ;
}
//取中间值
function find_middle(head){
	var fast = head ;
	var slow = head ;
	
	while(fast.next){
		slow = slow.next ;
		fast = fast.next.next ;
	}
	return slow.data ;
}


//双向链表
function DoubleLinkList(){
	var Node = function(data){
		this.data = data ; //数据
		this.next = null ; //后驱指针
		this.pre =null ;
	}
	
	var length = 0 ;
	var head = null ;
	var tail = null ;
	
	this.append = function(data){
		var node = new Node(data);
		if(head == null){
			head = node ;
			length +=1 ;
			tail = node ;
		}else{
			tail.next = node ;
			node.pre = tail ;
			tail = node ;
			length +=1 ;
		}
	}
	this.insert = function(index,data){
		var node = new Node(data);
		if(index > length || index < 0){
			return false ;
		}
		if(index == 0 ){
			head.pre = node ;
			node.next = head ;
		}else if(index == length){
			tail.next = node ;
			node.pre = tail ;
			tail = node ;
		}else{
			var corr = get(index) ;
			var pre_data = corr.pre ;
			pre_data.next = node ;
			node.pre = pre_data ;
			node.next = corr ;
			corr.pre = node ;
		}
		length += 1 ;
		return true ;
		
	}
	this.remove = function(index){
		if(index > length || index < 0){
			return false ;
		}
		var next_code = null ;
		var corr_code = null ;
		var pre_code = null ;
		if(index == 0 ){
			next_code = head.next ;
			head = next_code ;
			head.pre = null ; 
		}else if(index == length){
			pre_code = tail.pre ;
			tail = pre_code ;
			tail.next = null ;
		}else{
			var corr_node = get(index) ;
			var pre_node = corr_node.pre;
			var next_node = corr_node.next ;
			pre_node.next = next_code ;
			next_code.pre = pre_code ;
		}
		
		
		length -= 1 ;
		return true ;
		
	}
	this.get = function(index){
		if(index > length || index < 0){
			return null ;
		}
		
		var corr_index = 0 ;
		var corr = head ;
		while(corr_index < index){
			corr = corr.next ;
			corr_index += 1 ;
		}
		
		return corr ;
	}
	
	
	
}